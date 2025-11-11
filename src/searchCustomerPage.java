import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

class searchCustomerPage extends JFrame{
	private JPanel headerPanel;
	private JPanel inputPanel;
	private JPanel southPanel;
	private JPanel centerPanel;
	
	private JLabel header;
	private JLabel enterCustomerID;
	
	private JTextField customerIDField;
	
	private JButton searchBtn;
	private JButton backBtn;
	
	private DefaultTableModel DTM;
	private JTable customerOrdersTable;
	private JScrollPane tablePane;
	private DefaultTableCellRenderer centerRenderer;
	
	searchCustomerPage(){
		setSize(1100,700);
		setTitle("Search Customer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		headerPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		headerPanel.setBackground(new Color(150, 142, 126));
		
		header=new JLabel("Search Customer Orders");
		header.setFont(new Font("",1,45));
		header.setForeground(Color.WHITE);
		headerPanel.add(header);
		
		add("North", headerPanel);
		
		inputPanel=new JPanel(new FlowLayout(FlowLayout.CENTER,20,20));
		
		enterCustomerID=new JLabel("Enter Customer ID :");
		enterCustomerID.setFont(new Font("",1,25));
		inputPanel.add(enterCustomerID);
		
		customerIDField=new JTextField(4);
		customerIDField.setFont(new Font("",1,25));
		inputPanel.add(customerIDField);
		
		searchBtn=new JButton("Search");
		searchBtn.setFont(new Font("",1,25));
		searchBtn.setBackground(new Color(57, 224, 45));
		searchBtn.setForeground(Color.WHITE);
		inputPanel.add(searchBtn);
		
		centerPanel = new JPanel(new BorderLayout());
		
		String[] columns={"Order ID", "Customer ID", "Customer Name", "Qty", "Total", "Status"};
		DTM=new DefaultTableModel(columns, 0);
		
		customerOrdersTable = new JTable(DTM);
		customerOrdersTable.setFont(new Font("",1,15));
		customerOrdersTable.setRowHeight(30);
		customerOrdersTable.setBackground(new Color(245, 230, 204));
		customerOrdersTable.setForeground(Color.BLACK);
		customerOrdersTable.setGridColor(Color.GRAY);
		customerOrdersTable.getTableHeader().setBackground(new Color(150, 142, 126));
		customerOrdersTable.getTableHeader().setForeground(Color.WHITE);
		
		centerRenderer=new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		customerOrdersTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		customerOrdersTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		customerOrdersTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		customerOrdersTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		customerOrdersTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		customerOrdersTable.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		
		tablePane=new JScrollPane(customerOrdersTable);
		centerPanel.add(inputPanel, BorderLayout.NORTH);
		centerPanel.add(tablePane, BorderLayout.CENTER);
		add("Center", centerPanel);
		
		southPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		backBtn=new JButton("Back");
		backBtn.setFont(new Font("",1,25));
		backBtn.setBackground(new Color(150, 142, 126));
		backBtn.setForeground(Color.WHITE);
		southPanel.add(backBtn);
		
		add("South", southPanel);
		
		searchBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String id=customerIDField.getText();
				id=id.toUpperCase();
				
				Burger[] tempArray=burgerOrders.getArray();
				
				String name="";
				int count=0;
				for (int i = 0; i < tempArray.length; i++){
					if(tempArray[i].getCustomerID().equals(id)){
						name=tempArray[i].getCustomerName();
						count++;
					}
				}
				
				if(count==0){
					JOptionPane.showMessageDialog(null, "Invalid Customer ID");
					return;
				}
				if(id.length()==0){
					JOptionPane.showMessageDialog(null, "Please enter a Customer ID");
					return;
				}
				if(id.length()!=4){
					JOptionPane.showMessageDialog(null, "Invalid Customer ID");
					return;
				}
				
				DTM.setRowCount(0);
				
				for (int i = 0; i < tempArray.length; i++){
					if(tempArray[i].getCustomerName().equals(name)){
						Object[] rowData={
							tempArray[i].getOrderID(),
							tempArray[i].getCustomerID(),
							tempArray[i].getCustomerName(),
							tempArray[i].getQty(),
							tempArray[i].getPrice(),
							tempArray[i].getStatus()
						};
						DTM.addRow(rowData);
					}
				}
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
