package com.pbe;

public class StaticMyStringOps {

    // Static method strReverse() that accepts a string, reverses it, and returns it as String
    static String strReverse(String str) {
        String result = "";
        for (int i = str.length()-1; i >= 0; i--)
            result += str.charAt(i);
        return result;
    }

}