package com.cse21;
import java.util.Scanner;
import java.util.*;


public class GenCheeseShop {
    public static void main(String[] args) {
        // Setting Up the Cheese Shop
        System.out.print("Enter the number of Cheeses for shop setup: ");
        Scanner scanner= new Scanner(System.in);
        int MAXCHEESE = GetMaxCheese(scanner);
        //Strings and doubles
        String[] names = new String[MAXCHEESE];
        double[] prices = new double[MAXCHEESE];
        double[] amounts = new double[MAXCHEESE];

        // Humb, Red, Tele
        ThreeSpecial(MAXCHEESE, names, prices);

        System.out.println("We sell " + MAXCHEESE + " kinds of Cheese, in 0.5 lb packages.");

        //Check out the prices
        Pricesperlb(MAXCHEESE, names, prices);
        // Randomize the numbers
        RandomNumbers(MAXCHEESE, names, prices, amounts);

        //Verify that the numbers included are fitting to the standards
        Verification(scanner, MAXCHEESE, names, amounts);
        double subtotal = 0;
        System.out.println();
        System.out.print("Display the itemized list? (1 for yes): ");


        // LIST (IF VERIFIED) STARTS HERE!


        subtotal = GetSubtotal(scanner, MAXCHEESE, names, prices, amounts, subtotal);
        System.out.println();
        System.out.println();
        System.out.print("Original Sub total : \t\t\t $");
        System.out.printf("%.2f",subtotal);
        System.out.println();
        System.out.println("Specials...");

        double discountHum = 0;
        double discountRed = 0;
        if (MAXCHEESE >= 1)
            discountHum =(int)((amounts[0]*2)/2);
        if (MAXCHEESE >= 2)
            discountRed =(int)(amounts[1]*2)/3;
        // APPLY DISCOUNT FOR HUMBOLT
        subtotal = HumbDiscount(MAXCHEESE, subtotal, discountHum);
        // APPLY DISCOUNT FOR RED HAWK
        subtotal = RedDiscount(MAXCHEESE, subtotal, discountRed);

        // PRINT BILL



        if (MAXCHEESE < 1 && MAXCHEESE < 2) {
            System.out.print("None \t\t\t\t -$0.0 ");
            System.out.println();
        }

        System.out.print("New Sub total : \t\t\t\t $");
        System.out.printf("%.2f",subtotal);
        System.out.println();


        //Discount extra

        double discounted = AdditionalDiscount(subtotal);

        // CLOSING STATEMENT (BILLING)

        System.out.print("Final Total:\t\t\t\t\t $");
        System.out.printf("%.2f", (subtotal- discounted));
        System.out.println();
    }




    // METHODS START HERE



    public static double AdditionalDiscount(double subtotal) {
        double discounted = 0;
        if (subtotal > 150 && subtotal < 250) {
            discounted = .10 * subtotal;
            System.out.print("Additional 10% Discount : \t\t-$");
            System.out.printf("%.2f", discounted);
            System.out.println();
        }
        else if (subtotal > 250 && subtotal > 150) {
            discounted = .25 * subtotal;
            System.out.print("Additional 25% Discount : \t\t -$");
            System.out.printf("%.2f", discounted);
            System.out.println();
        }
        else {
            System.out.print("Additional 0% Discount : \t\t-$");
            System.out.printf("%.2f", discounted);
            System.out.println();
        }
        return discounted;
    }

    public static double RedDiscount(int MAXCHEESE, double subtotal, double discountRed) {
        double secondDis;
        if (MAXCHEESE >= 2) {
            System.out.print("Red Hawk (Buy 2 Get 1 Free):    -$");
            System.out.printf("%.2f", (discountRed*(20.25)));
            secondDis = (discountRed*(20.25));
            subtotal = subtotal - secondDis;
            System.out.println();
        }
        return subtotal;
    }

