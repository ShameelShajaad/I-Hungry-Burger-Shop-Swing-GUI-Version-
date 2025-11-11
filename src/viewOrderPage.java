import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class viewOrderPage extends JFrame{
	private ImageIcon burgerLogo;
	
	private JPanel leftPanel;
	private JPanel rightPanel;
	
	private JLabel logo;
	
	private JButton deliveredOrdersBtn;
	private JButton processingOrdersBtn;
	private JButton cancelledOrdersBtn;
	private JButton exitBtn;
	
	private Color mainColor;
	private Color btnColor;
	private Color txtColor;
	
	private Font btnFont;
	
	viewOrderPage(){
		setSize(1100,700);
		setTitle("View Order");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		leftPanel=new JPanel(new BorderLayout());
		leftPanel.setPreferredSize(new Dimension(600, 700));
		Color logoBackGroundColor=new Color(245, 230, 204);
		leftPanel.setBackground(logoBackGroundColor);
		
		burgerLogo=new ImageIcon("BurgerShop.png");
		logo=new JLabel(burgerLogo);
		logo.setHorizontalAlignment(JLabel.CENTER);
        logo.setVerticalAlignment(JLabel.CENTER);
		
		leftPanel.add(logo, BorderLayout.CENTER);
		add(leftPanel, BorderLayout.WEST);
		
		mainColor=new Color(194, 166, 118);
		rightPanel=new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.setPreferredSize(new Dimension(500, 700));
		rightPanel.setBackground(mainColor);
		
		deliveredOrdersBtn=new JButton("Delivered Orders");
		processingOrdersBtn=new JButton("Processing Orders");
		cancelledOrdersBtn=new JButton("Cancelled Orders");;
		exitBtn=new JButton("Exit");
		
		btnFont=new Font("",1,25);
		btnColor=new Color(150, 142, 126);
		txtColor=new Color(255,255,255);
		
		JButton[] btn={deliveredOrdersBtn,processingOrdersBtn,cancelledOrdersBtn,exitBtn};
		
		for (int i = 0; i < 4; i++){
			btn[i].setFont(btnFont);
			btn[i].setBackground(btnColor);
			btn[i].setForeground(txtColor);
			btn[i].setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		
		rightPanel.add(Box.createVerticalGlue());
		for (int i = 0; i < 2; i++){
			rightPanel.add(btn[i]);
			rightPanel.add(Box.createRigidArea(new Dimension(0,20)));
		}
		rightPanel.add(cancelledOrdersBtn);
		rightPanel.add(Box.createVerticalGlue());
		
		rightPanel.add(exitBtn);
		
		add(rightPanel, BorderLayout.CENTER);
		
		deliveredOrdersBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ect){
				dispose();
				new viewDeliveredOrdersPage().setVisible(true);
			}
		});
		processingOrdersBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ect){
				dispose();
				new viewProcessingOrdersPage().setVisible(true);
			}
		});
		cancelledOrdersBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ect){
				dispose();
				new viewCancelledOrdersPage().setVisible(true);
			}
		});
		exitBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ect){
				dispose();
				new mainPage().setVisible(true);
			}
		});
	}
}
