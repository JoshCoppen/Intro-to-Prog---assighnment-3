import javax.swing.JOptionPane;
import java.io.*;

public class MyRestaurant {

	private MenuItem[] menus;
	private int arrayLength;
	private String orderName;

	public MyRestaurant() {
		int arrayLength = 10;
		this.arrayLength = arrayLength;
		this.menus = new MenuItem[this.arrayLength];

		String orderName = getInput("What is the name of who is ordering food this evening?");
		this.orderName = orderName;

		String startMenu = "Welcome to My Restaurant \n";
		startMenu += "Where would you like to eat? \n";
		startMenu += "1) Front Bar \n";
		startMenu += "2) Bistro \n";
		startMenu += "3) Dessert Bar";

		String input = getInput(startMenu);

		int selection = Integer.parseInt(input);
		if (selection == 1) {
			menu("FrontBarMenu.txt");
			showMenuItems();
		} else if (selection == 2) {
			menu("BistroMenu.txt");
			showMenuItems();
		} else if (selection == 3) {
			menu("DessertBarMenu.txt");
			showMenuItems();
		} else {
			showMsg("you have made an invalid selection, please try again");
			input = getInput(startMenu);
		}
	}

	private void menu(String file) {

		BufferedReader inFile = null;

		try {
			inFile = new BufferedReader(new FileReader(file));
			int i = 0;

			while (i < this.arrayLength) {
				String currLine = inFile.readLine();
				String[] splitValues = currLine.split("/");
				String itemName = splitValues[0];
				double itemCost = Double.parseDouble(splitValues[1]);
				String itemDescription = splitValues[2];
				this.menus[i] = new MenuItem(itemName, itemCost, itemDescription);
				i += 1;

			}
			inFile.close();
			return;
		} catch (Exception e) {
			showMsg(e.getMessage());
			return;
		}
	}

	private void showMenuItems() {
		setOfTheDay();
		int i = 0;
		String msg = "Tonight's Menu - Please choose from the following (use numbers) \n\n";
		while (i < this.arrayLength) {
			msg += (i + 1) + ") " + this.menus[i].getNameItem() + " - $" + this.menus[i].getCostItem() + "0 - "
					+ this.menus[i].getItemDescription() + "\n";
			i += 1;
		}
		msg += "\n Press Cancel To Exit";
		String input = getInput(msg);

		String order = "Your Order This Evening Is: \n\n";

		double total = 0;
		while (input != null) {
			int choices = Integer.parseInt(input) - 1;
			while (choices > this.arrayLength || choices < 0) {
				choices = Integer.parseInt("please enter a correct number from the menu \n" + input);
			}
			order += this.menus[choices].getNameItem() + " - $" + this.menus[choices].getCostItem() + "0\n";
			total += this.menus[choices].getCostItem();
			input = getInput(msg);
			
		}
		String finalMsg = order + "\n The total of your order today is: $"  + total + "0 \n\n";
		finalMsg += "Thankyou for ordering at my restaurant tonight, " + orderName + ".";
		showMsg(finalMsg);
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
