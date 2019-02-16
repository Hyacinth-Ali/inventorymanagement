package dedon.motors.ims.controller;

import dedon.motors.ims.application.ImsApplication;
import dedon.motors.ims.model.IMS;
import dedon.motors.ims.model.Product;
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
		Product product = foundProduct(name);
		if (product != null) {
			product.delete();
		}
		try {
			ImsPersistence.save(ImsApplication.getIms());
		} catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}
	
	private static Product foundProduct(String name) {
		Product p = null;
		for (Product product : ImsApplication.getIms().getProducts()) {
			if (name.equals(product.getName())) {
				p = product;
				break;
			}
		}
		return p;
	}
	
	public static void createWarehouse() throws InvalidInputException{
		
		IMS ims = ImsApplication.getIms();
		try {
			ims.addWarehouse();
		} catch (RuntimeException e) {
			throw new InvalidInputException (e.getMessage());
		}
		
	}

}
