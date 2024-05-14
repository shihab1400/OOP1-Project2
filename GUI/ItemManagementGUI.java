package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import Entity.*;
import EntityList.*;
import File.GFileIO;

public class ItemManagementGUI extends JFrame implements ActionListener{
	Font titleFont = new Font("Arial",Font.BOLD,30);
	Font titleLabel = new Font("Arial",Font.BOLD,15);
	
	JTextField codeTextField,nameTextField,genreTextField,typeTextField,priceTextField;
	JTextField searchTextField,deleteTextField;
	JButton addButton,updateButton,searchButton,deleteButton,clearButton,showAllButton,backButton,saveButton;
	JTextArea textArea;
	ItemMenu ItemMenu;
	public ItemManagementGUI(ItemMenu ItemMenu){
		super("One-Stop Gaming");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(850,700); //width, hthis
		this.setLocation(250,0); //x, y
		this.getContentPane().setBackground(new Color(48, 132, 173));
		this.setLayout(null);
		this.ItemMenu=ItemMenu;
		//============= Title ===========
		JLabel title = new JLabel("AIUB SuperShop");
		title.setBounds(300,10,500,50); //X,Y,W,H
		title.setFont(titleFont);
		//============Sub Title===========
		JLabel subTitle = new JLabel("Menu");
		subTitle.setBounds(400,60,320,50); //X,Y,W,H
		subTitle.setFont(new Font("Arial",Font.BOLD,25));
		
		
		//============ Entry Form ===========
		int top = 100;
		int gap = 40;
		//=========== code Entry  ===========
		JLabel codeLabel = new JLabel("Item Code");
		codeLabel.setBounds(20,top,200,30); //X,Y,W,H
		codeLabel.setFont(titleLabel);
		
		codeTextField = new JTextField();
		codeTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		codeTextField.setFont(titleLabel);
		
		
		JLabel nameLabel = new JLabel("Item Name");
		nameLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		nameLabel.setFont(titleLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		nameTextField.setFont(titleLabel);
		
		JLabel priceLabel = new JLabel("Item Price");
		priceLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		priceLabel.setFont(titleLabel);
		
		priceTextField = new JTextField();
		priceTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		priceTextField.setFont(titleLabel);
		
	
		
		//============Buttons===========
		addButton = new JButton("ADD");
		addButton.setBounds(20,top+=gap+20,200,30); //X,Y,W,H
		addButton.setBackground(new Color(165, 201, 202));
		addButton.setFont(titleLabel);
		addButton.addActionListener(this);
		
		updateButton = new JButton("UPDATE");
		updateButton.setBounds(20,top+=gap,200,30); //X,Y,W,H
		updateButton.setBackground(new Color(165, 201, 202));
		updateButton.setForeground(Color.BLACK);
		updateButton.setFont(titleLabel);
		updateButton.addActionListener(this);
		
		
		//============ INFORMATION DISPLAY  AREA ===========
		textArea = new JTextArea();
		textArea.setFont(titleLabel );
		textArea.setEditable(false);
		

	    reloadAllItems();
		JScrollPane jsp =
        new JScrollPane(textArea);
		jsp.setBounds(280,120,300,500);
		this.add(jsp);
		
				top = 100;
		gap = 40;
		//============Search Entry  ===========
		JLabel searchLabel = new JLabel("Search By Item Code:");
		searchLabel.setBounds(600,top,200,30); //X,Y,W,H
		searchLabel.setFont(titleLabel);
		
		searchTextField = new JTextField();
		searchTextField.setBounds(600,top+=gap,200,30); //X,Y,W,H
		searchTextField.setFont(titleLabel);
		
		searchButton = new JButton("SEARCH");
		searchButton.setBounds(600,top+=gap,200,30); //X,Y,W,H
		searchButton.setBackground(new Color(165, 201, 202));
		searchButton.setFont(titleLabel);
		searchButton.addActionListener(this);
		
		
		//============ Delete Entry  ===========
		JLabel deleteLabel = new JLabel("Delete By Item Code");
		deleteLabel.setBounds(600,top+=gap,200,30); //X,Y,W,H
		deleteLabel.setFont(titleLabel);
		
		deleteTextField = new JTextField();
		deleteTextField.setBounds(600,top+=gap,200,30); //X,Y,W,H
		deleteTextField.setFont(titleLabel);
		
		deleteButton = new JButton("DELETE");
		deleteButton.setBounds(600,top+=gap,200,30); //X,Y,W,H
		deleteButton.setBackground(new Color(165, 201, 202));
		deleteButton.setForeground(Color.BLACK);
		deleteButton.setFont(titleLabel);
		deleteButton.addActionListener(this);
		
		
		
		
		///////////////// Show All information ///////////////
		
		showAllButton = new JButton("SHOW ALL Item");
		showAllButton.setBounds(600,400,200,30); //X,Y,W,H
		showAllButton.setBackground(new Color(165, 201, 202));
		showAllButton.setForeground(Color.BLACK);
		showAllButton.setFont(titleLabel);
		showAllButton.addActionListener(this);
		
		///////////////// Clear Screen ///////////////
		
		clearButton = new JButton("CLEAR SCREEN");
		clearButton.setBounds(600,450,200,30); //X,Y,W,H
		clearButton.setBackground(new Color(165, 201, 202));
		clearButton.setForeground(Color.BLACK);
		clearButton.setFont(titleLabel);
		clearButton.addActionListener(this);
		
		backButton = new JButton("Home Page");
		backButton.setBounds(600,500,200,30);
		backButton.setBackground(new Color(165, 201, 202));
		backButton.setForeground(Color.BLACK);
		backButton.addActionListener(this);
		

		saveButton = new JButton("SAVE");
		saveButton.setBounds(600,550,200,30);
		saveButton.setBackground(new Color(165, 201, 202));
		saveButton.setForeground(Color.BLACK);
		saveButton.addActionListener(this);
		
		
		
		this.add(title);
		this.add(subTitle);
		this.add(codeLabel);
		this.add(codeTextField);
		this.add(nameLabel);
		this.add(nameTextField);
		this.add(priceLabel);
		this.add(priceTextField);
		this.add(addButton);
		this.add(updateButton);
		this.add(searchLabel);
		this.add(searchTextField);
		this.add(searchButton);
		this.add(deleteLabel);
		this.add(deleteTextField);
		this.add(deleteButton);
		this.add(clearButton);
		this.add(showAllButton);
		this.add(backButton);
		this.add(saveButton);
		
		this.setVisible(true);
	}
	@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == addButton) {
        System.out.println("ADD CLICKED");
		if(
			!codeTextField.getText().isEmpty() &&
			!nameTextField.getText().isEmpty() &&
			!typeTextField.getText().isEmpty() &&
			!genreTextField.getText().isEmpty() &&
			!priceTextField.getText().isEmpty()
		){
		if( ItemMenu.getByCode(codeTextField.getText()) == null){
			Item f = new Item(
						
				codeTextField.getText(),
				nameTextField.getText(),
				
				//genreTextField.getText(),
				//typeTextField.getText(),
			    Integer.parseInt( priceTextField.getText())
			);
				
			ItemMenu.insert(f);
			//GFileIO.insertInFile(f.getGameInfoAsString(), "./File/Games.txt");
			GFileIO.writeItemInFile(f);

			
			reloadAllItems();
		}	
		else{
				JOptionPane.showMessageDialog(this,"This Code Already Exists","Provide Unique Code",JOptionPane.ERROR_MESSAGE);
			}
		}
    else{
			JOptionPane.showMessageDialog(this,"Please Provide all Information for ","Missing Information",JOptionPane.ERROR_MESSAGE);
		}
    }
	
