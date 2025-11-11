import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

class viewProcessingOrdersPage extends JFrame{
	private JPanel headerPanel;
	private JPanel southPanel;
	
	private JLabel header;
	
	private DefaultTableModel DTM;
	
	private JTable processingOrders;
	
	private JScrollPane tablePane;
	
	private JButton backBtn;
	
	private DefaultTableCellRenderer centerRenderer;
	
	viewProcessingOrdersPage(){
		setSize(1100,700);
		setTitle("Processing Orders");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		headerPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		headerPanel.setBackground(new Color(150, 142, 126));
		
		header=new JLabel("Processing Orders");
		header.setFont(new Font("",1,45));
		header.setForeground(Color.WHITE);
		headerPanel.add(header);
		
		add("North", headerPanel);
		
		String[] coloumns={"Order ID", "Customer ID", "Customer Name", "Qty", "Total"};
		DTM=new DefaultTableModel(coloumns, 0);
		
		Burger[] tempArray=burgerOrders.getArray();
		DTM.setRowCount(0);
		for (int i = 0; i < tempArray.length; i++){
			if(tempArray[i].getStatus().equals("PREPARING")){
				Object[] rowData={tempArray[i].getOrderID(), tempArray[i].getCustomerID(), tempArray[i].getCustomerName(), tempArray[i].getQty(), tempArray[i].getPrice()};
				DTM.addRow(rowData);
			}	
		}
		
		processingOrders=new JTable(DTM);
		processingOrders.setFont(new Font("",1,15));
		processingOrders.setRowHeight(30);
		processingOrders.setBackground(new Color(245, 230, 204));
		processingOrders.setForeground(Color.BLACK);
		processingOrders.setGridColor(Color.GRAY);
		processingOrders.getTableHeader().setBackground(new Color(150, 142, 126));
		processingOrders.getTableHeader().setForeground(Color.WHITE);
		
		centerRenderer=new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		processingOrders.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		processingOrders.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		processingOrders.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		processingOrders.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		processingOrders.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		
		tablePane=new JScrollPane(processingOrders);
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
