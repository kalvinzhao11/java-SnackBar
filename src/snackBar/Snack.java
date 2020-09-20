package snackBar;

public class Snack {
	private static int maxId = 0;
	private int id;
	private String name;
	private int quantity;
	private double cost;
	private int vendingMachineId;

	//constructor
	public Snack(String name, int quantity, double cost, int vendingMachineId) {
		maxId++;
		id = maxId;
		this.quantity = quantity;
		this.name = name;
		this.cost = cost;
		this.vendingMachineId = vendingMachineId;
	}
	// getters
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getCost() {
		return cost;
	}
	public int getVendingMachineId() {
		return vendingMachineId;
	}

	// setters
	public void setName(String name) {
		this.name = name;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public void setVendingMachineId(int vendingMachineId) {
		this.vendingMachineId = vendingMachineId;
	}

	// methods
	public void addQuantity(int quantity) {
		this.quantity += quantity;
	}
	public double buySnack(int quantities) {
		if (quantity > quantities){
			this.quantity -= quantities;
			 return getTotalCost(quantities);
			// return quantity;
		} else {
			quantities -= quantity;
			System.out.println("You can only buy " + quantities + " " + name);
			return 0;
			// return quantity;
		}
	}
	public double getTotalCost(int quantities) {
		return cost * quantities;
	}

	// return strings
	@Override
	public String toString() {
		String returnString = "Name: " + name + "Vending Machine" + vendingMachineId + "\nQuantity: " + quantity + "\nTotal Cost: " + cost;
		return returnString;
	}

}