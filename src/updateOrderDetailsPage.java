import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class updateOrderDetailsPage extends JFrame{
	private JPanel headerPanel;
	private JPanel centerPanel;
	private JPanel statusPanel;
	private JPanel orderIDPanel;
	private JPanel customerIDPanel;
	private JPanel customerNamePanel;
	private JPanel qtyPanel;
	private JPanel southPanel;
	
	private JLabel header;
	
	private JMenuBar orderStatus;
	private JMenu status;
	
	private JMenuItem delivered;
	private JMenuItem processing;
	private JMenuItem cancelled;
	
	private JLabel lblOrderStatus;
	private JLabel lblOrderID;
	private JLabel lblCustomerID;
	private JLabel lblCustomerName;
	private JLabel lblQty;
	
	private JTextField orderID;
	private JTextField customerID;
	private JTextField customerName;
	private JTextField qty;
	
	private JButton searchOrderIDBtn;
	private JButton updateOrderBtn;
	private JButton backBtn;
	
	private Burger[] tempArray;
	
	updateOrderDetailsPage(){
		setSize(1100,700);
		setTitle("Update Order Details");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		headerPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		headerPanel.setBackground(new Color(150, 142, 126));
		
		header=new JLabel("Update Order");
		header.setFont(new Font("",1,45));
		header.setForeground(Color.WHITE);
		headerPanel.add(header);
		
		add("North", headerPanel);
		
		centerPanel=new JPanel(new GridLayout(5,1,5,5));
		centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
		
		orderStatus=new JMenuBar();
		status=new JMenu("Status  \u2193");
		
		delivered=new JMenuItem("DELIVERED");
		processing=new JMenuItem("PROCESSING");
		cancelled=new JMenuItem("CANCELLED");
		
		status.setFont(new Font("",1,20));
		delivered.setFont(new Font("",1,20));
		processing.setFont(new Font("",1,20));
		cancelled.setFont(new Font("",1,20));
		
		status.add(delivered);
		status.add(processing);
		status.add(cancelled);
		orderStatus.add(status);
		
		lblOrderStatus=new JLabel("Order Status");
		lblOrderStatus.setFont(new Font("",1,25));
		centerPanel.add(lblOrderStatus);
		
		statusPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		statusPanel.add(orderStatus);
		centerPanel.add(statusPanel);
		
		lblOrderID=new JLabel("Order ID");
		lblOrderID.setFont(new Font("",1,25));
		centerPanel.add(lblOrderID);
		
		orderIDPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		orderID=new JTextField(4);
		orderID.setFont(new Font("",1,25));
		orderIDPanel.add(orderID);
		centerPanel.add(orderIDPanel);
		
		lblCustomerID=new JLabel("Customer ID");
		lblCustomerID.setFont(new Font("",1,25));
		centerPanel.add(lblCustomerID);
		
		customerIDPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		customerID=new JTextField(4);
		customerID.setFont(new Font("",1,25));
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
		
		southPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		updateOrderBtn=new JButton("Update order");
		updateOrderBtn.setFont(new Font("",1,25));
		updateOrderBtn.setBackground(new Color(57, 224, 45));
		updateOrderBtn.setForeground(Color.WHITE);
		southPanel.add(updateOrderBtn);
		southPanel.add(Box.createRigidArea(new Dimension(20,0)));
		
		backBtn=new JButton("Back");
		backBtn.setFont(new Font("",1,25));
		backBtn.setBackground(new Color(150, 142, 126));
		backBtn.setForeground(Color.WHITE);
		southPanel.add(backBtn);
		southPanel.add(Box.createRigidArea(new Dimension(20,0)));
		
		add("South", southPanel);
		tempArray=burgerOrders.getArray();
		
		orderID.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String id=orderID.getText();
				id=id.toUpperCase();
				
				if(id.length()==0 || id.length()!=4){
					JOptionPane.showMessageDialog(null, "Invalid Order ID");
				}
				
				boolean found=true;
				for (int i = 0; i < tempArray.length; i++){
					if(tempArray[i].getOrderID().equals(id)){
						found=false;
						customerID.setText(tempArray[i].getCustomerID());
						customerName.setText(tempArray[i].getCustomerName());
						qty.setText(Integer.toString(tempArray[i].getQty()));
						status.setText(tempArray[i].getStatus());
					}
				}
				if(found){
					JOptionPane.showMessageDialog(null, "Order ID not found");
				}
			}
		});
		
		customerID.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String id=customerID.getText();
				id=id.toUpperCase();
				
				if(id.length()==0 || id.length()!=4){
					JOptionPane.showMessageDialog(null, "Invalid Customer ID");
				}
				
				boolean found=true;
				for (int i = 0; i < tempArray.length; i++){
					if(tempArray[i].getCustomerID().equals(id)){
						found=false;
						orderID.setText(tempArray[i].getOrderID());
						customerName.setText(tempArray[i].getCustomerName());
						qty.setText(Integer.toString(tempArray[i].getQty()));
						status.setText(tempArray[i].getStatus());
					}
				}
				if(found){
					JOptionPane.showMessageDialog(null, "Customer ID not found");
				}
			}
		});
		delivered.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				status.setText(delivered.getText());
			}
		});
		processing.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				status.setText(processing.getText());
			}
		});
		cancelled.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				status.setText(cancelled.getText());
			}
		});
		updateOrderBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				int index=-1;
				String id=orderID.getText();
				id=id.toUpperCase();
				
				for (int i = 0; i < tempArray.length; i++){
					if(tempArray[i].getOrderID().equals(id)){
						index=i;
					}
				}
				
				if(index==-1 || id.length()==0){
					JOptionPane.showMessageDialog(null, "Invalid order ID");
				}
				
				tempArray[index].setCustomerName(customerName.getText());
				tempArray[index].setQty(Integer.parseInt(qty.getText()));
				tempArray[index].setStatus(status.getText());
				tempArray[index].setPrice(Double.parseDouble(qty.getText())*Burger.BurgerPrice);
				
				orderID.setText("");
				customerID.setText("");
				customerName.setText("");
				qty.setText("");
				status.setText("Status  \u2193");
			}
		});
		backBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
				new mainPage().setVisible(true);
			}
		});
	}
}
