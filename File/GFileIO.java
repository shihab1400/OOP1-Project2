package File;
import java.io.*;
import java.util.Scanner;
import Entity.*;
import EntityList.*;
public class GFileIO{
	public static void loadItemsFromFile(ItemMenu ItemMenu){
		try{
			Scanner sc = new Scanner(new File("./File/items.txt"));
			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(";");
				Item f = new Item(data[0],data[1],Integer.parseInt(data[2]));
				ItemMenu.insert(f);
			}
			sc.close();
		}
		catch(Exception e){
			
		}
	}
	
	public static void writeItemInFile(Item f){
		try{
			FileWriter writer = new FileWriter(new File("./File/items.txt"),true);
			String data = f.getItemCode()+";"+f.getItemName()+";"+f.getItemPrice()+"\n";
						  
						  
			writer.write(data);
			writer.close();
		}
		catch(Exception e){
			
		}
	}
	
	public static void updateItemsInFile(ItemMenu ItemMenu){
		try{
			FileWriter writer = new FileWriter(new File("./File/items.txt"));
			Item Items[] = ItemMenu.getAllItems();
			
			String allData="";
			
			for(int i=0;i<Items.length;i++){
				if(Items[i]!=null){
					String data = Items[i].getItemCode()+";"+Items[i].getItemName()+";"+
					Items[i].getItemPrice()+"\n";
					
					allData+=data;
				}
			}
			writer.write(allData);
			writer.close();
		}
		catch(Exception e){
			
		}
	}

	
	public static void saveItemsInFile(ItemMenu ItemMenu){
		try {
		FileWriter writer = new FileWriter(new File("./File/items.txt"));
		Item Items[] = ItemMenu.getAllItems();
			
			String allData="";
			for(int i=0;i<Items.length;i++){
				if(Items[i]!=null){
					String data = Items[i].getItemCode()+";"+Items[i].getItemName()+";"+
						  			Items[i].getItemPrice()+"\n";
					
					allData+=data;
				}
			}
			writer.write(allData);
			writer.close();
		} catch (IOException e) {
			System.out.println("Cannot Write in File");
		}
	}
}