	else if (e.getSource() == updateButton) {
      
        System.out.println("UPDATE CLICKED");
  			if(!codeTextField.getText().isEmpty() ){
				Item f = ItemMenu.getByCode(codeTextField.getText());
				if(f!=null){
					if(!nameTextField.getText().isEmpty()){
						f.setItemName(nameTextField.getText());
					}
					
	
					if(!priceTextField.getText().isEmpty()){
						f.setItemPrice( Integer.parseInt( priceTextField.getText() ));
					}
					
					GFileIO.updateItemsInFile(ItemMenu);
					
					reloadAllItems();
				}
				else{
					JOptionPane.showMessageDialog(this,"No Available Item ","Item Not Found",JOptionPane.ERROR_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(this,"Please Provide Code ","Missing Information",JOptionPane.ERROR_MESSAGE);
			}    
    }
	else if (e.getSource() == searchButton) {
    
        System.out.println("SEARCH CLICKED");
		Item f = ItemMenu.getByCode(searchTextField.getText());
			if(f!=null){
				textArea.setText( f.getItemInfoAsString() );
			}
			else{
				//textArea.setText( "NO BOOK FOUND" );
				JOptionPane.showMessageDialog(this,"NOT FOUND.","Alert",JOptionPane.WARNING_MESSAGE);
			}
    }
	else if (e.getSource() == deleteButton) {
       
        System.out.println("DELETE CLICKED");
		ItemMenu.deleteByCode(deleteTextField.getText());
	 reloadAllItems();
    }
	else if (e.getSource() == showAllButton) {
       
        System.out.println("SHOW ALL CLICKED");
      textArea.setText( ItemMenu.getAll() );
	  reloadAllItems();
    } 
	else if (e.getSource() == clearButton) {
       
        System.out.println("CLEAR CLICKED");
       textArea.setText("");
	   
    }
	else if(saveButton == e.getSource()){
		System.out.println("SAVE CLICKED");
			GFileIO.saveItemsInFile(ItemMenu);
		}
		else if(backButton == e.getSource()){
			System.out.println("HOMEPAGE CLICKED");
			HomePageGUI hpGUI= new HomePageGUI();
		}
	
 } 
 	public void reloadAllItems(){
		textArea.setText(ItemMenu.getAll());
	}
}