import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class placeOrderPage extends JFrame{
	private JPanel headerPanel;
	private JPanel centerPanel;
	private JPanel orderIDPanel;
	private JPanel customerIDPanel;
	private JPanel customerNamePanel;
	private JPanel qtyPanel;
	private JPanel totalPanel;
	private JPanel southPanel;
	
	private JLabel header;
	private JLabel lblOrderID;
	private JLabel lblCustomerID;
	private JLabel lblCustomerName;
	private JLabel lblQty;
	private JLabel lblTotal;
	
	private JTextField orderID;
	private JTextField customerID;
	private JTextField customerName;
	private JTextField qty;
	private JTextField total;
	
	private JButton placeOrderBtn;
	private JButton backToHomePageBtn;
	private JButton cancelBtn;
	
	placeOrderPage(){
		setSize(1100,700);
		setTitle("Place Order");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		headerPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		headerPanel.setBackground(new Color(150, 142, 126));
		
		header=new JLabel("Place Order");
		header.setFont(new Font("",1,45));
		header.setForeground(Color.WHITE);
		headerPanel.add(header);
		
		add("North", headerPanel);
		
		centerPanel=new JPanel(new GridLayout(5,2,5,5));
		centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
		
		lblOrderID=new JLabel("Order ID");
		lblOrderID.setFont(new Font("",1,25));
		centerPanel.add(lblOrderID);
		
		orderIDPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		orderID=new JTextField(4);
		orderID.setFont(new Font("",1,25));
		orderID.setText(burgerOrders.newOrderID());
		orderID.setEditable(false);
		orderIDPanel.add(orderID);
		centerPanel.add(orderIDPanel);
		
		lblCustomerID=new JLabel("Customer ID");
		lblCustomerID.setFont(new Font("",1,25));
		centerPanel.add(lblCustomerID);
		
		customerIDPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		customerID=new JTextField(4);
		customerID.setFont(new Font("",1,25));
		customerID.setText(burgerOrders.newCustomerID());
		customerID.setEditable(false);
		customerIDPanel.add(customerID);
		centerPanel.add(customerIDPanel);
		
		lblCustomerName=new JLabel("Customer Name");
		lblCustomerName.setFont(new Font("",1,25));
		centerPanel.add(lblCustomerName);
		
		customerNamePanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		customerName=new JTextField(14);
		customerName.setFont(new Font("",1,25));
		customerNamePanel.add(customerName);
		centerPanel.add(customerNamePanel);
		
		lblQty=new JLabel("Burger Quantity");
		lblQty.setFont(new Font("",1,25));
		centerPanel.add(lblQty);
		
		qtyPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		qty=new JTextField(2);
		qty.setFont(new Font("",1,25));
		qtyPanel.add(qty);
		centerPanel.add(qtyPanel);
		
		add("Center", centerPanel);
		
		southPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		backToHomePageBtn=new JButton("Back To HomePage");
		backToHomePageBtn.setFont(new Font("",1,25));
		backToHomePageBtn.setBackground(new Color(150, 142, 126));
		backToHomePageBtn.setForeground(Color.WHITE);
		southPanel.add(backToHomePageBtn);
		southPanel.add(Box.createRigidArea(new Dimension(20,0)));
		
		placeOrderBtn=new JButton("Place Order");
		placeOrderBtn.setFont(new Font("",1,25));
		placeOrderBtn.setBackground(new Color(57, 224, 45));
		placeOrderBtn.setForeground(Color.WHITE);
		southPanel.add(placeOrderBtn);
		southPanel.add(Box.createRigidArea(new Dimension(20,0)));
		
		cancelBtn=new JButton("Cancel");
		cancelBtn.setFont(new Font("",1,25));
		cancelBtn.setBackground(new Color(150, 142, 126));
		cancelBtn.setForeground(Color.WHITE);
		southPanel.add(cancelBtn);
		southPanel.add(Box.createRigidArea(new Dimension(20,0)));
		
		add("South", southPanel);
		
		backToHomePageBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
				new mainPage().setVisible(true);
			}
		});
		
		cancelBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
				new mainPage().setVisible(true);
			}
		});
		
		placeOrderBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String id=orderID.getText();
				String cusID=customerID.getText();
				String cusName=customerName.getText();
				int quantity=Integer.parseInt(qty.getText());
				double tot=quantity*Burger.BurgerPrice;
				
				Burger newOrder=new Burger(id,cusID,cusName,quantity,tot,"PREPARING");
				burgerOrders.addNewOrder(newOrder);
				JOptionPane.showMessageDialog(null,"Order Added to System Successfully");
				orderID.setText(burgerOrders.newOrderID());
				customerID.setText(burgerOrders.newCustomerID());
				customerName.setText("");
				qty.setText("");
			}
		});
	}
}
