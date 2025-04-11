package com.taxiapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaxiBookingApp.initializeTaxis(4); // Initialize 4 taxis

        while (true) {
            System.out.println("\n1. Book Taxi");
            System.out.println("2. Display Taxi Details");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Customer ID: ");
                    int custId = sc.nextInt();
                    System.out.print("Pickup Point (A-F): ");
                    char pickup = sc.next().toUpperCase().charAt(0);
                    System.out.print("Drop Point (A-F): ");
                    char drop = sc.next().toUpperCase().charAt(0);
                    System.out.print("Pickup Time (Hour 0-23): ");
                    int time = sc.nextInt();
                    TaxiBookingApp.bookTaxi(custId, pickup, drop, time);
                    break;

                case 2:
                    TaxiBookingApp.displayTaxis();
                    break;

                case 3:
                    System.out.println("Exiting.");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
