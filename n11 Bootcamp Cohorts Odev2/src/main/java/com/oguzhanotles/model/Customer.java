package com.oguzhanotles.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    private Long customerId;
    private String customerName;
    private LocalDate registrationDate;
    List<Invoice> invoices;

    public Customer(Long customerId,String customerName, LocalDate registrationDate) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.registrationDate = registrationDate;
        // Creating invoices for every customer with customer id
        this.invoices = new ArrayList<>();
    }

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    public String toString(){
        return "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", registrationDate=" + registrationDate +
                ", Invoice" + invoices;
    }
}
