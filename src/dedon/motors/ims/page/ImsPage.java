package dedon.motors.ims.page;

import java.awt.Color;
import java.util.HashMap;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dedon.motors.ims.controller.ImsController;
import dedon.motors.ims.controller.InvalidInputException;

public class ImsPage extends JFrame {
	
	//data elements
	private JLabel errorMessage;
	
	//product
	private JLabel productNameLabel;
	private JTextField productNameTextField;
	private JButton productAddButton;
	private JLabel productSelectLabel;
	private JComboBox<String> productSelectComboBox;
	private JButton productSubmitButton;
	private JLabel productQuantityLabel;
	private JTextField productQuantityTextField;
	private JButton productClearSelectionButton;
	
	
	//data elements
	private String error = null;
	
	//select product
	private HashMap<Integer, String> products;

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
		
		//elements for error message
		errorMessage = new JLabel();
		errorMessage.setForeground(Color.RED);
		
		//elements for products
		productNameLabel = new JLabel();
		productNameLabel.setText("Name");
		productNameTextField = new JTextField();
		productAddButton = new JButton();
		productAddButton.setText("ADD");
		productSelectLabel = new JLabel();
		productSelectLabel.setText("Select");
		productSelectComboBox = new JComboBox<String>(new String[0]);
		productSubmitButton = new JButton();
		productSubmitButton.setText("Submit");
		productQuantityLabel = new JLabel();
		productQuantityLabel.setText("Quantity");
		productQuantityTextField  = new JTextField();
		productClearSelectionButton = new JButton();
		productClearSelectionButton.setText("Clear");
		
		//global settings
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("De-Don Motor : Inventory Management System");
		//setSize(600, 600);
		
		// listeners for product
		productAddButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
			productAddButtonActionPerformed(evt);
				}
		});
		
		productSubmitButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
		productSubmitButtonActionPerformed(evt);
			}
		});
		
		productAddButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
		productClearSelectionButtonActionPerformed(evt);
			}
		});
		
		// horizontal line elements
		JSeparator horizontalLineTop = new JSeparator();
		JSeparator horizontalLineMiddle = new JSeparator();
		JSeparator horizontalLineBottom = new JSeparator();
				
				                                                                                                                  
		//layout
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		//setBounds(100, 100, 936, 592);
		layout.setHorizontalGroup(
				layout.createParallelGroup()
					.addComponent(errorMessage)
					.addComponent(horizontalLineTop)
					.addComponent(horizontalLineMiddle)
					.addComponent(horizontalLineBottom)
					.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createSequentialGroup()
								.addComponent(productNameLabel)
								.addComponent(productNameTextField)
								.addComponent(productAddButton))
						.addGroup(layout.createParallelGroup()
								.addGroup(layout.createSequentialGroup()
										.addComponent(productSelectLabel)
										.addComponent(productSelectComboBox)
										.addComponent(productSubmitButton))
								.addGroup(layout.createSequentialGroup()
										.addComponent(productQuantityLabel)
										.addComponent(productQuantityTextField)
										.addComponent(productClearSelectionButton))
								)
						)
				);
		
		layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] {productNameLabel, productAddButton});
		layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] {productSelectComboBox, productSubmitButton, productQuantityTextField,
				productClearSelectionButton});
		layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {productNameLabel, productSelectLabel, productQuantityLabel});
		layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {productNameTextField, productSelectComboBox, productQuantityTextField});
		layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {productAddButton, productSubmitButton, productClearSelectionButton});
		
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
