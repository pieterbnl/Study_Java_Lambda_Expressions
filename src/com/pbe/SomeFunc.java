package com.pbe;

// Generic functional interface
// T specifies both the return type and the parameter type of func()
// This makes it compatible with any lambda expression that takes one parameter and returns a valuer of the same type
// This way, SomeFunc can be used to provide a reference to two different types of lambdas
public interface SomeFunc<T> {
    T func(T t);
}