import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

class viewCancelledOrdersPage extends JFrame{
	private JPanel headerPanel;
	private JPanel southPanel;
	
	private JLabel header;
	
	private DefaultTableModel DTM;
	
	private JTable cancelledOrders;
	
	private JScrollPane tablePane;
	
	private JButton backBtn;
	
	private DefaultTableCellRenderer centerRenderer;
	
	viewCancelledOrdersPage(){
		setSize(1100,700);
		setTitle("Cancelled Orders");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		headerPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		headerPanel.setBackground(new Color(150, 142, 126));
		
		header=new JLabel("Cancelled Orders");
		header.setFont(new Font("",1,45));
		header.setForeground(Color.WHITE);
		headerPanel.add(header);
		
		add("North", headerPanel);
		
		String[] coloumns={"Order ID", "Customer ID", "Customer Name", "Qty", "Total"};
		DTM=new DefaultTableModel(coloumns, 0);
		
		Burger[] tempArray=burgerOrders.getArray();
		DTM.setRowCount(0);
		for (int i = 0; i < tempArray.length; i++){
			if(tempArray[i].getStatus().equals("CANCEL")){
				Object[] rowData={tempArray[i].getOrderID(), tempArray[i].getCustomerID(), tempArray[i].getCustomerName(), tempArray[i].getQty(), tempArray[i].getPrice()};
				DTM.addRow(rowData);
			}	
		}
		
		cancelledOrders=new JTable(DTM);
		cancelledOrders.setFont(new Font("",1,15));
		cancelledOrders.setRowHeight(30);
		cancelledOrders.setBackground(new Color(245, 230, 204));
		cancelledOrders.setForeground(Color.BLACK);
		cancelledOrders.setGridColor(Color.GRAY);
		cancelledOrders.getTableHeader().setBackground(new Color(150, 142, 126));
		cancelledOrders.getTableHeader().setForeground(Color.WHITE);
		
		centerRenderer=new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		cancelledOrders.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		cancelledOrders.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		cancelledOrders.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		cancelledOrders.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		cancelledOrders.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		
		tablePane=new JScrollPane(cancelledOrders);
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
