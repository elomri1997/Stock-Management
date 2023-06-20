package com.example.invoiceservice.service;

import com.example.invoiceservice.entities.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {

    List<Invoice> getAllInvoices();
    Optional<Invoice> getInvoice(Long id);
    Invoice addInvoice(Invoice invoice);

}
