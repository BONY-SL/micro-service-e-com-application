package com.diphlk.ecommerce.email;

import lombok.Getter;

@Getter
public enum EmailTemplate {
    PAYMENT_CONFIRMATION("payment-confirmation.html","Payment Successfully Processed"),
    ORDER_CONFIRMATION("order-confirmation.html","Order Successfully Placed")
    ;

    private final String templateName;

    private final String subject;

    EmailTemplate(String templateName, String subject) {
        this.templateName = templateName;
        this.subject = subject;
    }
}
