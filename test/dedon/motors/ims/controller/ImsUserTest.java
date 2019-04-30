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

public class ImsUserTest {


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
	public void testCreateUserSuccess() {
		IMS ims = ImsApplication.getIms();
		String name = "user";
		
		try {
			ImsController.createUser(name);
		} catch (InvalidInputException e) {
			// check that no error occurred
			fail();
		}
		
		// check model in memory
		checkResultUser(name, ims, 1);
	}
	
	@Test
	public void testCreateUserNull() {
		IMS ims = ImsApplication.getIms();
		String name = null;
		
		String error = "";
		
		try {
			ImsController.createUser(name);
		} catch (InvalidInputException e) {
			// check that no error occurred
			error = e.getMessage();
		}
		
		//checkn error
		assertEquals(error, "The name of a user cannot be empty");
		// check model in memory
		checkResultUser(name, ims, 0);
	}
	
	@Test
	public void testDeleteUserSucces() {
		IMS ims = ImsApplication.getIms();
		String name = "user";
		
		try {
			ImsController.createUser(name);
		} catch (InvalidInputException e) {
			//check that no error occured.
			fail(); 
		}
		//check model in memory
		checkResultUser(name, ims, 1);
		
		try {
			ImsController.deleteUser(ims.getUser(0));
		} catch (InvalidInputException e) {
			//check that no error occured.
			fail();
		}
		
		//check model in memory
		checkResultUser(name, ims, 0);
	}
	
	private void checkResultUser(String name, IMS ims, int numberOfUsers) {
		assertEquals(numberOfUsers, ims.getUsers().size());
		if (numberOfUsers > 0) {
			assertEquals(name, ims.getUser(0).getName());
			assertEquals(0, ims.getUser(0).getRoles().size());
		}
	}
	
	
	@Test
	public void testCreateUserEmpty() {
		IMS ims = ImsApplication.getIms();		
		String name = "";

		String error = null;
		try {
			ImsController.createUser(name);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		// check error
		assertEquals("The name of a user cannot be empty", error);
		// check no change in memory
		checkResultUser(name, ims, 0);
	}
	
	@Test
	public void testCreateProductOverCharacters() {
		IMS ims = ImsApplication.getIms();
		String name = "Hyacinth Chijioke Ali Hyacinth Chijioke Ali0";
		String error = null;
		
		try {
			ImsController.createUser(name);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		assertEquals("The name cannot be more than 30 characters", error);
		
		checkResultUser(name, ims, 0);
	}

}
