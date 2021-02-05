package com.cse21;
import java.util.Random;
import java.util.Scanner;

public class Error {
	public static void main(String[] args) {
		System.out.print("Enter the number of Cheeses for shop setup: ");
		Scanner scanner= new Scanner(System.in);
		int MAXCHEESE = scanner.nextInt();
		while (MAXCHEESE < 0 || MAXCHEESE > 20) {
			System.out.println("PLease enter an integer (0-20)");
			System.out.print("Enter the number of Cheeses for shop setup: ");
			MAXCHEESE = scanner.nextInt();
		}

		String[] strings = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		double[] amounts = new double[MAXCHEESE];

		// Three Special Cheeses
		ClassesofCheese(MAXCHEESE, strings, prices);
		System.out.println("We sell " + MAXCHEESE + " kinds of Cheese:");
		SetPrices(MAXCHEESE, strings, prices);

		Random generator;
		generator = new Random(100);

		// Random cheese
		int i = 3;
		while (i < MAXCHEESE) {
			strings[i] = "Cheese Type " + (char)('A' + i);
			prices[i] = generator.nextInt(1000)/100.0;
			amounts[i] = 0;

			System.out.println(strings[i] + ": $" + prices[i] + " per pound");
			i++;
		}
	}

	public static void SetPrices(int MAXCHEESE, String[] names, double[] prices) {
		if (MAXCHEESE >= 1) {
			System.out.println(names[0] + ": $" + prices[0] + " per pound");
		}
		if (MAXCHEESE >= 2) {
			System.out.println(names[1] + ": $" + prices[1] + " per pound");
		}
		if (MAXCHEESE >= 3) {
			System.out.println(names[2] + ": $" + prices[2] + " per pound");
		}
	}

	public static void ClassesofCheese(int MAXCHEESE, String[] names, double[] prices) {
		if (MAXCHEESE >= 1) {
			names[0] = "Humboldt Fog";
			prices[0] = 25.00;
		}
		if (MAXCHEESE >= 2) {
			names[1] = "Red Hawk";
			prices[1] = 40.50;
		}
		if (MAXCHEESE >= 3) {
			names[2] = "Teleme";
			prices[2] = 17.25;
		}
	}

}


