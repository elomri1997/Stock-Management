package com.example.domains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceEvent {

    private String message;
    private String email;
    private int quantity;
    private double price;

}
