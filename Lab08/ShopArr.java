package com.cse21.cheeseFactoryArray;
import java.util.Random;
import java.util.Scanner;


public class ShopArr {
	// Instance Variables
	private Cheese[] cheese;
	private Scanner input;

	//Initialize method
	private void init(int max) {
		// Create max number of cheese pointers
		cheese = new Cheese[max];

		if (max > 0) {
			cheese[0] = new Cheese();
			cheese[0].setName("Humboldt Fog");
			cheese[0].setPrice(25.00);

			if (max > 1) {
				cheese[1] = new Cheese("Red Hawk");
				cheese[1].setPrice(40.50);

				if (max > 2) {
					cheese[2] = new Cheese("Teleme", 17.25);
					//cheese[0].setName("Wrong Name");
				}
			}
		}

		Random ranGen = new Random(100);

		for (int i = 3; i < max; i++) {
			// fill-in code
			cheese[i] = new Cheese();
			cheese[i].setName("Cheese Type " + (char)('A' + i));
			cheese[i].setPrice(ranGen.nextInt(1000)/100.0);
		}
	}


	public ShopArr() {
		System.out.print("Enter the number of Cheeses for shop setup: ");
		Scanner max = new Scanner(System.in);
		init(max.nextInt());
	}
	/*public ShopArr(Scanner input) {
		//fill-in code
		init(input.nextInt());
	}*/
	// displays intro message informing the user of various cheeses sold and gets amt of each cheese
	// the user would like to purchase
	private void intro(Scanner input) {
		this.input = input;
		System.out.println("We sell " + cheese.length + " types of Cheese");
		//Fill-in code
		for (int i = 0; i < cheese.length; i++) {
			System.out.println(cheese[i].getName() + ": $" + cheese[i].getPrice() + " per pound");
		} for (int i = 0; i < cheese.length; i++) {
			System.out.print("Enter the amount of " + cheese[i].getName() + ":");
			//input = input.nextDouble();
			cheese[i].setAmount (input);
		}
	}
	private double calcSubTotal() {
		double subTotal = 0;
		for (Cheese value : cheese) {
			subTotal += value.getPrice() * value.getAmount();
		}
		return subTotal;
	}

	private double[] discountSpecials() {
		double[] disSpecials = {0, 0};

		double hfAmt = cheese[0].getAmount(), rhAmt = cheese[1].getAmount();

		if (hfAmt > 0) {
			disSpecials[0] =(int)((hfAmt*2)/2);// Fill-in Code
		}

		if(rhAmt > 0) {
			disSpecials[1] =(int)((rhAmt*2)/3);// Fill-in Code
		}


		return disSpecials;
	}
	private void itemizedList() {
		int amt;
		double price = 0;

		System.out.println();

		for (int i = 0; i < cheese.length; i++) {
			if (cheese[i].getAmount() > 0) {
				double total = (cheese[i].getPrice() * cheese[i].getAmount());
				System.out.println(cheese[i].getAmount() + " lbs of " + cheese[i].getName() + " @ " + cheese[i].getPrice() + " = $" + total);
				price = cheese[i].getPrice();
			}
			else{
				System.out.println("No items were purchased.");
				break;
			}
		}
	}


	private double printSubTotals(double subTotal, double[] disSpecials) {
		System.out.print("\nOriginal Sub total : \t\t $");
		System.out.printf("%.2f",subTotal);
		System.out.println("");
		System.out.println("Specials...");

		if (disSpecials[0] < 1 && disSpecials[1] < 2 ) {
			System.out.print("None \t\t\t\t\t\t-$0.0 ");
			System.out.println();
		}
		if (disSpecials[0] >= 1) {
			System.out.print("Humbolt Fog (Buy 1 Get 1 Free): -$");
			System.out.printf("%.2f", (disSpecials[0]*(12.5)));
			disSpecials[0] = disSpecials[0]*(12.5);
			System.out.println();
		}
		if (disSpecials[1] >= 1) {
			System.out.print("Red Hawk (Buy 2 Get 1 Free):    -$");
			System.out.printf("%.2f", (disSpecials[1]*(20.25)));
			disSpecials[1] = disSpecials[1]*(20.25);
			System.out.println();
		}

		subTotal =(subTotal - (disSpecials[0]+ disSpecials[1]));

		System.out.print("New Sub total : \t\t\t $");
		System.out.printf("%.2f",subTotal);
		System.out.println();
		// Fix code
		return subTotal;
	}
	private void printFinalTotal(double newSubTotal) {
		double discountTen = 0;
		if (newSubTotal > 150 && newSubTotal < 250) {
			discountTen = .10 * newSubTotal;
			System.out.print("Additional 10% Discount : \t-$");
			System.out.printf("%.2f", discountTen);
			System.out.println();
		}
		else if (newSubTotal > 250 && newSubTotal > 150) {
			discountTen = .25 * newSubTotal;
			System.out.print("Additional 25% Discount : \t-$");
			System.out.printf("%.2f", discountTen);
			System.out.println();
		}
		else {
			System.out.print("Additional 0% Discount : \t-$");
			System.out.printf("%.2f", discountTen);
			System.out.println();
		}

		System.out.print("Final Total:\t\t\t\t $");
		System.out.printf("%.2f", (newSubTotal - discountTen));
		System.out.println();// Fill-in code

	}
	private void printFree(){
		double amt;
		System.out.println();
		System.out.println("Today is your lucky day!");
		for (int i = 0; i < cheese.length; i++) {
			if ((amt = cheese[i].getAmount()) > 0)
				System.out.println(amt + " lb of " + cheese[i].getName() + " @ $0 = " + 0);
			System.out.println("Total: FREE!\n");
		}
	}


	public void run() {

		Scanner input = new Scanner(System.in);
		intro(input);
		double subTotal = calcSubTotal();

		System.out.println();
		System.out.print("Display the itemized list? (1 for yes): ");
		int list = input.nextInt();
		if (list == 1)
			itemizedList();

		int free = (new Random()).nextInt(100);
		//System.out.println("Random num is " + free);
		if (free != 0) {
			double newSubTotal = printSubTotals(subTotal, discountSpecials());
			printFinalTotal(newSubTotal);
		} else {
			printFree();
			return;
		}

		System.out.println();
		System.out.print("Do you wish to redo your whole order? (1 for yes): ");
		int redo = input.nextInt();

		System.out.println();

		if (redo == 1)
			run();
		else
			System.out.println("Thanks for coming!");
	}
	}



