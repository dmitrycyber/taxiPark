package com.ivoninsky.taxipark.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileNameValidator {
    private Pattern pattern;
    private Matcher matcher;

    private final String FILENAME_PATTERN = "^[A-z0-9_-]{1,10}.json";

    public FileNameValidator(){
        pattern = Pattern.compile(FILENAME_PATTERN);
    }

    public boolean validate(String fileName){
        matcher = pattern.matcher(fileName);
        return matcher.matches();
    }

}
