package EntityList;
import Entity.*;
import Interfaces.*;
public class ItemMenu implements IItemMenu{
    private Item Items[];

    public ItemMenu() {
        Items = new Item[50];
    }

    public ItemMenu(int size) {
        Items = new Item[size];
    }


    public void insert(Item f) {
        boolean flag = false;
        for (int i = 0; i < Items.length; i++) {
            if (Items[i] == null) {
                Items[i] = f;
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("Item Inserted");
        } else {
            System.out.println("Insertion Failed");
        }
    }


    public Item getByCode(String code) {
        for (int i = 0; i < Items.length; i++) {
            if (Items[i] != null) {
                if (Items[i].getItemCode().equals(code)) {
                    return Items[i];
                }
            }
        }
        return null;
    }

    public void deleteByCode(String code) {
        boolean flag = false;
        for (int i = 0; i < Items.length; i++) {
            if (Items[i] != null) {
                if (Items[i].getItemCode().equals(code)) {
                    Items[i] = null;
                    flag = true;
                    break;
                }
            }
        }
        if (flag) {
            System.out.println("Deleted");
        } else {
            System.out.println("Failed");
        }
    }

    public void searchByName(String name) {
        for (int i = 0; i < Items.length; i++) {
            if (Items[i] != null) {
                if (Items[i].getItemName().equals(name)) {
                    System.out.println("Item Found");
                    Items[i].showItemInfo();
                    return;
                }
            }
        }
        System.out.println("-- Item Not Found ---");
    }

    public void showAll() {
        System.out.println("-------------Available Item-----------");
        for (int i = 0; i < Items.length; i++) {
            if (Items[i] != null) {
                System.out.println("---------------------");
                Items[i].showItemInfo();
            }
        }
        System.out.println("---------------------");
    }

	public String getAll(){
		String allItemInfo = "";
		for(int i=0;i<Items.length;i++){
			if(Items[i] != null){ 
			
				allItemInfo += "-----------------  \n";
				allItemInfo += Items[i].getItemInfoAsString();
			
			}
		}
		allItemInfo += "----------------------------------------\n";
		return allItemInfo;
	}
	
	
	public Item[] getAllItems(){return Items;}
	
}