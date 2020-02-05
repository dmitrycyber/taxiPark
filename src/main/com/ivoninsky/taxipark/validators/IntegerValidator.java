package com.ivoninsky.taxipark.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntegerValidator {
    private Pattern pattern;
    private Matcher matcher;

    private static String COUNTOFCARS_PATTERN = "[0-9]{1,10}";

    public IntegerValidator() {
        pattern = Pattern.compile(COUNTOFCARS_PATTERN);
    }

    public boolean validate(String countOfCars) {
        matcher = pattern.matcher(countOfCars);
        return matcher.matches();
    }

}
