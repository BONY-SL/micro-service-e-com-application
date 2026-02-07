package com.diphlk.ecommerce.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        String id,

        @NotNull(message = "Customer First name is required")
        String firstname,
        @NotNull(message = "Customer Last name is required")
        String lastname,
        @NotNull(message = "Customer Email is required")
        @Email(message = "Invalid email format")
        String email,
        Address address
) {
}
