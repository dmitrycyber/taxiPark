package com.ivoninsky.taxipark.consoleNavigation.commands.adminFunctions;

import com.ivoninsky.taxipark.consoleNavigation.commands.Command;
import com.ivoninsky.taxipark.interfaces.TaxiPark;
import com.ivoninsky.taxipark.validators.FileNameValidator;

import java.util.Scanner;

public class AddCarsToFileCommand implements Command {
    @Override
    public void execute(TaxiPark taxiPark) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input filename like \"test.json\": ");
        String fileName = sc.next();
        FileNameValidator fileNameValidator = new FileNameValidator();
        while (!fileNameValidator.validate(fileName)) {
            System.out.println("file name is incorrect, please input name like \"test.json\": ");
            fileName = sc.next();
        }
        taxiPark.writeCarsToJSON(fileName);
    }
}
