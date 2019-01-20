package dedon.motors.ims.application;

import java.awt.EventQueue;
import java.io.Serializable;

import dedon.motors.ims.model.IMS;
import dedon.motors.ims.page.ImsPage;
import dedon.motors.ims.persistence.PersistenceObjectStream;

public class ImsApplication implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2683593616927798071L;
	/**
	 * 
	 */
	private static IMS ims;
	private static String filename = "data.txt";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImsPage window = new ImsPage();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static IMS getEms() {
		if (ims == null) {
			// load model
			ims = load();
		}
 		return ims;
	}
	
	public static void save() {
		PersistenceObjectStream.serialize(ims);
	}
	
	public static IMS load() {
		PersistenceObjectStream.setFilename(filename);
		ims = (IMS) PersistenceObjectStream.deserialize();
		// model cannot be loaded - create empty BTMS
		if (ims == null) {
			ims = new IMS();
		}
		return ims;
	}
	
	public static void setFilename(String newFilename) {
		filename = newFilename;
	}

}
