package com.diphlk.ecommerce.order;

import com.diphlk.ecommerce.customer.CustomerClient;
import com.diphlk.ecommerce.exception.BusinessException;
import com.diphlk.ecommerce.kafka.OrderConfirmation;
import com.diphlk.ecommerce.kafka.OrderProducer;
import com.diphlk.ecommerce.orderline.OrderLineRequest;
import com.diphlk.ecommerce.orderline.OrderLineService;
import com.diphlk.ecommerce.product.ProductClient;
import com.diphlk.ecommerce.product.PurchaseRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;

    public Integer createOrder(OrderRequest orderRequest) {
        // check the customer --> OpenFeign client to customer microservice
        var customer = this.customerClient.findCustomerById(orderRequest.customerId())
                .orElseThrow(() -> new BusinessException("Customer not found with id: " + orderRequest.customerId()));

        // check the products --> product microservice (RestTemplate)
        var purchasedProducts = this.productClient.purchaseProducts((orderRequest.products()));

        var order = this.orderRepository.save(mapper.toOrder(orderRequest));

        // persist the order
        for (PurchaseRequest purchaseRequest : orderRequest.products()) {
            //persist the order lines
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }
        // todo start the payment process

        // send the order confirmation --> notification microservice (kafka)
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        orderRequest.reference(),
                        orderRequest.amount(),
                        orderRequest.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );
        return order.getId();
    }
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(mapper::fromOrderResponse)
                .toList();
    }
    public OrderResponse getOrderById(Integer orderId) {
        return orderRepository.findById(orderId)
                .map(mapper::fromOrderResponse)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + orderId));
    }
}
