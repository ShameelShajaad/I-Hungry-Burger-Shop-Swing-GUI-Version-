import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

class bestCustomerPage extends JFrame{
	private JPanel headerPanel;
	private JPanel centerPanel;
	private JPanel southPanel;
	
	private JLabel header;
	
	private Burger[] tempBurgerArray;
	private String[] tempArrayCusID;
	private String[] tempArrayCusName;
	private double[] tempArrayTot;
	
	private DefaultTableModel DTM;
	
	private JTable bestCustomer;
	
	private JScrollPane tablePane;
	
	private JButton backBtn;
	
	private DefaultTableCellRenderer centerRenderer;
	
	bestCustomerPage(){
		setSize(1100,700);
		setTitle("Best Customer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		headerPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		headerPanel.setBackground(new Color(150, 142, 126));
		
		header=new JLabel("Best Customer");
		header.setFont(new Font("",1,45));
		header.setForeground(Color.WHITE);
		headerPanel.add(header);
		
		add("North", headerPanel);
		
		////////////////////////////////////////////////////////
		tempBurgerArray=burgerOrders.getArray();
		
		int count=0;
		for (int i = 0; i < tempBurgerArray.length; i++){
			boolean found =false;
			for (int j = 0; j < i; j++){
				if(tempBurgerArray[i].getCustomerName().equals(tempBurgerArray[j].getCustomerName())){
					found=true;
					break;
				}
			}
			if(!found){
				count++;
			}
		}
		
		tempArrayCusID=new String[count];
		tempArrayCusName=new String[count];
		tempArrayTot=new double[count];
		
		int indx=0;
		for (int i = 0; i < tempBurgerArray.length; i++){
			boolean found =false;
			int count1 = -1;
			for (int j = 0; j < i; j++){
				if(tempBurgerArray[i].getCustomerName().equals(tempBurgerArray[j].getCustomerName())){
					found=true;
					count1=j;
					break;
				}
			}
			if(!found){
				tempArrayCusID[indx]=tempBurgerArray[i].getCustomerID();
				tempArrayCusName[indx]=tempBurgerArray[i].getCustomerName();
				tempArrayTot[indx]=tempBurgerArray[i].getStatus().equals("CANCEL") ? 0.0 : tempBurgerArray[i].getPrice();
				indx++;
			}else{
				for (int j = 0; j < count1; j++){
					if(tempBurgerArray[count1].getCustomerName().equals(tempArrayCusName[j])){
						count1=j;
						break;
					}
				}
				tempArrayTot[count1]+=tempBurgerArray[i].getPrice();
			}
		}
		
		for (int i = 0; i < tempArrayTot.length; i++){
			for (int j = 0; j < tempArrayTot.length-1; j++){
				if(tempArrayTot[j]<tempArrayTot[j+1]){
					double a=tempArrayTot[j+1];
					tempArrayTot[j+1]=tempArrayTot[j];
					tempArrayTot[j]=a;
					
					String b=tempArrayCusID[j+1];
					tempArrayCusID[j+1]=tempArrayCusID[j];
					tempArrayCusID[j]=b;
					
					String c=tempArrayCusName[j+1];
					tempArrayCusName[j+1]=tempArrayCusName[j];
					tempArrayCusName[j]=c;
				}
			}
		}
		////////////////////////////////////////////////////////
		
		String[] coloumns={"Customer ID", "Customer Name", "Total"};
		DTM=new DefaultTableModel(coloumns, 0);
		
		DTM.setRowCount(0);
		for (int i = 0; i < tempArrayCusID.length; i++){
			Object[] rowData={tempArrayCusID[i], tempArrayCusName[i], tempArrayTot[i]};
			DTM.addRow(rowData);	
		}
		
		bestCustomer=new JTable(DTM);
		bestCustomer.setFont(new Font("",1,15));
		bestCustomer.setRowHeight(30);
		bestCustomer.setBackground(new Color(245, 230, 204));
		bestCustomer.setForeground(Color.BLACK);
		bestCustomer.setGridColor(Color.GRAY);
		bestCustomer.getTableHeader().setBackground(new Color(150, 142, 126));
		bestCustomer.getTableHeader().setForeground(Color.WHITE);
		
		centerRenderer=new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		bestCustomer.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		bestCustomer.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		bestCustomer.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		
		tablePane=new JScrollPane(bestCustomer);
		add("Center", tablePane);
		
		southPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		backBtn=new JButton("Back");
		backBtn.setFont(new Font("",1,25));
		backBtn.setBackground(new Color(150, 142, 126));
		backBtn.setForeground(Color.WHITE);
		southPanel.add(backBtn);
		
		backBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
				new mainPage().setVisible(true);
			}
		});
		
		add("South", southPanel);
	}
}
