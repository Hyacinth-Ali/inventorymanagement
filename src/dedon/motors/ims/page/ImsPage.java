package dedon.motors.ims.page;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.FontUIResource;

import dedon.motors.ims.controller.ImsController;
import dedon.motors.ims.controller.InvalidInputException;
import dedon.motors.ims.controller.TOCustomer;
import dedon.motors.ims.controller.TOProduct;
import dedon.motors.ims.controller.TOTransaction;

public class ImsPage extends JFrame {
	
	//data elements
	private JLabel errorMessage;
	
	//product
	private JLabel productNameLabel;
	private JTextField productNameTextField;
	private JButton productAddButton;
	private JButton productUpdateButton;
	
	private JLabel productDeleteLabel;
	private JComboBox<String> productDeleteComboBox;
	private JButton productDeleteButton;
	
	//customer
	private JLabel customerFirstNameLabel;
	private JTextField customerFirstNameTextField;
	private JLabel customerSurNameLabel;
	private JTextField customerSurNameTextField;
	private JButton customerAddButton;
	
	private JLabel customerSelectLabel;
	private JComboBox<String> customerSelectComboBox;
	private JButton customerDeleteButton;
	private JButton createTransactionButton;
	
	//transaction
	private JLabel selectProductLabel;
	private JComboBox<String> selectProductComboBox;
	private JLabel unitPriceLabel;
	private JTextField unitPriceTextField;
	private JLabel quantityLabel;
	private JTextField quantityTextField;
	private JButton addSelectedProductButton;
	
	private JLabel selectTransactionLabel;
	private JComboBox<String> selectTransactionComboBox;
	private JButton submitButton;	
	private JButton clearButton;
	
	//delete transaction
	private JLabel deleteTransactionLabel;
	private JComboBox<String> deleteTransactionComboBox;
	private JButton deleteTransactionButton;
	
	
	//data elements
	private String error = null;
	
	//select product
	private HashMap<Integer, String> productList;
	
	//select customer
	private HashMap<Integer, Integer> customerList;
	
	//transaction
	private HashMap<Integer, String> availableProducts;
	private HashMap<Integer, Integer> availableTransactions;
	
	//delete transaction
	private HashMap<Integer, TOCustomer> transactionList ;

