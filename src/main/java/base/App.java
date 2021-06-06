package base;

/*
 *  UCF COP3330 Summer 2021 Assignment 20 Solution
 *  Copyright 2021 Brianne Juntunen
 */
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();

        double subtotal = myApp.promptSubtotal();
        double stateTax = myApp.promptState();
        double countyTax = 0;
        if(stateTax == 0.05){
            countyTax = myApp.promptCounty();
        }

        double total = myApp.calculateTotal(subtotal, stateTax, countyTax);

        myApp.printOutput(subtotal, total);

    }

    public void printOutput(double subtotal, double total){
        if(total != subtotal){
            printTax(subtotal, total);
        }
        printTotal(total);
    }

    public void printTotal(double total){
        System.out.printf("The total is $%.2f.", total);
    }

    public void printTax(double subtotal, double total){
        double tax = total - subtotal;
        System.out.printf("The tax is $%.2f.\n", tax);
    }

    public double calculateTotal(double subtotal, double statetax, double countytax){
        double totalTax = statetax + countytax;
        return subtotal + (subtotal * totalTax);
    }

    public double promptState(){
        System.out.print("What state do you live in? ");
        String input = in.nextLine();
        if(input.equalsIgnoreCase("Wisconsin") ||
                input.equalsIgnoreCase("WI")){
            return 0.05; //5%
        } else if (input.equalsIgnoreCase("Illinois") ||
                input.equalsIgnoreCase("IL")){
            return 0.08; //8%
        }
        return 0;
    }

    public double promptCounty(){
        System.out.print("What county do you live in? ");
        String input = in.nextLine();
        if(input.equalsIgnoreCase("Eau Claire")){
            return 0.005;
        } else if (input.equalsIgnoreCase("Dunn")){
            return 0.004;
        }
        return 0;
    }

    public double promptSubtotal(){
        System.out.print("What is the order amount? ");
        return Double.parseDouble(in.nextLine());
    }


}