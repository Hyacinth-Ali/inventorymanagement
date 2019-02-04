package dedon.motors.ims.page;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ImsPage extends JFrame {
	
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
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("De-Don Motor : Inventory Management System");
		setSize(600, 200);
		
		//layout
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		//setBounds(100, 100, 936, 592);
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup()
								.addComponent(productNameLabel)
								.addComponent(productSelectLabel))
						.addGroup(layout.createParallelGroup()
								.addComponent(productNameTextField, 200, 200, 200)
								.addComponent(productAddButton)
								.addComponent(productSelectComboBox, 200, 200, 200)
								.addGroup(layout.createSequentialGroup()
										.addComponent(productQuantityTextField, 110, 110, 110)
										.addComponent(productSelectButton, 70, 70, 100)
										)
								)
				);
		
		layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] {productNameLabel, productSelectLabel});
		layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] {productNameTextField, productAddButton, productSelectComboBox});
		
		layout.setVerticalGroup(
				layout.createSequentialGroup()
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

}
