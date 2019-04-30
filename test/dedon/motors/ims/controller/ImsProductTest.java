package dedon.motors.ims.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dedon.motors.ims.application.ImsApplication;
import dedon.motors.ims.model.IMS;
import dedon.motors.ims.persistence.ImsPersistence;

public class ImsProductTest {
	
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
	public void testCreateProductSuccess() {
		IMS ims = ImsApplication.getIms();
		String name = "product";
		double price = 100;
		
		try {
			ImsController.createProduct(name, price);
		} catch (InvalidInputException e) {
			// check that no error occurred
			fail();
		}
		
		// check model in memory
		checkResultProduct(name, price, ims, 1);
	}
	
	@Test
	public void testCreateProductNull() {
		IMS ims = ImsApplication.getIms();
		String name = null;
		double price = 100;
		String error = null;
		try {
			ImsController.createProduct(name, price);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		// check error
		assertEquals("The name of a product cannot be empty", error);
		// check no change in memory
		checkResultProduct(name, price, ims, 0);
	}
	
	@Test
	public void testDeleteProductSucces() {
		IMS ims = ImsApplication.getIms();
		String name = "product";
		double price = 100;
		
		try {
			ImsController.createProduct(name, price);
		} catch (InvalidInputException e) {
			//check that no error occured.
			fail(); 
		}
		//check model in memory
		checkResultProduct(name, price, ims, 1);
		
		try {
			ImsController.deleteProduct(name);
		} catch (InvalidInputException e) {
			//check that no error occured.
			fail();
		}
		
		//check model in memory
		checkResultProduct(name, price, ims, 0);
	}
	
	private void checkResultProduct(String name, double price, IMS ims, int numberOfProducts) {
		assertEquals(numberOfProducts, ims.getProducts().size());
		if (numberOfProducts > 0) {
			assertEquals(name, ims.getProduct(0).getName());
			assertEquals(name, ims.getProduct(0).getName());
			assertEquals(0, ims.getProduct(0).getItems().size());
		}
		assertEquals(null, ims.getWarehouse());
	}
	
	@Test
	public void testCreateProductEmpty() {
		IMS ims = ImsApplication.getIms();		
		String name = "";
		double price = 100;

		String error = null;
		try {
			ImsController.createProduct(name, price);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		// check error
		assertEquals("The name of a product cannot be empty", error);
		// check no change in memory
		checkResultProduct(name, price, ims, 0);
	}
	
	@Test
	public void testCreateProductZeroPrice() {
		IMS ims = ImsApplication.getIms();		
		String name = "product";
		double price = 0;

		String error = null;
		
		try {
			ImsController.createProduct(name, price);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		// check error
		assertEquals("The price of a product cannot be zero", error);
		// check no change in memory
		checkResultProduct(name, price, ims, 0);
	}
	
	@Test
	public void testCreateProductNegativePrice() {
		IMS ims = ImsApplication.getIms();		
		String name = "product";
		double price = -12;

		String error = null;
		
		try {
			ImsController.createProduct(name, price);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		// check error
		assertEquals("The price of a product cannot be negative", error);
		// check no change in memory
		checkResultProduct(name, price, ims, 0);
	}
	
	@Test
	public void testCreateProductOverCharacters() {
		IMS ims = ImsApplication.getIms();
		String name = "Hyacinth Chijioke Ali Hyacinth Chijioke Ali0";
		double price = 100;
		String error = null;
		
		try {
			ImsController.createProduct(name, price);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		assertEquals("Product character cannot be more than 25", error);
		
		checkResultProduct(name, price, ims, 0);
	}


}
