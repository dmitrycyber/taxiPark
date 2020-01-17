package com.ivoninsky.taxipark;

import com.ivoninsky.taxipark.consoleNavigation.MainMenu;


import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MainMenu mainMenu = new MainMenu();
        mainMenu.start();


    }
}
