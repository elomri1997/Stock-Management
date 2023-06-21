package com.example.invoiceservice.controller;

import com.example.domains.dto.InvoiceEvent;
import com.example.invoiceservice.entities.Invoice;
import com.example.invoiceservice.kafka.InvoiceProducer;
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

    private InvoiceProducer invoiceProducer;

    public InvoiceController(InvoiceProducer invoiceProducer) {
        this.invoiceProducer = invoiceProducer;
    }


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
        InvoiceEvent invoiceEvent = new InvoiceEvent();
        invoiceEvent.setMessage("Invoice confirmed");
        invoiceEvent.setEmail(invoice.getEmail());
        invoiceEvent.setQuantity(invoice.getQuantity());
        invoiceEvent.setPrice(invoice.getPrice());
        invoiceProducer.sendMessage(invoiceEvent);
        return invoiceService.addInvoice(invoice);
    }
}
