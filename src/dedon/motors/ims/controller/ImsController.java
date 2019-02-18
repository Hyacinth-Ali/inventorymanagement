package dedon.motors.ims.controller;

import java.util.ArrayList;
import java.util.List;

import dedon.motors.ims.application.ImsApplication;
import dedon.motors.ims.model.Customer;
import dedon.motors.ims.model.IMS;
import dedon.motors.ims.model.Product;
import dedon.motors.ims.model.TOCustomer;
import dedon.motors.ims.model.TOProduct;
import dedon.motors.ims.model.TOTransaction;
import dedon.motors.ims.model.Transaction;
import dedon.motors.ims.persistence.ImsPersistence;

public class ImsController {
	
	/**
	 * Creates an instance of a product.
	 * @param name of the product.
	 * @throws InvalidInputException and exception that can be thrown.
	 */
	public static void createProduct(String name) throws InvalidInputException {
		IMS ims = ImsApplication.getIms();
		try {
			ims.addProduct(name);
			ImsPersistence.save(ims);
			System.out.println("You just created a product with name : " + name);
			for (Product p : ims.getProducts()) {
				System.out.println("Name : " + p.getName());
			}
			
		} catch (RuntimeException e) {
			throw new InvalidInputException (e.getMessage());
		}
	}
	
	/**
	 * Delete an instance of a product.
	 * @param name of the product.
	 */
	public static void deleteProduct(String name) throws InvalidInputException {
		Product product = Product.getWithName(name);
		if (product != null) {
			product.delete();
			try {
				ImsPersistence.save(ImsApplication.getIms());
			} catch (RuntimeException e) {
				throw new InvalidInputException(e.getMessage());
			}
		}
		
	}
	
	public static List<TOProduct> getProducts() {
		ArrayList<TOProduct> products = new ArrayList<TOProduct>();
		for (Product p : ImsApplication.getIms().getProducts()) {
			TOProduct toProduct = new TOProduct(p.getName(), p.getUnitprice(), p.getQuantity());
			products.add(toProduct);
		}
		return products;
	}
	
	public static List<TOCustomer> getCustomers() {
		ArrayList<TOCustomer> customers = new ArrayList<TOCustomer>();
		for (Customer c : ImsApplication.getIms().getCustomers()) {
			TOCustomer toCustomer = new TOCustomer(c.getId(), c.getFirstName());
			customers.add(toCustomer);
		}
		return customers;
	}
	
	public static List<TOTransaction> getTransactions() {
		ArrayList<TOTransaction> transactions = new ArrayList<TOTransaction>();
		for (Transaction t : ImsApplication.getIms().getTransactions()) {
			TOTransaction toTransaction = new TOTransaction(t.getId(), t.getCustomer().getFirstName() + 
					" Transaction");
			transactions.add(toTransaction);
		}
		return transactions;
	}
	
	private static Customer findCustomer(int id) {
		Customer c = null;
		for (Customer customer : ImsApplication.getIms().getCustomers()) {
			if (id == customer.getId()) {
				c = customer;
				break;
			}
		}
		return c;
	}
	
	private static Transaction findTransaction(int id) {
		Transaction t = null;
		for (Transaction transaction : ImsApplication.getIms().getTransactions()) {
			if (id == transaction.getId()) {
				t = transaction;
				break;
			}
		}
		return t;
	}
	
	//customer
	/**
	 * Create an object of a customer.
	 * @param firstName of the customer.
	 * @param surName of the customer.
	 * @throws InvalidInputException throws an exception.
	 */
	public static void createCustomer(String firstName, String surName) throws InvalidInputException{
		IMS ims = ImsApplication.getIms();
		try {
			ims.addCustomer(firstName, surName);
			ImsPersistence.save(ims);
		} catch (RuntimeException e) {
			throw new InvalidInputException (e.getMessage());
		}
		
	}
	
	public static void deleteCustomer(int id) throws InvalidInputException{
		Customer customer = findCustomer(id);
		if (customer != null) {
			customer.delete();
		}
		try {
			ImsPersistence.save(ImsApplication.getIms());
		} catch (RuntimeException e) {
			throw new InvalidInputException (e.getMessage());
		}
	}
	
	/**
	 * Create an instance of a transaction.
	 * @param customer the buyer.
	 */
	public static void createTransaction(int customerID) throws InvalidInputException {
		IMS ims = ImsApplication.getIms();
		try {
			ims.addTransaction(findCustomer(customerID));
			ImsPersistence.save(ims);
		} catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}
	
	public static void addProduct(Transaction transaction, Product product, int unitPrice, int quantity) {
		Product dProduct = null;
		for (Product p : ImsApplication.getIms().getProducts()) {
			if (p.equals(product)) {
				dProduct = p;
				dProduct.setUnitprice(unitPrice);
				dProduct.setQuantity(quantity);
				break;
			}
		}
		transaction.addProduct(dProduct);
	}
	
	public static void deleteTransaction(int id) throws InvalidInputException{
		Transaction transaction = findTransaction(id);
		if (transaction != null) {
			transaction.delete();
		}
		try {
			ImsPersistence.save(ImsApplication.getIms());
		} catch (RuntimeException e) {
			throw new InvalidInputException (e.getMessage());
		}
	}
	
	public static void submitSelection(Transaction transaction) {
		int number = 1;
		for (Product product : transaction.getProducts()) {
			int totalAmount = product.getQuantity() * product.getUnitprice();
			System.out.println(number + " " + product.getName() + " " + product.getUnitprice() + " " +
					totalAmount);
			number++;
		}
	}
	
	public static void clearSelection(Transaction transaction) {
		transaction.getProducts().clear();
	}

}
