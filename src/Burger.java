class Burger{
	public static final double BurgerPrice=500;
	
	private String orderID;
	private String customerID;
	private String customerName;
	private int qty;
	private double price;
	private String status;
	
	Burger(String orderID, String customerID, String customerName, int qty, double price, String status){
		this.orderID=orderID;
		this.customerID=customerID;
		this.customerName=customerName;
		this.qty=qty;
		this.price=price;
		this.status=status;
	}
	Burger(){
		
	}
	
	public void setOrderID(String orderID){
		this.orderID=orderID;
	}
	public void setCustomerID(String customerID){
		this.customerID=customerID;
	}
	public void setCustomerName(String customerName){
		this.customerName=customerName;
	}
	public void setStatus(String status){
		this.status=status;
	}
	public void setQty(int qty){
		this.qty=qty;
	}
	public void setPrice(double price){
		this.price=price;
	}
	public String getOrderID(){
		return orderID;
	}
	public String getCustomerID(){
		return customerID;
	}
	public String getCustomerName(){
		return customerName;
	}
	public String getStatus(){
		return status;
	}
	public int getQty(){
		return qty;
	}
	public double getPrice(){
		return price;
	}
}
