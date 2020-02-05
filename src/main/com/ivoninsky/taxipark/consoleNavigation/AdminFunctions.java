package com.ivoninsky.taxipark.consoleNavigation;

import com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions.CommandContainer;
import com.ivoninsky.taxipark.interfaces.TaxiPark;

import java.util.Scanner;

public class AdminFunctions {
    private TaxiPark taxiPark;
    private Scanner sc = new Scanner(System.in);
    private CommandContainer commandContainer = new CommandContainer();

    public AdminFunctions(TaxiPark taxiPark) {
        this.taxiPark = taxiPark;
    }

    public void adminFunctionality() {
        sc = new Scanner(System.in);
        String command;
        do {
            System.out.println("\n" + "Input number of function: ");
            System.out.println("1. Add cars to taxi park from file" + "\n" +
                    "2. Get cars" + "\n" +
                    "3. Get cost of cars" + "\n" +
                    "4. Order cars by fuel consumption" + "\n" +
                    "5. Search car by criteria" + "\n" +
                    "6. Get top expensive cars" + "\n" +
                    "7. Add cars to file" + "\n" +
                    "Input \"~\" for exit");
            command = sc.next();
            try {
                if (command.equals("~")) {
                    break;
                }
                commandContainer.getCommandMap().get(command).execute(taxiPark);
            } catch (NullPointerException e) {
                System.out.println("There are no command in list, please enter command number again!");
                command = sc.next();
            }
        }
        while (!command.equals("~"));
    }
}
