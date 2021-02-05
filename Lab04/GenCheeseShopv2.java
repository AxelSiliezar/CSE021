package com.cse21;
import java.util.Random;
import java.util.Scanner;

public class GenCheeseShopv2 {

	public static void intro(String[] names, double[] prices, double[] amounts) {
		System.out.println("We sell " + names.length + " kinds of cheese, in 0.5 lb packages");
		if (names.length >= 1) {
			names[0] = "Humboldt Fog";
			prices[0] = 25.00;
		}
		if (names.length >= 2) {
			names[1] = "Red Hawk";
			prices[1] = 40.50;
		}
		if (names.length >= 3) {
			names[2] = "Teleme";
			prices[2] = 17.25;
		}
		if (names.length >= 1) {
			System.out.println(names[0] + ": $" + prices[0] + " per pound");
		}
		if (names.length >= 2) {
			System.out.println(names[1] + ": $" + prices[1] + " per pound");
		}
		if (names.length >= 3) {
			System.out.println(names[2] + ": $" + prices[2] + " per pound");

			Random ranGen = new Random(100);

			for (int i = 3; i < names.length; i++) {
				names[i] = "Cheese Type " + (char) ('A' + i);
				prices[i] = ranGen.nextInt(1000) / 100.0;
				amounts[i] = 0;

				System.out.printf("%s: $%s per pound%n", names[i], prices[i]);
			}
		}

	}

	/*
	 * Gets the amount of each cheese the user would like to purchase and populates
	 * the amounts array with the user inputs. Performs with input validation
	 * (amount >= 0 and multiple of 0.5).
	 */
	public static void getAmount(Scanner sc, String[] names, double[] amounts) {
		for (int i = 0; i < names.length; i++) {
			System.out.print("Enter the amount of " + names[i] + " in lbs: ");
			amounts[i] = sc.nextDouble();
			while(amounts[i]% .5 != 0 || amounts[i] < 0){
				if (amounts[i]% .5 != 0) {
					System.out.print("Invalid scanner. Enter a value that's multiple of 0.5: ");
					amounts[i] = sc.nextDouble();
				}
				else if (amounts[i] < 0) {
					System.out.print("Invalid scanner. Enter a value >= 0: ");
					amounts[i] = sc.nextDouble();
				}
			}
		}
	}// Fill-in


	/*
	 * Displays the itemized list of all cheeses bought or a special message if none
	 * were purchased.
	 */
	public static void itemizedList(String[] names, double[] prices, double[] amounts) {
		double subtotal = 0;

		if (names.length >= 1) {
			if (amounts[0] > 0) {
				System.out.println(amounts[0] + " lbs of " + names[0] + " @ "+ prices[0] + " = $"+ (25.0* amounts[0]));
				subtotal = subtotal + (amounts[0]* prices[0]);
			}
		}
		if (names.length >= 2) {
			if (amounts[1] > 0) {
				System.out.println(amounts[1] + " lbs of " + names[1] + " @ "+ prices[1] + " = $"+ (40.5* amounts[1]));
				subtotal = subtotal + (amounts[1]* prices[1]);
			}
		}
		if (names.length >= 3) {
			if (amounts[2] > 0)
				System.out.print(amounts[2] + " lbs of " + names[2] + " @ "+ prices[2] + " = $"+ (17.25* amounts[2]));
			System.out.println();
			subtotal = subtotal + (amounts[2]* prices[2]);
		}
		for (int i = 3; i < names.length; i++) {
			names[i] = "Cheese Type " + (char)('A' + i);
			System.out.print(amounts[i] + " lb of " + names[i] + " @ " + prices[i] + " = ");
			System.out.printf("%.2f", prices[i]* amounts[i]);
			System.out.println();
			subtotal = subtotal + (amounts[i]* prices[i]);
		}
		if (amounts[0] == 0 && amounts[1] == 0 && amounts[2] == 0) {
			System.out.println("No items were purchased");
		}
	}


	/*
	 * Calculates the Original Sub Total, which is the price*amount of each
	 * cheese added together. Returns the Original Sub Total.
	 */
	public static double calcSubTotal(double[] prices, double[] amounts) {
		double sub = 0;
		for(int i = 0; i< amounts.length; i++){
			sub = prices[i]*amounts[i]+sub;// Fix
		}
		return sub;

	}

