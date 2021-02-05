package com.cse21;
import java.util.Scanner;

public class CheeseShop {
    public static void main(String[] args) {
        double humboldtPrice = 25.00;
        double redHawkPrice = 40.50;
        double telemePrice = 17.25;
        Scanner numberInput = new Scanner(System.in);

        System.out.println("We sell 3 kinds of Cheese (in 0.5 lb packages): ");
        System.out.println("Humboldt Fog: $" + humboldtPrice + " per pound ");
        System.out.println("Red Hawk: $" + redHawkPrice + " per pound ");
        System.out.println("Teleme: $" + telemePrice +" per pound ");

        System.out.println();
        System.out.print("Enter the amount of Humboldt Fog in lbs: ");
        double humlbs = numberInput.nextDouble();
        humlbs = GetHumlbs(numberInput, humlbs);
        System.out.print("Enter the amount of Red Hawk in lbs: ");
        double Redlbs = numberInput.nextDouble();
        Redlbs = GetHumlbs(numberInput, Redlbs);
        System.out.print("Enter the amount of Teleme in lbs: ");
        double Telemelbs = numberInput.nextDouble();
        Telemelbs = GetHumlbs(numberInput, Telemelbs);
        System.out.println();
        System.out.print("Display the itemized list? (1 for yes): ");
        int display = numberInput.nextInt();
        if (display == 1) {
            if (humlbs > 0) {
                System.out.println(humlbs + " lb of Humboldt Fog @ $" + humboldtPrice + "= "  + (humboldtPrice * humlbs));
            }
            if (Redlbs > 0) {
                System.out.println(Redlbs + " lb of Red Hawk  @ $" + humboldtPrice + "= " + (redHawkPrice * Redlbs));
            }
            if (Telemelbs > 0) {
                System.out.println(Telemelbs + " lb of Teleme @ $" + telemePrice + "= " + (telemePrice * Telemelbs));
            }
        }
        final double subtotal = (humboldtPrice * humlbs) + (redHawkPrice * Redlbs) + (telemePrice * Telemelbs);
        System.out.println();
        System.out.println("Sub total : \t\t\t " + (subtotal));
        System.out.println("Discounts...");

        double discountHum = (int) ((humlbs * 2) / 2);
        double discountRed = (int) (Redlbs * 2) / 3;

        if (humlbs >= 1) {
            System.out.print("Humbolt Fog (Buy 1 Get 1 Free): -");
            System.out.printf("%.2f", (discountHum * (12.5)));
            System.out.println();
        }
        if (Redlbs >= 1.5) {
            System.out.print("Red Hawk (Buy 2 Get 1 Free):    -");
            System.out.printf("%.2f", (discountRed * (20.25)));
            System.out.println();
        }
        if (humlbs < 1 && Redlbs < 1.5) {
            System.out.print("None \t\t\t\t\t-$0.0 ");
            System.out.println();
        }

        var totaldiscount = discountHum * (12.5) + discountRed * (20.25);

        PriceandDiscount(humlbs, Redlbs, subtotal, discountHum, discountRed, totaldiscount);
    }

    public static double GetHumlbs(Scanner numberInput, double humlbs) {
        if (humlbs % .5 != 0 || humlbs < 0) {
            do {
                if (humlbs % .5 != 0) {
                    System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
                    humlbs = numberInput.nextDouble();
                } else if (humlbs < 0) {
                    System.out.print("Invalid input. Enter a value >= 0: ");
                    humlbs = numberInput.nextDouble();
                }
            } while (humlbs % .5 != 0 || humlbs < 0);
        }
        return humlbs;
    }

    public static void PriceandDiscount(double humlbs, double redlbs, double subtotal, double discountHum, double discountRed, double totaldiscount) {
        if (humlbs >= 1 && redlbs >= 1.5) {
            double totalamount = subtotal - totaldiscount;
            System.out.print("Final Total:\t\t\t ");
            System.out.printf("%.2f", totalamount);
        } else if (humlbs >= 1 && redlbs < 1.5) {
            double totalamount = subtotal - (discountHum * (12.5));
            System.out.print("Final Total:\t\t\t ");
            System.out.printf("%.2f", totalamount);
        } else if (redlbs >= 1.5 && humlbs < 1) {
            double totalamount = subtotal - (discountRed * (20.25));
            System.out.print("Final Total:\t\t\t ");
            System.out.printf("%.2f", totalamount);
        } else {
            double totalamount = subtotal;
            System.out.print("Final Total:\t\t\t ");
            System.out.printf("%.2f", totalamount);
        }
    }
}

