package Util;

import java.util.Scanner;

public class UserInputOutput {
    static Scanner scanner = new Scanner(System.in);

    public static String getStockName(){
        System.out.println("Enter the name : ");
        return scanner.next();
    }

    public static int getStockPrice(){
        System.out.println("Enter the price : ");
        return scanner.nextInt();
    }

    public static int getNumberOfShares(){
        System.out.println("Enter the number of stocks : ");
        return scanner.nextInt();
    }

    public static int displayOptions(){
        System.out.println("Press 1 - to add new Company to portfolio ");
        System.out.println("Press 2 - to get Particular Stock Value ");
        System.out.println("Press 3 - to get Total Value of the Stock ");
        System.out.println("Press 4 - to Buy Shares ");
        System.out.println("Press 5 - to Sell Shares ");
        System.out.println("Press 6 - to Print Report ");
        System.out.println("Press 7 - to Exit ");

        return scanner.nextInt();
    }
}
