import javax.swing.JOptionPane;
import java.io.*;

public class MyRestaurant {

	private MenuItem[] menus;
	private int arrayLength;

	public MyRestaurant() {
		int arrayLength = 10;
		this.arrayLength = arrayLength;
		this.menus = new MenuItem[this.arrayLength];

		String orderName = getInput("What is the name of who is ordering food this evening?");

		String startMenu = "Welcome to My Restaurant \n";
		startMenu += "What menu would you like to look at? \n";
		startMenu += "1) Front Bar \n";
		startMenu += "2) Bistro \n";
		startMenu += "3) Dessert Bar";

		String input = getInput(startMenu);

		while (input != null) {
			int selection = Integer.parseInt(input);
			if (selection == 1) {
				frontBarFile();
				showMenuItems();
			} else if (selection == 2) {
				bistroFile();
				showMenuItems();
			} else if (selection == 3) {
				dessertBarFile();
				showMenuItems();
			} else {
				showMsg("you have made an invalid selection, please try again");
				input = getInput(startMenu);
			}
		}

		showMsg("Thankyou for ordering at our restaurant tonight, " + orderName + "\n");

		input = getInput(startMenu);
	}

	private void bistroFile() {

		BufferedReader inFile = null;

		try {
			inFile = new BufferedReader(new FileReader("BistroMenu.txt"));
			int i = 0;
			String currLine = inFile.readLine();
			while (i < this.arrayLength) {
				this.menus[i] = new MenuItem(currLine);
				i += 1;
				currLine = inFile.readLine();
			}
			inFile.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
	}

	private void frontBarFile() {

		BufferedReader inFile = null;

		try {
			inFile = new BufferedReader(new FileReader("FrontBarMenu.txt"));
			int i = 0;
			String currLine = inFile.readLine();
			while (i < this.arrayLength) {
				this.menus[i] = new MenuItem(currLine);
				i += 1;
				currLine = inFile.readLine();
			}
			inFile.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
	}

	private void dessertBarFile() {

		BufferedReader inFile = null;

		try {
			inFile = new BufferedReader(new FileReader("DessertBarMenu.txt"));
			int i = 0;
			String currLine = inFile.readLine();
			while (i < this.arrayLength) {
				this.menus[i] = new MenuItem(currLine);
				i += 1;
				currLine = inFile.readLine();
			}
			inFile.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
	}

	private void showMenuItems() {
		setOfTheDay();
		int i = 0;
		String msg = "This Is The Menu \n";
		msg += " Please choose from the following (use numbers) \n";
		while (i < this.arrayLength) {
			msg += i + ") " + this.menus[i].getNameItem() + "\n";
			i += 1;
		}
		msg += "PRESS CANCEL TO EXIT";
		String input = getInput(msg);
		String total = "The food you have ordered are as follows \n";
		i= 0;
		while (input != null) {
			int choices = Integer.parseInt(input);
			total += i + ") " + this.menus[choices].getNameItem() + "\n";
			input = getInput(msg);
			i +=1;
//			if (choices > this.arrayLength || choices < this.arrayLength) {
//				getInput("please enter a correct number from the menu");
//			}
		}
		showMsg(total);
		return;
	}
	
	private void setOfTheDay() {
		this.menus[0].setNameItem(getInput("What is the " + this.menus[0].getNameItem() + "?"));
		return;
	}

	private void showMsg(String msg) {
		JOptionPane.showMessageDialog(null, msg);
		return;
	}

	private String getInput(String msg) {
		String choice;
		choice = JOptionPane.showInputDialog(msg);
		return choice;
	}

	public static void main(String[] args) {
		MyRestaurant mR = new MyRestaurant();

	}

}
