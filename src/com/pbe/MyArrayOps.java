package com.pbe;

// A non generic class that contains generic method countMatching()
public class MyArrayOps {

    // Static method countMatching() returns the number of items in an array
    // that are equal to a specified value.
    static <T> int countMatching(T[] vals, T v) {
        int count = 0;
        for (int i=0; i < vals.length; i++)
            if(vals[i] == v) count++;
        return count;
    }

}