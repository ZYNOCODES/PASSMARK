package com.example.passmark;

public class Validator {

    public boolean isValidFloat(String str)
    {
        float a;
        try {
            a = Float.parseFloat(str);
            return true;
        }
        catch(NumberFormatException nfe){
            return false;
        }
    }
}
