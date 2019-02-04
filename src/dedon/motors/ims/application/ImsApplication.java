package dedon.motors.ims.application;

import dedon.motors.ims.page.ImsPage;

public class ImsApplication {

	public static void main(String[] args) {
		
		//start application
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImsPage().setVisible(true);
            }
        });

	}

}
