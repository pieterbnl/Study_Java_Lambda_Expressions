package com.pbe;

public interface DblNumericArrayFunc {

    // Note: inclusion of throws clause is necessary
    // Without out, the program would not compile
    // because the lambda expression as used in main() will no longer be compatible with func()
    double func(double[] n) throws EmptyArrayException;

}