	/**
	 * Create the application.
	 */
	public ImsPage() {
		initComponents();
		refreshData(); 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponents() {
		
		//elements for error message
		errorMessage = new JLabel();
		errorMessage.setForeground(Color.RED);
		
		//elements for product
		productNameLabel = new JLabel();
		productNameLabel.setText("Name");
		//productNameLabel.setFont(new FontUIResource("Serif", Font.BOLD, 16));
		productNameTextField = new JTextField();
		productAddButton = new JButton();
		productAddButton.setText("Add Product");
		productUpdateButton = new JButton();
		productUpdateButton.setText("UPDATE");
		
		productDeleteLabel = new JLabel();
		productDeleteLabel.setText("Select");
		//productDeleteJLabel.setFont(new FontUIResource("Serif", Font.BOLD, 16));
		productDeleteComboBox = new JComboBox<String>(new String[0]);
		productDeleteButton = new JButton();
		productDeleteButton.setText("Delete Product");
		
		//elements for customer
		customerFirstNameLabel = new JLabel();
		//customerFirstNameLabel.setSize(1000, 200);
		customerFirstNameLabel.setText("First Name");
		customerFirstNameTextField = new JTextField();
		customerSurNameLabel = new JLabel();
		customerSurNameLabel.setText("Sur-Name");
		customerSurNameTextField = new JTextField();
		customerAddButton = new JButton();
		customerAddButton.setText("Add Customer");
		
		customerSelectLabel = new JLabel();
		customerSelectLabel.setText("Select Customer");
		customerSelectComboBox = new JComboBox<String>(new String[0]);
		customerDeleteButton = new JButton();
		customerDeleteButton.setText("Delete");
		createTransactionButton = new JButton();
		createTransactionButton.setText("Create Transaction");
		
		//elements for transaction		
		selectProductLabel = new JLabel();
		selectProductLabel.setText("Select Product");
		//selectProductLabel.setFont(new FontUIResource("Serif", Font.BOLD, 16));
		selectProductComboBox  = new JComboBox<String>(new String [0]);
		unitPriceLabel = new JLabel();
		unitPriceLabel.setText("Unit Price");
		unitPriceTextField = new JTextField();
		quantityLabel = new JLabel();
		quantityLabel.setText("Quantity");
		quantityTextField = new JTextField();
		addSelectedProductButton = new JButton();
		addSelectedProductButton.setText("Add Product");
		
		selectTransactionLabel = new JLabel();
		selectTransactionLabel.setText("Select Transaction");
		selectTransactionComboBox = new JComboBox<String>(new String [0]);
		submitButton = new JButton();
		submitButton.setText("Submit");
		clearButton = new JButton();
		clearButton.setText("Clear");
		
		//delete transaction
		deleteTransactionLabel = new JLabel();
		deleteTransactionLabel.setText("Select Transaction");
		deleteTransactionComboBox = new JComboBox<String>(new String [0]);
		deleteTransactionButton = new JButton();
		deleteTransactionButton.setText("Delete Transaction");
		
		//global settings
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("De-Don Motor : Inventory Management System");
		setLocation(300, 200);
		//setBounds(200, 200, 670, 400);
		//setResizable(false);
		
		// listeners for product
		productAddButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
			productAddButtonActionPerformed(evt);
				}
		});
		
		//suspended
		/*productUpdateButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				productUpdateButtonActionPerformed(evt);
			}
		});*/
		
		productDeleteButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				productDeleteButtonActionPerformed(evt);
			}
		});
		
		// listeners for customers
		customerAddButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				customerAddButtonActionPerformed(evt);
			}
		});
		
		customerDeleteButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//customerDeleteButtonActionPerformed(evt);
			}
		});
		
		createTransactionButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				createTransactionButtonActionPerformed(evt);
			}
		});
		
		//listeners for transaction
		addSelectedProductButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//addSelectedProductButtonActionPerformed(evt);
			}
		});
		
		submitButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//submitButtonActionPerformed(evt);
			}
		});
		
		clearButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//clearButtonActionPerformed(evt);
			}
		});
		
		deleteTransactionButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//deleteTransactionButtonActionPerformed(evt);
			}
		});
		
		// horizontal line elements
		JSeparator firstLine = new JSeparator();
		JSeparator secondLine = new JSeparator();
		JSeparator thirdLine = new JSeparator();
		JSeparator fourthLine = new JSeparator();
					                                                                                                                  
		//layout
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(
				layout.createParallelGroup()
					.addGroup(layout.createParallelGroup()
							.addComponent(errorMessage)
							.addComponent(firstLine)
							.addComponent(secondLine)
							.addComponent(thirdLine)
							.addComponent(fourthLine)
							
							)
					.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup()
									.addComponent(productNameLabel)
									.addComponent(productDeleteLabel)
									.addComponent(selectProductLabel)
									.addComponent(unitPriceLabel)
									.addComponent(quantityLabel)
									.addComponent(deleteTransactionLabel))
							.addGroup(layout.createParallelGroup()
									.addComponent(productNameTextField)
									.addGroup(layout.createSequentialGroup()
											.addComponent(productAddButton)
											.addComponent(productUpdateButton))
									.addComponent(productDeleteComboBox)
									.addComponent(productDeleteButton)
									.addComponent(selectProductComboBox)
									.addComponent(unitPriceTextField)
									.addComponent(quantityTextField)
									.addComponent(addSelectedProductButton)
									.addComponent(deleteTransactionComboBox)
									.addComponent(deleteTransactionButton))
							.addGroup(layout.createParallelGroup()
									.addComponent(customerFirstNameLabel)
									.addComponent(customerSurNameLabel)
									.addComponent(customerSelectLabel)
									.addComponent(selectTransactionLabel))
							.addGroup(layout.createParallelGroup()
									.addComponent(customerFirstNameTextField)
									.addComponent(customerSurNameTextField)
									.addComponent(customerAddButton)
									.addComponent(customerSelectComboBox)
									.addGroup(layout.createSequentialGroup()
											.addComponent(customerDeleteButton)
											.addComponent(createTransactionButton))
									.addComponent(selectTransactionComboBox)
									.addComponent(submitButton)
									.addComponent(clearButton)))
					
				);
		
		layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] {productNameLabel, productAddButton});
		layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] {customerSurNameTextField, customerFirstNameTextField});
		layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {customerAddButton, submitButton, clearButton});
		layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {productDeleteButton, addSelectedProductButton, deleteTransactionButton});
		//layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {productAddButton, productSubmitButton, productClearSelectionButton});
		
		layout.setVerticalGroup(
				layout.createSequentialGroup()
					.addComponent(errorMessage)
					.addComponent(firstLine)
					.addGroup(layout.createParallelGroup()
							.addComponent(customerFirstNameLabel)
							.addComponent(customerFirstNameTextField))
					.addGroup(layout.createParallelGroup()
							.addComponent(productNameLabel)
							.addComponent(productNameTextField)
							.addComponent(customerSurNameLabel)
							.addComponent(customerSurNameTextField))
					.addGroup(layout.createParallelGroup()
							.addComponent(productAddButton)
							.addComponent(productUpdateButton)
							.addComponent(customerAddButton))
					.addGroup(layout.createParallelGroup()
							.addComponent(productDeleteLabel)
							.addComponent(productDeleteComboBox)
							.addComponent(customerSelectLabel)
							.addComponent(customerSelectComboBox))
					.addGroup(layout.createParallelGroup()
							.addComponent(productDeleteButton)
							.addComponent(customerDeleteButton)
							.addComponent(createTransactionButton))
					.addComponent(secondLine)
					.addGroup(layout.createParallelGroup()
							.addComponent(selectProductLabel)
							.addComponent(selectProductComboBox)
							.addComponent(selectTransactionLabel)
							.addComponent(selectTransactionComboBox))
					.addGroup(layout.createParallelGroup()
							.addComponent(unitPriceLabel)
							.addComponent(unitPriceTextField)
							.addComponent(submitButton))
					.addGroup(layout.createParallelGroup()
							.addComponent(quantityLabel)
							.addComponent(quantityTextField)
							.addComponent(clearButton))
					.addComponent(addSelectedProductButton)
					.addComponent(thirdLine)
					.addGroup(layout.createParallelGroup()
							.addComponent(deleteTransactionLabel)
							.addComponent(deleteTransactionComboBox))
					.addComponent(deleteTransactionButton)
					.addComponent(fourthLine)
				);
		pack();
	}
	
	private void productAddButtonActionPerformed(java.awt.event.ActionEvent evt) {
		//clear the error
		error = "";
		
		try {
			ImsController.createProduct(productNameTextField.getText());
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		//update visuals
		refreshData();
		
	}
	
	/*private void deleteTransactionButtonActionPerformed(java.awt.event.ActionEvent evt) {
		//clear error message
		error = "";
		int selectedTransaction = productDeleteComboBox.getSelectedIndex();
		if (selectedProduct < 0) {
			error = "Product needs to be selected!";
		}
		try {
			ImsController.deleteProduct(productList.get(selectedProduct));
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		refreshData();
	}*/
	
	private void productDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
		//clear error message
		error = "";
		int selectedProduct = productDeleteComboBox.getSelectedIndex();
		if (selectedProduct < 0) {
			error = "Product needs to be selected!";
		}
		try {
			ImsController.deleteProduct(productList.get(selectedProduct));
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		refreshData();
	}
	
	
	private void customerAddButtonActionPerformed(java.awt.event.ActionEvent evt) {
		//clear the error
		error = "";
		try {
			ImsController.createCustomer(customerFirstNameTextField.getText(), customerSurNameTextField.getText());
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		//update visuals
		refreshData();
		
	}
	
	private void createTransactionButtonActionPerformed(java.awt.event.ActionEvent evt) {
		//clear the error
		error = "";
		
		try {
			int id = customerList.get(customerSelectComboBox.getSelectedIndex());
			ImsController.createTransaction(id);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		//update visuals
		refreshData();
		
	}
	
	private void refreshData() {
		errorMessage.setText(error);
		if (error == null || error.length() == 0) {
			//populate page with data
			//product
			productNameTextField.setText("");
			
			productList = new HashMap<Integer, String>();
			productDeleteComboBox.removeAllItems();
			Integer index = 0;
			for (TOProduct product : ImsController.getProducts()) {
				productList.put(index, product.getName());
				productDeleteComboBox.addItem(product.getName());
				index++;
			}
			productDeleteComboBox.setSelectedIndex(-1);
			
			availableProducts = new HashMap<Integer, String>();
			selectProductComboBox.removeAllItems();
			index = 0;
			for (TOProduct product : ImsController.getProducts()) {
				availableProducts.put(index, product.getName());
				selectProductComboBox.addItem(product.getName());
				index++;
			}
			selectProductComboBox.setSelectedIndex(-1);
			
			//customer
			customerFirstNameTextField.setText("");
			customerSurNameTextField.setText("");
			
			customerList = new HashMap<Integer, Integer>();
			customerSelectComboBox.removeAllItems();
			index = 0;
			for (TOCustomer customer : ImsController.getCustomers()) {
				customerList.put(index, customer.getId());
				customerSelectComboBox.addItem("#" + customer.getId() + " " + customer.getFirstName());
				index++;
			}
			customerSelectComboBox.setSelectedIndex(-1);
			
			//transaction
			availableTransactions = new HashMap<Integer, Integer>();
			selectTransactionComboBox.removeAllItems();
			index = 0;
			for (TOTransaction t : ImsController.getTransactions()) {
				availableTransactions.put(index, t.getId());
				selectTransactionComboBox.addItem(t.getName());
				index++;
			}
			selectTransactionComboBox.setSelectedIndex(-1);
			
		}
	}

}
