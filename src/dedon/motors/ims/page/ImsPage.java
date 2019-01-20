package dedon.motors.ims.page;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;

public class ImsPage {

	private JFrame frmInventoryManagementSystem;

	/**
	 * Create the application.
	 */
	public ImsPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 936, 592);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}

	public void setFrame(JFrame frame) {
        this.frmInventoryManagementSystem = frame;
        frmInventoryManagementSystem.setTitle("DE-DON MOTORS - Inventory Management System");
    }
    
    public JFrame getFrame() {
    	return frmInventoryManagementSystem;
    }
}
