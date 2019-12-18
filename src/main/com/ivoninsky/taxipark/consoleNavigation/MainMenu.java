package com.ivoninsky.taxipark.consoleNavigation;

import com.ivoninsky.taxipark.interfaces.TaxiPark;
import com.ivoninsky.taxipark.taxiparks.Uber;
import java.util.Scanner;

public class MainMenu {
    private TaxiPark taxiPark;
    private Scanner sc;

    public MainMenu(){
        sc = new Scanner(System.in);
    }

    public void start(){
        String isExit;
        taxiPark = new Uber();
        do{
            System.out.println("Hello, input your role (admin/user): ");
            defineRole();
            System.out.println("To swich user input \"1\" and \"any symbol\" to exit");
            isExit = sc.next();
        }
        while (isExit.equals("1"));
        sc.close();
    }

    private void defineRole(){
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
            UserFunctions userFunctions = new UserFunctions(taxiPark);
            userFunctions.userFunctionality();
        }
    }

}
