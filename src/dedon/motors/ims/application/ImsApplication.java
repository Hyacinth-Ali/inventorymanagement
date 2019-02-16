package dedon.motors.ims.application;

import dedon.motors.ims.model.IMS;
import dedon.motors.ims.page.ImsPage;
import dedon.motors.ims.persistence.ImsPersistence;

public class ImsApplication {
	
	private static IMS ims;

	public static void main(String[] args) {
		
		//start application
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImsPage().setVisible(true);
            }
        });

	}
	
	public static IMS getIms() {
		if (ims == null) {
			//load model
			ims = ImsPersistence.load();
		}
		return ims;
	}

}
