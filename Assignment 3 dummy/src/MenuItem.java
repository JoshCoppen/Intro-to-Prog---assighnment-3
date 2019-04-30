
public class MenuItem {

	private String nameItem;
	private double costItem;
	private String itemDescription;

	public MenuItem(String nameItem, double costItem, String itemDescription) {

		this.nameItem = nameItem;
		this.costItem = costItem;
		this.itemDescription = itemDescription;

	}

	public String getNameItem() {
		return this.nameItem;
	}

	public String getItemDescription() {
		return this.itemDescription;
	}

	public double getCostItem() {
		return this.costItem;
	}

	public String setNameItem(String item) {
		return this.nameItem = item;
	}
}