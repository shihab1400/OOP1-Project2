package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entity.*;
import EntityList.*;
import File.*;
import java.io.*;

public class HomePageGUI extends JFrame implements ActionListener{
	Font titleFont = new Font("Arial",Font.BOLD,30);
	Font titleLabel = new Font("Arial",Font.BOLD,15);
	JButton showAllProductButton,showAllStaffsButton,showAllItemsButton,logOutButton;
	public HomePageGUI(){
		super("Home Page");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(850,700); //width, height
		this.setLocation(250,0); //x, y
		this.getContentPane().setBackground(new Color(157, 178, 191));
		this.setLayout(null);
		JLabel title = new JLabel("AIUB Supershop");
		title.setBounds(330,50,500,50); //X,Y,W,H
		title.setFont(titleFont);

		int top = 100;
		int gap = 40;

		showAllProductButton = new JButton("Manage Products ");
		showAllProductButton.setBounds(350,150,200,50); //X,Y,W,H
		showAllProductButton.setBackground(new Color(44, 116, 179));
		showAllProductButton.setForeground(Color.BLACK);
		showAllProductButton.setFont(titleLabel);
		showAllProductButton.addActionListener(this);
		
		showAllItemsButton = new JButton("Manage Items");
		showAllItemsButton.setBounds(350,300,200,50); //X,Y,W,H
		showAllItemsButton.setBackground(new Color(32, 82, 149));
		showAllItemsButton.setForeground(Color.BLACK);
		showAllItemsButton.setFont(titleLabel);
		showAllItemsButton.addActionListener(this);

		showAllStaffsButton = new JButton("Manage Staffs");
		showAllStaffsButton.setBounds(350,450,200,50); //X,Y,W,H
		showAllStaffsButton.setBackground(new Color(20, 66, 114));
		showAllStaffsButton.setForeground(Color.BLACK);
		showAllStaffsButton.setFont(titleLabel);
		showAllStaffsButton.addActionListener(this);
		
		logOutButton = new JButton("Logout");
		logOutButton.setBounds(400,600,100,20); //X,Y,W,H
		logOutButton.setBackground(Color.Green);
		logOutButton.setForeground(Color.WHITE);
		logOutButton.setFont(titleLabel);
		logOutButton.addActionListener(this);
		
		super.add(showAllProductButton);
		super.add(showAllItemsButton);
		super.add(showAllStaffsButton);
		this.add(title);
		this.add(logOutButton);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae){
		if (ae.getSource() == showAllProductButton) {
		        ProductMenu ProductMenu = new ProductMenu(200);
			PFileIO.loadProductsFromFile(ProductMenu);
			ProductManagementGUI pmGUI = new ProductManagementGUI(ProductMenu);
	    	}else if (ae.getSource() == showAllItemsButton) {
			ItemMenu ItemMenu = new ItemMenu(200);
			GFileIO.loadItemsFromFile(ItemMenu);
			ItemManagementGUI dmGUI= new ItemManagementGUI(ItemMenu);
		}else if (ae.getSource() == showAllStaffsButton) {
			StaffList StaffList = new StaffList(20);
			FileIO.loadStaffsFromFile(StaffList);
			StaffManagementGUI smGUI = new StaffManagementGUI(StaffList);
		}else if (ae.getSource() == logOutButton) {
			LoginPage loginPage = new LoginPage();
		}
	}
}