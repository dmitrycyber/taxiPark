package com.ivoninsky.taxipark.consoleNavigation;

import com.ivoninsky.taxipark.interfaces.TaxiPark;
import com.ivoninsky.taxipark.taxiparks.Uber;
import java.util.Scanner;

public class MainMenu {
    private TaxiPark taxiPark;

    public void start(){
        taxiPark = new Uber();
        System.out.println("Hello, input your role (admin/user): ");
        defineRole();
    }

    private void defineRole(){
        Scanner sc = new Scanner(System.in);
        String role = sc.next();
        while (!role.equals("admin") && !role.equals("user")){
            System.out.println("Input your role correctly (admin/user)");
            role = sc.next();
        }
        if (role.equals("admin")){
            System.out.println("Hello, admin!");
            AdminFunctions adminFunctions = new AdminFunctions(taxiPark);
            adminFunctions.adminFunctionality();
        }
        else {
            System.out.println("Hello, user!");
        }
        sc.close();
    }

}
