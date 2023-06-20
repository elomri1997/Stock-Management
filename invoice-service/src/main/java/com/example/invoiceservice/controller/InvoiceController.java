package com.example.invoiceservice.controller;

import com.example.invoiceservice.entities.Invoice;
import com.example.invoiceservice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/invoices")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping()
    public List<Invoice> getAllInvoices(){
        return invoiceService.getAllInvoices();
    }

    @GetMapping("/{id-invoice}")
    public Optional<Invoice> getInvoice(@PathVariable("id-invoice") long id){
        return invoiceService.getInvoice(id);
    }

    @PostMapping("")
    public Invoice addInvoice(@RequestBody Invoice invoice){
        return invoiceService.addInvoice(invoice);
    }
}