    public static double HumbDiscount(int MAXCHEESE, double subtotal, double discountHum) {
        double firstDis;
        if (MAXCHEESE >= 1 ) {
            System.out.print("Humbolt Fog (Buy 1 Get 1 Free): -$");
            System.out.printf("%.2f", (discountHum*(12.5)));
            firstDis = (discountHum*(12.5));
            subtotal = subtotal - firstDis;
            System.out.println();

        }
        return subtotal;
    }


    public static double GetSubtotal(Scanner scanner, int MAXCHEESE, String[] names, double[] prices, double[] amounts, double subtotal) {
        int display = scanner.nextInt();
        if (display == 1) ;
        {
            if (MAXCHEESE >= 1) {
                if (amounts[0] > 0) {
                    System.out.println(amounts[0] + " lbs of " + names[0] + " @ " + prices[0] + " = $" + (25.0 * amounts[0]));
                    subtotal = subtotal + (amounts[0] * prices[0]);
                }
            }
            if (MAXCHEESE >= 2) {
                if (amounts[1] > 0) {
                    System.out.println(amounts[1] + " lbs of " + names[1] + " @ " + prices[1] + " = $" + (40.5 * amounts[1]));
                    subtotal = subtotal + (amounts[1] * prices[1]);
                }
            }
            if (MAXCHEESE >= 3) {
                if (amounts[2] > 0)
                    System.out.print(amounts[2] + " lbs of " + names[2] + " @ " + prices[2] + " = $" + (17.25 * amounts[2]));
                System.out.println();
                subtotal = subtotal + (amounts[2] * prices[2]);
            }
            for (int i = 3; i < MAXCHEESE; i++) {
                names[i] = "Cheese Type " + (char) ('A' + i);
                System.out.print(amounts[i] + " lb of " + names[i] + " @ " + prices[i] + " = ");
                System.out.printf("%.2f", prices[i] * amounts[i]);
                System.out.println();
                subtotal = subtotal + (amounts[i] * prices[i]);
            }
            if (amounts[0] == 0 && amounts[1] == 0 && amounts[2] == 0) {
                System.out.println("No items were purchased");

            }
            return subtotal;
        }
    }

    public static void Verification(Scanner scanner, int MAXCHEESE, String[] names, double[] amounts) {
        for (int i = 0; i < MAXCHEESE; i++) {
            System.out.print("Enter the amount of " + names[i] + " in lbs: ");
            amounts[i] = scanner.nextDouble();
            while(amounts[i]% .5 != 0 || amounts[i] < 0){
                if (amounts[i]% .5 != 0) {
                    System.out.print("Invalid scanner. Enter a value that's multiple of 0.5: ");
                    amounts[i] = scanner.nextDouble();
                }
                else if (amounts[i] < 0) {
                    System.out.print("Invalid scanner. Enter a value >= 0: ");
                    amounts[i] = scanner.nextDouble();
                }
            }
        }
    }

    public static void Pricesperlb(int MAXCHEESE, String[] names, double[] prices) {
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

    public static int GetMaxCheese(Scanner input) {
        int MAXCHEESE = input.nextInt();
        while (MAXCHEESE < 0 || MAXCHEESE > 20) {
            System.out.println("PLease enter an integer (0-20)");
            System.out.print("Enter the number of Cheeses for shop setup: ");
            MAXCHEESE = input.nextInt();
        }
        return MAXCHEESE;
    }

    public static void ThreeSpecial(int MAXCHEESE, String[] names, double[] prices) {
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

    public static void RandomNumbers(int MAXCHEESE, String[] names, double[] prices, double[] amounts) {
        Random ranGen = new Random(100);

        for (int i = 3; i < MAXCHEESE; i++) {
            names[i] = "Cheese Type " + (char)('A' + i);
            prices[i] = ranGen.nextInt(1000)/100.0;
            amounts[i] = 0;

            System.out.printf("%s: $%s per pound%n", names[i], prices[i]);
        }
    }
}
