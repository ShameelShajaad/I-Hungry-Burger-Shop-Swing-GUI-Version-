class burgerOrders{
	private static Burger[] burgerArray=new Burger[0];
	
	public static String newOrderID(){
		if(burgerArray.length==0){
			return "O001";
		}else{
			String id=burgerArray[burgerArray.length-1].getOrderID();	
			String incr;
			char ch=id.charAt(0);
			String numbers=id.substring(1);
			
			int num=Integer.parseInt(numbers);
			num++;
			String num1=Integer.toString(num);
			String zero="";
			for (int i = 0; i < (id.length()-num1.length())-1; i++){
				zero+="0";
			}
			incr=ch+zero+num1;
			
			return incr;
		}
	}
	public static String newCustomerID(){
		if(burgerArray.length==0){
			return "C001";
		}else{
			String id=burgerArray[burgerArray.length-1].getCustomerID();
			String incr;
			char ch=id.charAt(0);
			String numbers=id.substring(1);
			
			int num=Integer.parseInt(numbers);
			num++;
			String num1=Integer.toString(num);
			String zero="";
			for (int i = 0; i < (id.length()-num1.length())-1; i++){
				zero+="0";
			}
			incr=ch+zero+num1;
			
			return incr;
		}
	}
	public static void extendBurgerArray(){
		Burger[] tempArray=new Burger[burgerArray.length+1];
		
		for (int i = 0; i < burgerArray.length; i++){
			tempArray[i]=burgerArray[i];
		}
		
		burgerArray=tempArray;
	}
	public static void addNewOrder(Burger newOrder){
		extendBurgerArray();
		burgerArray[burgerArray.length-1]=newOrder;
	}
	public static Burger[] getArray(){
		return burgerArray;
	}
}
