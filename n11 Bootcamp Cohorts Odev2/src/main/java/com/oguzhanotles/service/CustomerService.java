package com.oguzhanotles.service;

import com.oguzhanotles.model.Customer;
import com.oguzhanotles.model.Invoice;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    List<Customer> getAllCustomers();
    void createCustomer(Customer customer);
    void createInvoiceToCustomer(Long customerId, Invoice invoice);
    List<Customer> getCustomersWithLetterContaining(String keyword);
    Map<Long, Double> getTotalInvoiceAmountForJune(List<Customer> customers);
    List<Invoice> getAllInvoices();
    List<Invoice> getInvoicesWithAmount(double amount);
    double getAverageAmountOfInvoicesWithAmount(double amount);
    List<String> getCustomerNamesWithInvoiceAmountLessThan(double amount);
    List<String> getSectorOfInvoiceWithAverageInvoiceAmountLessThan(double amount);
    List<String> getIndustries();
}
