import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class searchOrderPage extends JFrame{
	private JPanel headerPanel;
	private JPanel inputPanel;
	private JPanel southPanel;
	
	private JLabel header;
	private JLabel enterOrderID;
	
	private JTextField orderIDField;
	
	private JButton searchBtn;
	private JButton backBtn;
	
	searchOrderPage(){
		setSize(1100,700);
		setTitle("Search Order");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		headerPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		headerPanel.setBackground(new Color(150, 142, 126));
		
		header=new JLabel("Search Order Details");
		header.setFont(new Font("",1,45));
		header.setForeground(Color.WHITE);
		headerPanel.add(header);
		
		add("North", headerPanel);
		
		inputPanel=new JPanel(new FlowLayout(FlowLayout.CENTER,20,20));
		
		enterOrderID=new JLabel("Enter Order ID :");
		enterOrderID.setFont(new Font("",1,25));
		enterOrderID.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(enterOrderID);
		
		orderIDField=new JTextField(4);
		orderIDField.setFont(new Font("",1,25));
		inputPanel.add(orderIDField);
		
		searchBtn=new JButton("Search");
		searchBtn.setFont(new Font("",1,25));
		searchBtn.setBackground(new Color(57, 224, 45));
		searchBtn.setForeground(Color.WHITE);
		inputPanel.add(searchBtn);
		
		add("Center",inputPanel);
		
		southPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		backBtn=new JButton("Back");
		backBtn.setFont(new Font("",1,25));
		backBtn.setBackground(new Color(150, 142, 126));
		backBtn.setForeground(Color.WHITE);
		southPanel.add(backBtn);
		
		add("South", southPanel);
		
		searchBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String id=orderIDField.getText();
				id=id.toUpperCase();
				
				if(id.length()==0){
					JOptionPane.showMessageDialog(null, "Please enter an Order ID");
					return;
				}
				if(id.length()!=4){
					JOptionPane.showMessageDialog(null, "Order ID length is not Valid");
					return;
				}
				
				Burger[] tempArray=burgerOrders.getArray();
				
				for (int i = 0; i < tempArray.length; i++){
					if(tempArray[i].getOrderID().equals(id)){
						JOptionPane.showMessageDialog(null,
							"Order Found\n\n" +
							"Order ID       :  "+tempArray[i].getOrderID()+"\n" +
							"Customer ID    :  "+tempArray[i].getCustomerID()+"\n" +
							"Customer Name  :  "+tempArray[i].getCustomerName()+"\n" +
							"Quantity       :  "+tempArray[i].getQty()+"\n" +
							"Total          :  "+tempArray[i].getPrice()+"\n" +
							"Status         :  "+tempArray[i].getStatus());
							
							return;
					}
				}
				JOptionPane.showMessageDialog(null, "Order ID "+id+" not Found");
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
