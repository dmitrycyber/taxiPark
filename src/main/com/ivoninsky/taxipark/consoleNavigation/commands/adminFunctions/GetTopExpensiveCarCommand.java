package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions;

import com.ivoninsky.taxipark.consoleNavigation.commands.Command;
import com.ivoninsky.taxipark.interfaces.TaxiPark;
import com.ivoninsky.taxipark.validators.IntegerValidator;

import java.util.Scanner;

public class GetTopExpensiveCarCommand implements Command {
    @Override
    public void execute(TaxiPark taxiPark) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input count of top expensive cars: ");
        String s = sc.next();
        IntegerValidator validаtor = new IntegerValidator();
        while (!validаtor.validate(s)) {
            if (!validаtor.validate(s)) {
                System.out.println("Input valid count of cars: ");
                s = sc.next();
                continue;
            }
            int countOfCars = Integer.parseInt(s);
            if (countOfCars > taxiPark.getListOfCars().size()) {
                System.out.println("There are not as many cars in taxi park, please input count of cars less, than " +
                        taxiPark.getListOfCars().size() +
                        " number of cars");
                s = sc.next();
                continue;
            }
            taxiPark.getTopExpensiveCars(countOfCars);
        }
    }
}
