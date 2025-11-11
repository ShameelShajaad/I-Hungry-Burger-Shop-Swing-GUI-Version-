import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class mainPage extends JFrame{
	private ImageIcon mainLogo;
	private ImageIcon burgerLogo;
	
	private JPanel leftPanel;
	private JPanel rightPanel;
	
	private JLabel logo;
	
	private JButton placeOrderBtn;
	private JButton bestCustomerBtn;
	private JButton searchOrderBtn;
	private JButton searchCustomerBtn;
	private JButton viewOrdersBtn;
	private JButton updateOrderDetailsBtn;
	private JButton exitBtn;
	
	private Color mainColor;
	private Color btnColor;
	private Color txtColor;
	
	private Font btnFont;
	
	mainPage(){
		setSize(1100,700);
		setTitle("Main");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		mainLogo=new ImageIcon("logo.png");
		setIconImage(mainLogo.getImage());
		
		//left Panel
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
		
		//Right Panel
		mainColor=new Color(194, 166, 118);
		rightPanel=new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.setPreferredSize(new Dimension(500, 700));
		rightPanel.setBackground(mainColor);
		
		placeOrderBtn=new JButton("Place Order");
		bestCustomerBtn=new JButton("Search Best Customer");
		searchOrderBtn=new JButton("Search Order");
		searchCustomerBtn=new JButton("Search Customer");
		viewOrdersBtn=new JButton("View Orders");
		updateOrderDetailsBtn=new JButton("Update Order Details");
		exitBtn=new JButton("Exit");
		
		btnFont=new Font("",1,25);
		btnColor=new Color(150, 142, 126);
		txtColor=new Color(255,255,255);
		
		JButton[] btn={placeOrderBtn,bestCustomerBtn,searchOrderBtn,searchCustomerBtn,viewOrdersBtn,updateOrderDetailsBtn,exitBtn};
		
		for (int i = 0; i < 7; i++){
			btn[i].setFont(btnFont);
			btn[i].setBackground(btnColor);
			btn[i].setForeground(txtColor);
			btn[i].setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		
		rightPanel.add(Box.createVerticalGlue());
		for (int i = 0; i < 5; i++){
			rightPanel.add(btn[i]);
			rightPanel.add(Box.createRigidArea(new Dimension(0,20)));
		}
		rightPanel.add(updateOrderDetailsBtn);
		rightPanel.add(Box.createVerticalGlue());
		
		rightPanel.add(exitBtn);
		
		add(rightPanel, BorderLayout.CENTER);
		
		placeOrderBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ect){
				dispose();
				new placeOrderPage().setVisible(true);
			}
		});
		bestCustomerBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ect){
				dispose();
				new bestCustomerPage().setVisible(true);
			}
		});
		searchOrderBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ect){
				dispose();
				new searchOrderPage().setVisible(true);
			}
		});
		searchCustomerBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ect){
				dispose();
				new searchCustomerPage().setVisible(true);
			}
		});
		viewOrdersBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ect){
				dispose();
				new viewOrderPage().setVisible(true);
			}
		});
		updateOrderDetailsBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ect){
				dispose();
				new updateOrderDetailsPage().setVisible(true);
			}
		});
		exitBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ect){
				System.out.println("\n\t\tExited.....\n");
				System.exit(0);
			}
		});
	}
}
