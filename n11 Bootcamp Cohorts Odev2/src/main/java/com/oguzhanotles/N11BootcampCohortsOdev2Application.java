package com.oguzhanotles;

import com.oguzhanotles.model.Customer;
import com.oguzhanotles.model.Invoice;
import com.oguzhanotles.service.CustomerServiceImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class N11BootcampCohortsOdev2Application {

	public static void main(String[] args) {
		CustomerServiceImpl customerService = new CustomerServiceImpl();

		// Calling methods in the main function
		createCustomers(customerService);
		addInvoicesToCustomers(customerService);
		getAllCustomers(customerService);
		getAllInvoices(customerService);
		getCustomersWithLetterContaining(customerService);
		getTotalInvoiceAmountForJune(customerService);
		getInvoicesWithAmount(customerService);
		getAverageAmountOfInvoicesWithAmount(customerService);
		getCustomerNamesWithInvoiceAmountLessThan(customerService);
		getSectorOfInvoiceWithAverageInvoiceAmountLessThan(customerService);
	}

	private static void createCustomers(CustomerServiceImpl customerService) {
		customerService.createCustomer(new Customer(1L, "Oğuzhan", LocalDate.of(2024, 1, 1)));
		customerService.createCustomer(new Customer(2L, "Veysel", LocalDate.of(2023, 5, 6)));
		customerService.createCustomer(new Customer(3L, "Ulaş", LocalDate.of(2023, 6, 7)));
		customerService.createCustomer(new Customer(4L, "Berkay", LocalDate.of(2022, 6, 8)));
		customerService.createCustomer(new Customer(5L, "Ferhat", LocalDate.of(2023, 6, 15)));
		customerService.createCustomer(new Customer(6L, "İlkin", LocalDate.of(2021, 6, 14)));
		customerService.createCustomer(new Customer(7L, "Serken", LocalDate.of(2022, 6, 25)));
		customerService.createCustomer(new Customer(8L, "Ceyda", LocalDate.of(2023, 6, 29)));
		customerService.createCustomer(new Customer(9L, "Canan", LocalDate.of(2020, 6, 1)));
	}

	private static void addInvoicesToCustomers(CustomerServiceImpl customerService){
		customerService.createInvoiceToCustomer(1L, new Invoice(507L, LocalDate.of(2024, 1, 2), 5000.8, "", "Clothes"));
		customerService.createInvoiceToCustomer(2L, new Invoice(399L, LocalDate.of(2023, 8, 10), 475.5, "", "Bill"));
		customerService.createInvoiceToCustomer(3L, new Invoice(258L, LocalDate.of(2023, 6, 15), 5562.6, "", "Clothes"));
		customerService.createInvoiceToCustomer(3L, new Invoice(259L, LocalDate.of(2023, 6, 15), 3250.6, "", "Tech"));
		customerService.createInvoiceToCustomer(4L, new Invoice(104L, LocalDate.of(2022, 6, 18), 7500.99, "", "Tech"));
		customerService.createInvoiceToCustomer(5L, new Invoice(657L, LocalDate.of(2024, 6, 15), 1563.5, "", "Clothes"));
		customerService.createInvoiceToCustomer(6L, new Invoice(964L, LocalDate.of(2024, 6, 15), 140.4, "", "Bill"));
		customerService.createInvoiceToCustomer(7L, new Invoice(857L, LocalDate.of(2022, 6, 27), 958.5, "", "Tech"));
		customerService.createInvoiceToCustomer(8L, new Invoice(352L, LocalDate.of(2023, 6, 25), 1578.5, "", "Furniture"));
		customerService.createInvoiceToCustomer(9L, new Invoice(596L, LocalDate.of(2020, 6, 29), 1899.0, "", "Food"));
	}

	private static void getAllCustomers(CustomerServiceImpl customerService) {
		System.out.println("Customer List =>");
		List<Customer> customerList = customerService.getAllCustomers();

		for (Customer customer : customerList) {
			System.out.println(customer.toString());
		}
		System.out.println();
	}

	private static void getAllInvoices(CustomerServiceImpl customerService){
		System.out.println("Invoices List =>");
		List<Invoice> invoicesList = customerService.getAllInvoices();

		for (Invoice invoice : invoicesList) {
			System.out.println(invoice);
		}
		System.out.println();
	}

	private static void getCustomersWithLetterContaining(CustomerServiceImpl customerService){
		System.out.println("Customers with 'C': ");
		List<Customer> customersWithC = customerService.getCustomersWithLetterContaining("C");
		if(customersWithC.isEmpty()){
			System.out.println(" There is no customers with letter containing C");
		}else{
			for (Customer customer : customersWithC) {
				System.out.println(customer);
			}
		}
		System.out.println();
	}

	private static void getTotalInvoiceAmountForJune(CustomerServiceImpl customerService){
		Map<Long, Double> totalInvoiceAmountsForJune = customerService.getTotalInvoiceAmountForJune(customerService.getAllCustomers());
		System.out.println("Total invoice amounts for June: ");
		for (Map.Entry<Long, Double> entry : totalInvoiceAmountsForJune.entrySet()) {
			System.out.println("Customer ID: " + entry.getKey() + ", Total Invoice Amount: " + entry.getValue());
		}
		System.out.println();
	}

	private static void getInvoicesWithAmount(CustomerServiceImpl customerService) {
		System.out.println("Invoices over amount 1500:");
		List<Invoice> filteredInvoices = customerService.getInvoicesWithAmount(1500);
		for (Invoice invoice : filteredInvoices) {
			System.out.println(invoice);
		}
		System.out.println();
	}

	private static void getAverageAmountOfInvoicesWithAmount(CustomerServiceImpl customerService){
		System.out.println("Average invoice over 1500 TL");
		double filteredInvoices = customerService.getAverageAmountOfInvoicesWithAmount(1500);
		System.out.printf("%.3f%n",filteredInvoices);
		System.out.println();
	}

	private static void getCustomerNamesWithInvoiceAmountLessThan(CustomerServiceImpl customerService) {
		System.out.println("Customer Names With Invoice Amount Less Than 500 =>");
		List<String> customerNames = customerService.getCustomerNamesWithInvoiceAmountLessThan(500);
		for(String customerName: customerNames){
			System.out.println(customerName);
		}
		System.out.println();
	}

	private static void getSectorOfInvoiceWithAverageInvoiceAmountLessThan(CustomerServiceImpl customerService) {
	System.out.println("Sectors of Invoice with Average Invoice Amount Less Than 750");
	List<String> sectorNames = customerService.getSectorOfInvoiceWithAverageInvoiceAmountLessThan(750);
	for(String sectorName : sectorNames){
		System.out.println("Sector:"+sectorName);
	}
	}
}
