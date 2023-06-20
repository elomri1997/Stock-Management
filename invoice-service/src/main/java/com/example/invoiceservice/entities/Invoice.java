package com.example.invoiceservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long clientId;
    private String code;
    private String adresse;
    private String tel;
    private String email;
    private String taxIdNumber;
    private float price;
    private int quantity;

    @Temporal(TemporalType.DATE)
    private Date invoiceDate;


}
