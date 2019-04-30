package dedon.motors.ims.controller;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dedon.motors.ims.application.ImsApplication;
import dedon.motors.ims.model.IMS;
import dedon.motors.ims.persistence.ImsPersistence;

public class ImsCustomerTest {
	
	private static int nextUserID = 1;

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
		int id = nextUserID++;
		
		try {
			ImsController.createCustomer(userName, customerID, id);
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
		int id = nextUserID++;
		
		String error = null;
		
		try {
			ImsController.createCustomer(userName, customerID, id);
			nextUserID++;
			ImsController.createCustomer(userName, customerID, id);
		} catch (InvalidInputException e) {
			nextUserID--;
			error = e.getMessage();
		}
		
		//check error
		assertEquals("The customer already exist.", error);
		// check model in memory
		checkResultCustomer(userName, customerID, ims, 1, 1);
	}
	
	@Test
	public void testCreateCustomerNull() {
		IMS ims = ImsApplication.getIms();
		String userName = null;
		String customerID = "customer1";
		//int id = nextUserID++;
		
		String error = null;
		try {
			ImsController.createCustomer(userName, customerID, nextUserID);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		// check error
		assertEquals("Cannot create a customer without name", error);
		// check no change in memory
		checkResultCustomer(userName, customerID, ims, 0, 0);
	}
	
	@Test
	public void testCreateCustomerEmpty() {
		IMS ims = ImsApplication.getIms();
		String userName = "";
		String customerID = "customer1";
		//int id = nextUserID++;
		
		String error = null;
		try {
			ImsController.createCustomer(userName, customerID, nextUserID);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		// check error
		assertEquals("Cannot create a customer without name", error);
		// check no change in memory
		checkResultCustomer(userName, customerID, ims, 0, 0);
	}
	
	@Test
	public void testCreateCustomerNullID() {
		IMS ims = ImsApplication.getIms();
		String userName = "customer";
		String customerID = null;
		//int id = nextUserID++;
		
		String error = null;
		try {
			ImsController.createCustomer(userName, customerID, nextUserID);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		// check error
		assertEquals("The ID of a customer cannot be empty", error);
		// check no change in memory
		checkResultCustomer(userName, customerID, ims, 0, 0);
	}
	
	@Test
	public void testCreateCustomerEmptyID() {
		IMS ims = ImsApplication.getIms();
		String userName = "customer";
		String customerID = "";
		//int id = nextUserID++;
		
		String error = null;
		try {
			ImsController.createCustomer(userName, customerID, nextUserID);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		// check error
		assertEquals("The ID of a customer cannot be empty", error);
		// check no change in memory
		checkResultCustomer(userName, customerID, ims, 0, 0);
	}
	
	@Test
	public void testDeleteCustomerSucces() {
		IMS ims = ImsApplication.getIms();
		String userName = "customer";
		String customerID = "customer1";
		//int id = nextUserID++;
		
		try {
			ImsController.createCustomer(userName, customerID, nextUserID);
		} catch (InvalidInputException e) {
			//check that no error occured.
			fail(); 
		}
		//check model in memory
		checkResultCustomer(userName, customerID, ims, 1, 1);
		
		try {
			ImsController.deleteCustomer(customerID);
		} catch (InvalidInputException e) {
			//check that no error occured.
			fail();
		}
		
		//check model in memory
		checkResultCustomer(userName, customerID, ims, 1, 0);
	}
	
	@Test
	public void testDeleteUserSuccess() {
		IMS ims = ImsApplication.getIms();
		String userName = "customer";
		String customerID = "customer1";
		//int id = nextUserID++;
		
		try {
			ImsController.createCustomer(userName, customerID, nextUserID);
		} catch (InvalidInputException e) {
			//check that no error occured.
			fail(); 
		}
		//check model in memory
		checkResultCustomer(userName, customerID, ims, 1, 1);
		
		try {
			ImsController.deleteUser(nextUserID);
		} catch (InvalidInputException e) {
			//check that no error occured.
			fail();
		}
		
		//check model in memory
		checkResultCustomer(userName, customerID, ims, 0, 0);
		
	}
	
	private void checkResultCustomer(String name, String customerID, IMS ims, int numberOfUsers, int numberOfCustomers) {
		assertEquals(numberOfUsers, ims.getUsers().size());
		assertEquals(numberOfCustomers, ims.getCustomers().size());
		if (numberOfCustomers > 0) {
			assertEquals(name, ims.getUser(0).getName());
			assertEquals(customerID, ims.getCustomer(0).getCustomerID());
			assertEquals(numberOfCustomers, ims.getCustomers().size());
			assertEquals(numberOfUsers, ims.getUsers().size());
			assertEquals(0, ims.getCustomer(0).getTransactions().size());
		}
	}
	
	
	@Test
	public void testCreateCustomerOverCharacters() {
		
		IMS ims = ImsApplication.getIms();
		String userName = "Hyacinth Chijioke Ali Hyacinth Chijioke Ali0";
		String customerID = "customer1";
		//int id = nextUserID++;
		
		String error = null;
		
		try {
			ImsController.createCustomer(userName, customerID, nextUserID);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		assertEquals("The name cannot be more than 30 characters", error);
		
		checkResultCustomer(userName, customerID, ims, 0, 0);
	}


}
