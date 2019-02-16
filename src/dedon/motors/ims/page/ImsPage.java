package dedon.motors.ims.page;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dedon.motors.ims.controller.ImsController;
import dedon.motors.ims.controller.InvalidInputException;

public class ImsPage extends JFrame {
	
	//data elements
	private JLabel errorMessage;
	
	//create products ui
	private JLabel productNameLabel;
	private JTextField productNameTextField;
	private JButton productAddButton;
	
	//view products and select ui
	private JLabel productSelectLabel;
	private JComboBox<String> productSelectComboBox;
	private JTextField productQuantityTextField;
	private JButton productSelectButton;
	private JLabel enterQuantityLabel;
	
	//data elements
	private String error = null;

	/**
	 * Create the application.
	 */
	public ImsPage() {
		initComponents();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponents() {
		
		productNameLabel = new JLabel("Name");
		productNameTextField = new JTextField();
		productAddButton = new JButton("ADD");
		
		productSelectLabel = new JLabel("Select");
		productSelectComboBox = new JComboBox<String>(new String[0]);
		productQuantityTextField  = new JTextField();
		productSelectButton = new JButton("Select");
		enterQuantityLabel = new JLabel();
		enterQuantityLabel.setText("Enter Quantity");
		
		errorMessage = new JLabel();
		errorMessage.setForeground(Color.RED);
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("De-Don Motor : Inventory Management System");
		setSize(600, 600);
		
		// listeners for driver
		productAddButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
			productAddButtonActionPerformed(evt);
				}
		});
		
		
		//layout
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		//setBounds(100, 100, 936, 592);
		layout.setHorizontalGroup(
				layout.createParallelGroup()
					.addComponent(errorMessage)
					.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup()
								.addComponent(productNameLabel)
								.addComponent(productSelectLabel))
						.addGroup(layout.createParallelGroup()
								.addComponent(productNameTextField, 200, 200, 400)
								.addComponent(productAddButton)
								.addComponent(productSelectComboBox, 200, 200, 400)
								.addGroup(layout.createSequentialGroup()
										.addComponent(productQuantityTextField, 110, 110, 220)
										.addComponent(productSelectButton, 70, 70, 140)
						   				)
								)
						)
				);
		
		layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] {productNameLabel, productSelectLabel});
		layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] {productNameTextField, productAddButton, productSelectComboBox});
		
		layout.setVerticalGroup(
				layout.createSequentialGroup()
					.addComponent(errorMessage)
					.addGroup(layout.createParallelGroup()
							.addComponent(productNameLabel)
							.addComponent(productNameTextField)
							)
					.addComponent(productAddButton)
					.addGroup(layout.createParallelGroup()
							.addComponent(productSelectLabel)
							.addComponent(productSelectComboBox)
							)
					.addGroup(layout.createParallelGroup()
							.addComponent(productQuantityTextField)
							.addComponent(productSelectButton)
							)
				);
		//pack();
	}
	
	private void productAddButtonActionPerformed(java.awt.event.ActionEvent evt) {
		//clear the error
		error = null;
		
		try {
			ImsController.createProduct(productNameTextField.getText());
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		//update visuals
		refreshData();
		
	}
	
	private void refreshData() {
		errorMessage.setText(error);
	}

}
