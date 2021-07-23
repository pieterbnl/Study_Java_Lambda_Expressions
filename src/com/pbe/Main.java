package com.pbe;

/** Study on Lambda Expressions
 * Following Java The Complete Reference by Herbert Schildt i.c.w. (Udemy) Java programming masterclass for software developers Tim Buchalka.
 @author Pieter Beernink
 @version 1.0
 @since 1.0
 */

// *********************
// LAMBDA EXPRESSIONS
// *********************
// Lambda expressions were added by JDK8.
// It added new syntax elements, increasing the expressive power of the language.
// It also resulted in new capabilities being incorporated into the API library, such as the ability
// to more easily take advantage of parallel processing capabilities of multicore environments.
// And it triggered new Java features, such as the 'default method', which lets define default behavior for an interface method.
// And the 'method reference', which allows to refer to a method without executing it.
//
// A lambda expression is a short line or block of code which takes in parameters and returns a value.
// A lambda expression is, essentially, an anonymous (read: unnamed) method.
// They are similar to methods, but they do not need a name can be implemented directly in to the body of a method.
// A lambda expression results in a form of anonymous class. It can passed around as if it was an object and executed on demand.
// The lambda expression is not executed on its own, it is used to implement a method defined by a functional interface.
// NOTE: Lambda expressions are also commonly referred to as 'closures'.
//
// A functional interface is an interface that contains one and only one abstract method; it represents a single action.
// An example of a functional interface is Runnable, as it only defines on method: run(), which defines the action of Runnable.
// A functional interface defines the target type of a lambda expression.
// Lambda expressions can be used only in a context in which its target type if specified.
// NOTE: a functional interface is sometimes referred to as a SAM type (Single Abstract Method).
//
// Java Lambda Expressions are often used in functional programming.
// Java lambda expressions are commonly used to implement simple event listeners / callbacks.

// Lambda expression fundamentals
// The lambda expression introduced a new syntax element and operator.
// The lambda operator -> (which can be verbalized as 'becomes' or 'goes to') divides a lambda expression in two parts.
// The left side specifies any parameters required by the lambda expression (or in case of no parameters: an empty parameter list).
// The right side is the 'lambda body', which specifies the actions of the lambda expression.
// The body can be a single expression or a block of code.
//
// Examples of lambda expressions:
// () -> 12345.678
// () -> Math.random() * 2
// (n) -> (n % 2) == 0
//
// In the last example, the expression returns true if the value of parameter n is even.
// It's possible to explicitly specify the type of a parameter, but often its type can be inferred.
// NOTE: when using multiple parameters and specifying the type of one parameter.. all parameters are required to be specified.

// Functional interfaces
// As per JDK8 it's possible to specify a default implementation for a method declared in an interface.
// An interface method is abstract only if it does not specify an implementation.
// Non-default, non-static, non-provide interface methods are implicitly abstract,
// meaning there is no need to use the abstract modifier per se.
//
// Example of a functional interface, with getValue() defining it's function:
// interface MyNumber { double getValue(); }
//
// A lambda expression can be specified only in a context in which a target type is defined.
// One of these context is created when a lambda expression is assigned to a functional interface reference.
// Some other target type contexts: variable initialization, return statements, method arguments.
//
// Example of lambda expression assigned to interface reference:
// myNum = () -> 12345.678
//
// When getValue() is called, the value 12345.678 will be returned, because of the lambda expression assigned to myNum.
// For a lambda expression to be used in a target type context, the type of the abstract method and the type of the
// lambda expression must be compatible with the method's parameters. Meaning:
// - the return types must be compatible
// - exceptions thrown by the lambda expression must be acceptable to the method


public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
