package com.oguzhanotles.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
public class Invoice {
    private Long invoiceId;
    private LocalDate date;
    private double amount;
    private String description;
    private String sector;

    public Invoice(Long invoiceId, LocalDate date, double amount, String description, String sector) {
        this.invoiceId = invoiceId;
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.sector = sector;
    }
}
