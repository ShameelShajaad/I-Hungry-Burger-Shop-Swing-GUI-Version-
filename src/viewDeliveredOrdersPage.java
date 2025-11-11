import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

class viewDeliveredOrdersPage extends JFrame{
	private JPanel headerPanel;
	private JPanel southPanel;
	
	private JLabel header;
	
	private DefaultTableModel DTM;
	
	private JTable deliveredOrders;
	
	private JScrollPane tablePane;
	
	private JButton backBtn;
	
	private DefaultTableCellRenderer centerRenderer;
	
	viewDeliveredOrdersPage(){
		setSize(1100,700);
		setTitle("Delivered Orders");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		headerPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		headerPanel.setBackground(new Color(150, 142, 126));
		
		header=new JLabel("Delivered Orders");
		header.setFont(new Font("",1,45));
		header.setForeground(Color.WHITE);
		headerPanel.add(header);
		
		add("North", headerPanel);
		
		String[] coloumns={"Order ID", "Customer ID", "Customer Name", "Qty", "Total"};
		DTM=new DefaultTableModel(coloumns, 0);
		
		Burger[] tempArray=burgerOrders.getArray();
		DTM.setRowCount(0);
		for (int i = 0; i < tempArray.length; i++){
			if(tempArray[i].getStatus().equals("DELIVERED")){
				Object[] rowData={tempArray[i].getOrderID(), tempArray[i].getCustomerID(), tempArray[i].getCustomerName(), tempArray[i].getQty(), tempArray[i].getPrice()};
				DTM.addRow(rowData);
			}	
		}
		
		deliveredOrders=new JTable(DTM);
		deliveredOrders.setFont(new Font("",1,15));
		deliveredOrders.setRowHeight(30);
		deliveredOrders.setBackground(new Color(245, 230, 204));
		deliveredOrders.setForeground(Color.BLACK);
		deliveredOrders.setGridColor(Color.GRAY);
		deliveredOrders.getTableHeader().setBackground(new Color(150, 142, 126));
		deliveredOrders.getTableHeader().setForeground(Color.WHITE);
		
		centerRenderer=new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		deliveredOrders.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		deliveredOrders.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		deliveredOrders.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		deliveredOrders.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		deliveredOrders.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		
		tablePane=new JScrollPane(deliveredOrders);
		add("Center", tablePane);
		
		southPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		backBtn=new JButton("Back");
		backBtn.setFont(new Font("",1,25));
		backBtn.setBackground(new Color(150, 142, 126));
		backBtn.setForeground(Color.WHITE);
		southPanel.add(backBtn);
		
		add("South", southPanel);
		
		backBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
				new viewOrderPage().setVisible(true);
			}
		});
	}
}
