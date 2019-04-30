package dedon.motors.ims.controller;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dedon.motors.ims.application.ImsApplication;
import dedon.motors.ims.model.IMS;
import dedon.motors.ims.model.User;
import dedon.motors.ims.persistence.ImsPersistence;

public class ImsCustomerTest {

	@BeforeClass
	public static void setUpOnce() {
		String filename = "testdata.ims";
		ImsPersistence.setFilename(filename);
		File f = new File(filename);
		f.delete();
	}
	
	@Before
	public void setUp() {
		// clear all data
		IMS ims = ImsApplication.getIms();
		ims.delete();
	}
	
	@Test
	public void testCreateCustomerSuccess() {
		IMS ims = ImsApplication.getIms();
		String userName = "customer";
		String customerID = "customer1";
		
		try {
			ImsController.createUser(userName);
		} catch (InvalidInputException e) {
			fail();
		}		
		try {
			ImsController.createCustomer(customerID, ims.getUser(0));
		} catch (InvalidInputException e) {
			fail();
		}
		// check model in memory
		checkResultCustomer(userName, customerID, ims, 1, 1);
	}
	
	@Test
	public void testCreateCustomerDuplicateID() {
		IMS ims = ImsApplication.getIms();
		String userName = "customer";
		String customerID = "customer1";
		
		String error = "";
		
		try {
			ImsController.createUser(userName);
		} catch (InvalidInputException e) {
			fail();
		}	
		// check model in memory
		checkResultCustomer(userName, customerID, ims, 1, 0);
		try {
			ImsController.createCustomer(customerID, ims.getUser(0));
		} catch (InvalidInputException e) {
			fail();
		}
		// check model in memory
		checkResultCustomer(userName, customerID, ims, 1, 1);
		
		try {
			ImsController.createCustomer(customerID, ims.getUser(0));
		}catch (InvalidInputException e) {
			error = e.getMessage();
		}
		//check error
		assertEquals("A customer with the same ID already exist", error);
		// check model in memory
		checkResultCustomer(userName, customerID, ims, 1, 1);
	}

	
	@Test
	public void testCreateCustomerNullID() {
		IMS ims = ImsApplication.getIms();
		String userName = "customer";
		String customerID = null;
		String error = "";
		try {
			ImsController.createUser(userName);
		} catch (InvalidInputException e) {
			fail();
		}		
		checkResultCustomer(userName, customerID, ims, 1, 0);
		try {
			ImsController.createCustomer(customerID, ims.getUser(0));
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
			error = e.getMessage();
		}	
		// check model in memory
		checkResultCustomer(userName, customerID, ims, 1, 0);
	
		//check error
		assertEquals("The ID of a customer cannot be empty", error);
	
	}
	
	@Test
	public void testCreateCustomerEmptyID() {
		IMS ims = ImsApplication.getIms();
		String userName = "customer";
		String customerID = "";
		String error = "";
		User user = null;
		try {
			ImsController.createUser(userName);
		} catch (InvalidInputException e) {
			fail();
		}		
		checkResultCustomer(userName, customerID, ims, 1, 0);
		user = ims.getUser(0);
		try {
			ImsController.createCustomer(customerID, user);
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
			error = e.getMessage();
		}	
		// check model in memory
		checkResultCustomer(userName, customerID, ims, 1, 0);
	
		//check error
		assertEquals("The ID of a customer cannot be empty", error);
	}
	
	@Test
	public void testDeleteCustomerSucces() {
		IMS ims = ImsApplication.getIms();
		String userName = "customer";
		String customerID = "customer1";
		User user = null;
		
		try {
			ImsController.createUser(userName);
		} catch (InvalidInputException e) {
			fail();
		}		
		checkResultCustomer(userName, customerID, ims, 1, 0);
		user = ims.getUser(0);
		try {
			ImsController.createCustomer(customerID, user);
		} catch (InvalidInputException e) {
			fail();
		}	
		// check model in memory
		checkResultCustomer(userName, customerID, ims, 1, 1);
		
		try {
			ImsController.deleteCustomer(customerID);
		} catch (InvalidInputException e) {
			fail();
		}	
		
		//check model in memory
		checkResultCustomer(userName, customerID, ims, 1, 0);
	}
	
	private void checkResultCustomer(String name, String customerID, IMS ims, int numberOfUsers, int numberOfCustomers) {
		assertEquals(numberOfUsers, ims.getUsers().size());
		assertEquals(numberOfCustomers, ims.getCustomers().size());
		if (numberOfCustomers > 0) {
			assertEquals(name, ims.getUser(0).getName());
			assertEquals(customerID, ims.getCustomer(0).getCustomerID());
			assertEquals(0, ims.getCustomer(0).getTransactions().size());
		}
		assertEquals(0, ims.getTransactions().size());
	}


}
