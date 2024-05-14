package Entity;

public class Item{
	
		private String ItemCode;
		private String ItemName;
		private int ItemPrice;
		
		public Item(){}
		public Item(String ItemCode,String ItemName,int ItemPrice){
			this.ItemCode= ItemCode;
			this.ItemName= ItemName;			
			this.ItemPrice=ItemPrice;
		}
		
		public void setItemName(String ItemName){this.ItemName=ItemName;}
		public void setItemCode(String ItemCode){this.ItemCode=ItemCode;}
		public void setItemPrice(int ItemPrice){this.ItemPrice=ItemPrice;}
	
		
		public String getItemName(){return this.ItemName;}
		public String getItemCode(){return this.ItemCode;}
		public int getItemPrice(){return this.ItemPrice;}
		
		public void showItemInfo(){
			System.out.println("Item code : "+this.ItemCode);
			System.out.println("Name : "+this.ItemName);
			System.out.println("Price($) : "+this.ItemPrice);
		}
		
		public String getItemInfoAsString(){
		
		
		return 
		        "Code : "+ItemCode+"\n"+
				"Name : "+ItemName+"\n"+
				"Price($) : "+ItemPrice+"\n";
				
	}
	
	
}