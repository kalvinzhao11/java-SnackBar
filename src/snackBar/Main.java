package snackBar;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		// customers
		Customer jane = new Customer("Jane", 45.25);
		Customer bob = new Customer("Bob", 33.14);

		// vending machines
		VendingMachine food = new VendingMachine("Food");
		VendingMachine drink = new VendingMachine("drink");
		VendingMachine office = new VendingMachine("Office");

		// foods
		Snack chips = new Snack("Chips", 36, 1.75, food.getId());
		Snack chocolateBar = new Snack("Chocolate Bar", 36, 1.00, food.getId());
		Snack pretzel = new Snack("Pretzel", 30, 2.00, food.getId());

		// drinks
		Snack soda = new Snack("Soda", 24, 2.50, drink.getId());
		Snack water = new Snack("Water", 20, 2.75, drink.getId());

		jane.buySnacks(soda.buySnack(3));
		cashOnHand(jane);
		quantityOfSnack(soda);
		System.out.println();

		jane.buySnacks(pretzel.buySnack(1));
		cashOnHand(jane);
		quantityOfSnack(pretzel);
		System.out.println();

		bob.buySnacks(soda.buySnack(2));
		cashOnHand(bob);
		quantityOfSnack(soda);
		System.out.println();

		jane.addToCashOnHand(10);
		cashOnHand(jane);
		System.out.println();

		jane.buySnacks(chocolateBar.buySnack(1));
		cashOnHand(jane);
		quantityOfSnack(chocolateBar);
		System.out.println();

		pretzel.addQuantity(12);
		quantityOfSnack(pretzel);
		System.out.println();

		bob.buySnacks(pretzel.buySnack(3));
		cashOnHand(bob);
		quantityOfSnack(pretzel);
		System.out.println();

		System.out.println("Stretch Goals");
		System.out.println();

		Hashtable <Integer, String> vending = new Hashtable<>();
		vending.put(food.getId(), food.getName());
		vending.put(drink.getId(), drink.getName());
		vending.put(office.getId(), office.getName()); // not needed but could be use for future purpose

		List <Snack> snack = new ArrayList<>();
		snack.add(chips);
		snack.add(chocolateBar);
		snack.add(pretzel);
		snack.add(soda);
		snack.add(water);

		vendingMachine(vending,snack);
	}

	public static void cashOnHand(Customer obj) {
		System.out.println("Customer " + obj.getId() + " cash on hand " + currencyConversion(obj.getCashOnHand()));
	}

	public static String currencyConversion(double amount){
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CANADA);
        String currency = format.format(amount);
        return currency;
	}

	public static void quantityOfSnack(Snack obj){
		System.out.println("Quantity of snack " + obj.getId() + " is " + obj.getQuantity());
	}

	public static void vendingMachine(Hashtable <Integer, String> vending, List <Snack> snack){
		for (Snack s: snack){
			System.out.println("Snack: " + s.getName());
			System.out.println("Vending Machine: " + vending.get(s.getVendingMachineId()));
			System.out.println("Quantity: " + s.getQuantity());
			System.out.println("Total Cost: " + currencyConversion(s.getTotalCost(s.getQuantity())));
			System.out.println();
		}
	}
}