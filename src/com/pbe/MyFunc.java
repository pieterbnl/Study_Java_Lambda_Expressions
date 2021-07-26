package com.pbe;

// Functional interface that operates on an array and a value
// and returns an int result
interface MyFunc<T> {
    int func(T[] vals, T v);
}