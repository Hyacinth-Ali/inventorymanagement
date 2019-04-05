package dedon.motors.ims.page;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TestUI extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestUI frame = new TestUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(0, 16, 92, 212);
		contentPane.add(panel);
		
		JLabel label1 = new JLabel("ONE");
		label1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				switchPanel(panel_1);
			}
		});
		
		
		JLabel label2 = new JLabel("TWO");
		label2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanel(panel_2);
			}
		});
		
		JLabel lblThree = new JLabel("THREE");
		lblThree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanel(panel_3);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label1)
						.addComponent(label2)
						.addComponent(lblThree))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblThree)
					.addContainerGap(118, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(93, 16, 320, 212);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setForeground(Color.RED);
		layeredPane.add(panel_1, "name_867226702730900");
		
		JLabel lblJpanelOne = new JLabel("JPanel ONE");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(61)
					.addComponent(lblJpanelOne)
					.addContainerGap(190, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(60)
					.addComponent(lblJpanelOne)
					.addContainerGap(132, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.CYAN);
		layeredPane.add(panel_2, "name_867230961371100");
		
		JLabel lblJpanelTwo = new JLabel("JPanel TWO");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(87)
					.addComponent(lblJpanelTwo)
					.addContainerGap(164, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(83)
					.addComponent(lblJpanelTwo)
					.addContainerGap(109, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		panel_3 = new JPanel();
		layeredPane.add(panel_3, "name_867234557546200");
		
		JLabel lblJpanelThree = new JLabel("JPanel THREE");
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(119)
					.addComponent(lblJpanelThree)
					.addContainerGap(132, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(87)
					.addComponent(lblJpanelThree)
					.addContainerGap(105, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
	}
	
	public void switchPanel(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
}