	/*
	 *  Calculates discounts based on special offers on Humboldt Fog and Red Hawk,
	 *  stores them in disSpecials[0] and disSpecials[1], and returns the array.
	 */
	public static double[] discountSpecials(double[] amounts, double[] prices) {
		// Fix
		double discountRed = (int) (amounts[1] * 2) / 3;
		double discountHum = (int) ((amounts[0] * 2) / 2);
		double[] disSpecials = new double[amounts.length];

		if (amounts[0] >= 1) {
			disSpecials[0] = (discountHum * (prices[0]/2));
			System.out.println();
		}

		if (amounts[1] >= 2) {
			disSpecials[1] = (discountRed * (prices[1]/2));
			System.out.println();

		}
		return disSpecials;
	}

	/*
	 * Displays the Original Sub Total, discounts based on specials, and the New Sub
	 * Total. Returns the New Sub Total.
	 */
	public static double printSubTotals(double subTotal, double[] disSpecials) {
		double discounted = 0;
		System.out.println();
		System.out.println();
		System.out.print("Original Sub total : \t\t\t $");
		System.out.printf("%.2f",subTotal);
		System.out.println();
		System.out.println("Specials...");
		if (disSpecials[0] != 0 ){
			System.out.print("Humbolt Fog (Buy 1 Get 1 Free): -$");
			System.out.printf("%.2f", (disSpecials[0]));
			subTotal -= disSpecials[0];
			System.out.println();
		}
		if (disSpecials[1] != 0){
			System.out.print("Red Hawk (Buy 2 Get 1 Free):    -$");
			System.out.printf("%.2f", (disSpecials[1]));
			subTotal -= disSpecials[1];
			System.out.println();
		}
		if (subTotal > 150 && subTotal < 250) {
			discounted = .10 * subTotal;
			System.out.print("Additional 10% Discount : \t\t-$");
			System.out.printf("%.2f", discounted);
			subTotal -= discounted;
			System.out.println();
		}
		else if (subTotal > 250 && subTotal > 150) {
			discounted = .25 * subTotal;
			System.out.print("Additional 25% Discount : \t\t -$");
			System.out.printf("%.2f", discounted);
			subTotal -= discounted;
			System.out.println();
		}
		else {
			System.out.print("Additional 0% Discount : \t\t-$");
			System.out.printf("%.2f", discounted);
			subTotal -= discounted;
			System.out.println();
		}// Fix

		return subTotal;
	}

	/*
	 * Calculates the additional discount based on the New Sub Total and displays
	 * the Final Total.
	 */
	public static void printFinalTotal(double newSubTotal) {
		System.out.print("Final Total:\t\t\t\t\t $");
		System.out.printf("%.2f", (newSubTotal));
		System.out.println();// Fill-in

	}

	/*
	 * Program starts here
	 */
	public static void main(String[] args) {

		final int MAXCHEESE;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of cheeses for shop setup: ");
		MAXCHEESE = sc.nextInt();
		if (MAXCHEESE == 0) {
			System.out.println("We sell 0 kinds of cheese in 0.5 lb packages");
			System.out.println();
			System.out.println("Specials...");
			System.out.println("Original Sub total : 0.00 $");
			System.out.println("Final Sub total :    0.00 $");
		} else {

			// DO NOT CHANGE ANYTHING BELOW
			String[] names = new String[MAXCHEESE];
			double[] prices = new double[MAXCHEESE];
			double[] amounts = new double[MAXCHEESE];

			intro(names, prices, amounts);

			getAmount(sc, names, amounts);

			double subTotal = calcSubTotal(prices, amounts);


			System.out.print("\nDisplay the itemized list? (1 for yes) ");
			int display = sc.nextInt();

			if (display == 1) {
				itemizedList(names, prices, amounts);
			}

			double newSubTotal = printSubTotals(subTotal, discountSpecials(amounts, prices));

			printFinalTotal(newSubTotal);

			sc.close();
		}
	}
}