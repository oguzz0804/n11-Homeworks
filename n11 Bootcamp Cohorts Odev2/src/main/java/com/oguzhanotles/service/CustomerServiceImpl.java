package com.oguzhanotles.service;

import com.oguzhanotles.model.Customer;
import com.oguzhanotles.model.Invoice;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final List<Customer> customers;
    private final List<Invoice> invoices;

    public CustomerServiceImpl() {
        this.customers = new ArrayList<>();
        this.invoices = new ArrayList<>();
    }

    // Adding customer data
    @Override
    public void createCustomer(Customer customer) {
        customers.add(customer);
    }

    // Adding invoice data with customer id
    public void createInvoiceToCustomer(Long customerId, Invoice invoice) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                customer.addInvoice(invoice);
                invoices.add(invoice);
                return;
            }
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customers;
    }

    @Override
    public List<Customer> getCustomersWithLetterContaining(String keyword) {
        return customers.stream()
                .filter(customer -> customer.getCustomerName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Long, Double> getTotalInvoiceAmountForJune(List<Customer> customers) {
        List<Customer> juneCustomers = customers.stream()
                .filter(customer -> customer.getRegistrationDate().getMonth() == Month.JUNE)
                .toList();
        Map<Long, Double> invoiceAmountMap = new HashMap<>();
        for (Customer customer : juneCustomers) {
            double totalAmount = customer.getInvoices().stream()
                    .filter(invoice -> invoice.getDate().getMonth() == Month.JUNE)
                    .mapToDouble(Invoice::getAmount)
                    .sum();
            invoiceAmountMap.put(customer.getCustomerId(), totalAmount);
        }
        return invoiceAmountMap;
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoices;
    }

    @Override
    public List<Invoice> getInvoicesWithAmount(double amount) {
        List<Invoice> filteredInvoices = new ArrayList<>();
        for (Invoice invoice : invoices) {
            if (invoice.getAmount() > amount) {
                filteredInvoices.add(invoice);
            }
        }
        return filteredInvoices;
    }

    @Override
    public double getAverageAmountOfInvoicesWithAmount(double amount) {
        double totalAmount = 0;
        List<Invoice> filteredInvoices = getInvoicesWithAmount(amount);

        for (Invoice invoice : filteredInvoices) {
            totalAmount += invoice.getAmount();
        }
        return totalAmount / filteredInvoices.size();
    }

    @Override
    public List<String> getCustomerNamesWithInvoiceAmountLessThan(double amount) {
        List<String> customerNamesWithInvoiceAmountLessThan = new ArrayList<>();
        for(Customer customer : customers){
            boolean invoiceUnderAmount = customer.getInvoices().stream()
                    .anyMatch(invoice ->invoice.getAmount() < amount);
            if(invoiceUnderAmount){
                customerNamesWithInvoiceAmountLessThan.add(customer.getCustomerName());
            }
        }
        return customerNamesWithInvoiceAmountLessThan;
    }

    @Override
    public List<String> getSectorOfInvoiceWithAverageInvoiceAmountLessThan(double amount) {
        List<String> industries = new ArrayList<>();

        for (String industry : getIndustries()) {
            double totalAmount = 0.0;
            int invoiceCount = 0;
            //Mapping all over invoices for the same type of industry
                for (Invoice invoice : invoices) {
                    //Sum operation for the industry
                    if (invoice.getSector().equals(industry)) {
                        totalAmount += invoice.getAmount();
                        invoiceCount++;
                    }
            }
            double averageAmount = (invoiceCount == 0) ? 0 : totalAmount / invoiceCount;
            if (averageAmount < amount) {
                industries.add(industry);
            }
        }
        return industries;
    }

    public List<String> getIndustries() {
        List<String> distinctIndustries = new ArrayList<>();
        for (Customer customer : customers) {
            for (Invoice invoice : customer.getInvoices()) {
                String sector = invoice.getSector();
                if (!distinctIndustries.contains(sector)) {
                    // Creating an array for invoice sectors
                    distinctIndustries.add(sector);
                }
            }
        }
        return distinctIndustries;
    }
}
