package dedon.motors.ims.controller;

import java.util.ArrayList;
import java.util.List;

import dedon.motors.ims.application.ImsApplication;
import dedon.motors.ims.model.Customer;
import dedon.motors.ims.model.Employee;
import dedon.motors.ims.model.IMS;
import dedon.motors.ims.model.Item;
import dedon.motors.ims.model.Manager;
import dedon.motors.ims.model.Product;
import dedon.motors.ims.model.Transaction;
import dedon.motors.ims.model.User;
import dedon.motors.ims.model.UserRole;
import dedon.motors.ims.persistence.ImsPersistence;

public class ImsController {
	
	/******************************/
	//Product CRUD, Begin
	/******************************/
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
			/*for (Product p : ims.getProducts()) {
				System.out.println("Name : " + p.getName());
			}*/		
		} catch (RuntimeException e) {
			throw new InvalidInputException (e.getMessage());
		}
	}
	
	/**
	 * Delete an instance of a product.
	 * @param name of the product.
	 */
	public static void deleteProduct(String name) throws InvalidInputException {
		Product product = findProduct(name);
		if (product != null) {
			product.delete();
			try {
				ImsPersistence.save(ImsApplication.getIms());
			} catch (RuntimeException e) {
				throw new InvalidInputException(e.getMessage());
			}
		}
		
	}
	
	private static Product findProduct(String name) {
		Product p = null;
		IMS ims = ImsApplication.getIms();
		for (Product prod : ims.getProducts()) {
			if (prod.getName().equals(name)) {
				p = prod;
				break;
			}
		}
		return p;
	}
	
	/**
	 * Query method to retrieve products in data.
	 * @return product list
	 */
	public static List<TOProduct> getProducts() {
		ArrayList<TOProduct> products = new ArrayList<TOProduct>();
		for (Product p : ImsApplication.getIms().getProducts()) {
			TOProduct toProduct = new TOProduct(p.getName());
			products.add(toProduct);
		}
		return products;
	}
	
	/**
	 * Updates product
	 */
	public static void updateProduct(String oldName, String newName) throws InvalidInputException {
		Product product = findProduct(oldName);
		if (product != null) {
			try {
				product.setName(newName);
				ImsPersistence.save(ImsApplication.getIms());
			} catch (RuntimeException e) {
				throw new InvalidInputException(e.getMessage());
			}
			
		}
	}
	
	/******************************/
	//Product CRUD, End
	/******************************/
	
	/******************************/
	//Customer CRUD, Begin
	/******************************/
	
	/**
	 * Query method for Customer
	 * @return list of customers
	 */
	public static List<TOCustomer> getCustomers() {
		ArrayList<TOCustomer> customers = new ArrayList<TOCustomer>();
		for (User user : ImsApplication.getIms().getUsers()) {
			for (UserRole role : user.getRoles()) {
				if (role instanceof Customer) {
					Customer c = (Customer)role;
					TOCustomer toCustomer = new TOCustomer(c.getCustomerID(), user.getName());
					customers.add(toCustomer);
				}
			}
			
		}
		return customers;
	}
	
	private static Customer findCustomer(String id) {
		Customer c = null;
		for (Customer customer : ImsApplication.getIms().getCustomers()) {
			if (id == customer.getCustomerID()) {
				c = customer;
				break;
			}
		}
		return c;
	}
	
	 /**
	 * Create an object of a customer.
	 * @param name of the customer.
	 * @param id of the customer.
	 * @throws InvalidInputException throws an exception.
	 */
	public static void createCustomer(String customerID, User user) throws InvalidInputException{
		IMS ims = ImsApplication.getIms();
		String error = "";
		
		if (customerID == null) {
			error = "The ID of a customer cannot be empty";
		} else if (customerID == "") {
			error = "The ID of a customer cannot be empty";
		}
		if (error.length() > 0) {
			throw new InvalidInputException(error);
		}
		
		try {
			ims.addCustomer(user, customerID);
			ImsPersistence.save(ims);
		} catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
		
	}
	
	
	public static void deleteCustomer(String id) throws InvalidInputException{
		
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
	
	public static void upDateCustomerID(String oldID, String newID) 
			throws InvalidInputException {
		Customer customer = findCustomer(oldID);
		if (customer != null) {
			try {
				customer.setCustomerID(newID);
				ImsPersistence.save(ImsApplication.getIms());
			} catch (RuntimeException e) {
				throw new InvalidInputException(e.getMessage());
			}
			
		} else {
			throw new InvalidInputException("The customer does not exist.");
		}
		
	}
	
	public static void upDateCustomerName(String id, String newName) 
			throws InvalidInputException {
		Customer customer = findCustomer(id);
		if (customer != null) {
			try {
				customer.getUser().setName(newName);
				ImsPersistence.save(ImsApplication.getIms());
			} catch (RuntimeException e) {
				throw new InvalidInputException(e.getMessage());
			}
			
		} else {
			throw new InvalidInputException("The customer does not exist.");
		}
		
	}
	
	/******************************/
	//Customer CRUD, End
	/******************************/
	
	/*********************************/
	// User CRUD, Begin
	/**********************************/
 
	/**
	 * Delete instance of a user and all its roles
	 * @param id
	 * @throws InvalidInputException
	 */
	public static void deleteUser(UserRole role) throws InvalidInputException{
		User user = role.getUser();
		
		try {
			user.delete();
			ImsPersistence.save(ImsApplication.getIms());
		} catch(RuntimeException e) {
			throw new InvalidInputException (e.getMessage());
		}
	}
	
	
	public static void createUser(String name) throws InvalidInputException {
		String error = "";
		
		if (name == null || name == "") {
			error = "A user name cannot be empty.";
		} 
		
		if (error.length() > 0  ) {
			throw new InvalidInputException(error);
		}
		IMS ims = ImsApplication.getIms();
		
		try {
			ims.addUser(name);
		} catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}
	
	public static void updateUser(UserRole role, String newName) throws InvalidInputException {
		User user = role.getUser();
		
		try {
			user.setName(newName);
			ImsPersistence.save(ImsApplication.getIms());
		} catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}
	
	/*********************************/
	// User CRUD, Begin
	/**********************************/
	
	/*********************************/
	// Manager CRUD, Begin
	/**********************************/
	
	/**
	 * Query method for Manager
	 * @return list of Manager
	 */
	public static List<TOManager> getManagers() {
		ArrayList<TOManager> managers = new ArrayList<TOManager>();
		for (User user : ImsApplication.getIms().getUsers()) {
			for (UserRole role : user.getRoles()) {
				if (role instanceof Manager) {
					Manager m = (Manager)role;
					TOManager toManager = new TOManager(m.getUser().getName(), m.getUserName(),
							m.getPassword());
					managers.add(toManager);
				}
			}
			
		}
		return managers;
	}
	
	private static Manager findManager(String userName) {
		Manager manager = null;
		for (Manager m : ImsApplication.getIms().getManagers()) {
			if (userName.equals(m.getUserName())) {
				manager = m;
				break;
			}
		}
		return manager;
	}
	
	 /**
	 * Create an object of a Manager.
	 * @param name of the customer.
	 * @param id of the customer.
	 * @throws InvalidInputException throws an exception.
	 */
	public static void createManager(String userName, String password, User user) throws InvalidInputException{
		IMS ims = ImsApplication.getIms();
		String error = "";
		
		if (userName == null || userName == "") {
			error = "The manager user name cannot be empty";
		} else if (password == null || password == "") {
			error = "You cannot create a manager with empty password";
		}
		if (error.length() > 0) {
			throw new InvalidInputException(error);
		}
		
		try {
			ims.addManager(user, userName, password);
			ImsPersistence.save(ims);
		} catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
		
	}
	
	
	public static void deleteManager(String userName) throws InvalidInputException{
		
		Manager manager = findManager(userName);
		if (manager != null) {
			manager.delete();
		}
		try {
			ImsPersistence.save(ImsApplication.getIms());
		} catch (RuntimeException e) {
			throw new InvalidInputException (e.getMessage());
		}
	}
	
	public static void upDateManagerUserName(String oldUserName, String newUserName) 
			throws InvalidInputException {
		Manager manager = findManager(oldUserName);
		if (manager != null) {
			try {
				manager.setUserName(newUserName);
				ImsPersistence.save(ImsApplication.getIms());
			} catch (RuntimeException e) {
				throw new InvalidInputException(e.getMessage());
			}
			
		} else {
			throw new InvalidInputException("The customer does not exist.");
		}
		
	}
	
	public static void upDateManagerPassword(String oldUserName, String newPassword) 
			throws InvalidInputException {
		Manager manager = findManager(oldUserName);
		if (manager != null) {
			try {
				manager.setPassword(newPassword);
				ImsPersistence.save(ImsApplication.getIms());
			} catch (RuntimeException e) {
				throw new InvalidInputException(e.getMessage());
			}
			
		} else {
			throw new InvalidInputException("The customer does not exist.");
		}
		
	}
	
	public static void upDateManagerName(String oldUserName, String newName) 
			throws InvalidInputException {
		Manager manager = findManager(oldUserName);
		if (manager != null) {
			try {
				manager.getUser().setName(newName);
				ImsPersistence.save(ImsApplication.getIms());
			} catch (RuntimeException e) {
				throw new InvalidInputException(e.getMessage());
			}
			
		} else {
			throw new InvalidInputException("The manager does not exist.");
		}
		
	}
	
	
	
	/*********************************/
	// Manager CRUD, End
	/**********************************/
	
	/*********************************/
	// Item CRUD, Begin
	/**********************************/
	
	/**
	 * Creates an instance of an Item.
	 * @param price of the item.
	 * @throws InvalidInputException and exception that can be thrown.
	 */
	public static void createItem(Product product) throws InvalidInputException {
		IMS ims = ImsApplication.getIms();
		try {
			product.addItem();
			ImsPersistence.save(ims);
		} catch (RuntimeException e) {
			throw new InvalidInputException (e.getMessage());
		}
	}

	
	/*********************************/
	// Item CRUD, End
	/**********************************/

	/*********************************/
	// Transaction CRUD, Begin
	/**********************************/
	public static List<TOTransaction> getTransactions() {
		ArrayList<TOTransaction> transactions = new ArrayList<TOTransaction>();
		for (Transaction t : ImsApplication.getIms().getTransactions()) {
			TOTransaction toTransaction = new TOTransaction(t.getId(), t.getCustomer().getFirstName() + 
					" Transaction");
			transactions.add(toTransaction);
		}
		return transactions;
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
