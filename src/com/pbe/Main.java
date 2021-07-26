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

// Block lambda expression
// The body of a lambda expressions can consist of:
// - A single expression. These lambda bodies are referred to as 'expression bodies', and the lambda type 'expression lambdas'.
// - A block of code. These lambda bodies are referred to as 'block bodies', and the lambda type 'block lambdas'.
//
// A block body expands the types of operations that can be handles within a lambda expression.
// It can contain multiple statements, variables, loops, if and switch statements, nested blocks, etc.
// Similar to a method body, the block body of a lambda expression is enclosed with {}
// Key difference between a block lambda and expression lambda,
// is that a block lambda requires an explicit use of a return statement to return a value.
// Reason is that a block lambda body does not represent a single expression
// NOTE: when a return statement occurs within a lambda expression, it causes a return from the lambda.
// It does not cause an enclosing method to return

// Generic Functional interfaces
// A lambda expression cannot be generic because itself cannot specify type parameters.
// However, the functional interface associated with a lambda expression can be generic:
// The target type of the lambda expression is in part determined by the type argument(s)
// that are specified when a functional interface reference is declared.
// Instead of having two functional interfaces whose methods differ only in their data types,
// it is possible to declare one generic interface that can be used to handle both circumstances.

// Passing Lambda expressions as argument
// Passing a lambda expressions as argument is a common use of lambdas.
// It provides a way to pass executable code as an argument to a method.
// The type of the parameter receiving the lambda expression argument must be
// of a functional interface type compatible with the lambda.

// Lambda expressions and exceptions
// A lambda expression can throw an exception.
// If it throws a checked exception, then it must be compatible with the exception(s)
// listed in the throws clause of the abstract method in the functional interface.

// Lambda expressions and variable capture
// Variables defined by the enclosing scope of a lambda expression are accessible within the lambda expression.
// A lambda expression also has access to 'this' (explicitly & implicitly), which refers to the invoking
// instance of the lambda expression's enclosing class.
// A special situation occurs when a lambda expression uses a local variable from its enclosing scope,
// which is referred to as a 'variable capture'. In such situation, a lambda expression may only use
// local variables that are effectively final (= a variable whose value does not change after it is first assigned).
// Noe that a local variable of the enclosing scope cannot be modified by the lambda expression.

// Method references
// An important feature related to expressions is the 'method reference'.
// A method reference provides a way to a method without executing it.
// Like a lambda expression, it requires a target type context that consists of a compatible functional interface.
// When evaluated, the reference creates an instance of the functional interface.
// There are different types of method references:
// 1. A static method reference. Syntax: ClassName::methodName
// 2. A reference to an instance method on a specific object. Syntax: objRef::methodName
// 3. A reference to an instance method on a specific class. Syntax: ClassName:instanceMethodName
// 4. A reference with generic classes and/or generic methods.
// One place method references can be quite useful is when using the Collections Framework+

// Constructor references
// T.b.d.

// Predefined Functional Interfaces
// Package java.util.function provides several predefined functional interfaces:
// UnaryOperator<T>, BinaryOperator<T>, Consumer<T>, Supplier<T>, Function<T,R>, Predicate<T>

public class Main {

    public static void main(String[] args) throws EmptyArrayException {

        // **********************
        // Simple lambda expression example
        // **********************
        System.out.println("Simple lambda expression example");
        // Declare an interface reference
        MyNum myNum;

        // Lambda expression as simple constant expression, assigned to myNum
        // This will trigger a class instance to be constructed
        // In which the lambda expression implements the MyNum getValue() method
        myNum = () -> 12345.678;

        // call getValue()
        System.out.println("Fixed value: " + myNum.getValue());

        // Another lambda expression
        myNum = () -> Math.random() * 2;
        System.out.println("A random value: " + myNum.getValue());
        System.out.println("Another random value: " + myNum.getValue());
        System.out.println();

        // This won't work.
        // A lambda expression must be compatible with the method defined by the functional interface.
        // myNum = () -> "1234.567"; // bad return type: a double value is expected, not a String value

        // **********************
        // Another simple lambda expression example
        // Applying two different tests to the same functional interface reference
        // **********************
        System.out.println("Another simple lambda expression example, applying 2 different tests");

        // Lambda expression to test if a number is even
        // Note: when using only 1 parameter, n in this case, the parentheses () around it are not mandatory to use
        MyNumTest isEven = (n) -> (n % 2) == 0;
        //MyNumTest isEven = n -> (n % 2) == 0; // also works

        // Test if a number is even
        int num = 10;
        if (isEven.test(num)) {
            System.out.println(num + " is even");
        } else {
            System.out.println(num + " is not even");
        }

        // Lambda expression to test if a number is non negative
        // Note that the type of n is not specified, it's inferred from the context
        MyNumTest isPostive = (n) -> n >= 0;

        // Test if a number is non negative
        // Note that both this and the previous test can be executed through a MyNumTest reference,
        // because a functional interface reference can be used to execute any lambda expression that is compatible.
        num = 0;
        if (isEven.test(num)) {
            System.out.println(num + " is non negative");
        } else {
            System.out.println(num + " is negative");
        }
        System.out.println();

        // **********************
        // Using multiple parameters in a lambda expression
        // **********************
        System.out.println("Using multiple parameters in a lambda expression");

        // Lambda expression to determine if one number is a factor of another
        // Note that no type is specified, as they are inferred from the context.
        // However, when using multiple parameters and having to need to explicitly declare one parameter,
        // then ALL parameters must have declared types.
        MyNumTest2 isFactor = (n, d) -> (n % d) == 0;

        int num1 = 10;
        int num2 = 2;
        if (isFactor.test(num1, num2)) {
            System.out.println(num2 + " is a factor of " + num1);
        } else {
            System.out.println(num2 + " is not a factor of " + num1);
        }
        System.out.println();

        // **********************
        // Block lambda example
        // **********************
        System.out.println("Using a expression body in a lambda expression");

        // Block lambda, computing the factorial of an int value
        NumFunc factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++)
                result = i * result;
            return result; // returns from lambda (does not cause an enclosing method to return)
        };

        System.out.println("The factorial of 5 is " + factorial.func(5));
        System.out.println("The factorial of 8 is " + factorial.func(8));
        System.out.println();

        // **********************
        // Another block lambda example
        // **********************
        System.out.println("Another block lambda");

        // Block lambda that reverses the characters in a String.
        // The functional interface StringFunc declares the func() method
        // The func() method takes a parameter of type String and has a return type of String
        // The type 'str' in the lambda expression is inferred to be a String
        StringFunc reverse = (str) -> {
            String result = "";
            for (int i = str.length() - 1; i >= 0; i--)
                result += str.charAt(i);
            return result;
        };
        System.out.println("Lambda reversed is " +
                reverse.func("My Lambda"));
        System.out.println("Expression reversed is " +
                reverse.func("Another expression"));
        System.out.println();

        // **********************
        // Lambda using a generic functional interface
        // **********************
        System.out.println("Using a generic functional interface");

        // SomeFunc can be used to provide a reference to two different types of lambdas,
        // for example being String or Integer.
        // Using String based version of SomeFunc
        SomeFunc<String> reverse2 = (str) -> {
            String result = "";
            for (int i = str.length() - 1; i >= 0; i--)
                result += str.charAt(i);
            return result;
        };
        System.out.println("Lambda reversed is " +
                reverse.func("My Lambda"));
        System.out.println("Expression reversed is " +
                reverse.func("Another expression"));
        System.out.println();

        // Using Integer based version of SomeFunc
        SomeFunc<Integer> factorial2 = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++)
                result = i * result;
            return result;
        };
        System.out.println("The factorial of 5 is " + factorial.func(5));
        System.out.println("The factorial of 8 is " + factorial.func(8));
        System.out.println();

        // **********************
        // Passing lambda expressions as arguments
        // **********************
        System.out.println("Passing a lambda expression as argument");

        String inStr = "More lambda stuff";
        String outStr;

        System.out.println("Input string: " + inStr);

        // stringOp() is passed an expression lambda that uppercases a string
        // This triggers the creation of an instance of the functional interface StringFunc
        // A reference to that object is passed to the first parameter of StringOp()
        // This way, the lambda code embedded in a class instance is passed to the method
        // The target type context is determined by the type of the parameter
        outStr = stringOp((str) -> str.toUpperCase(), inStr);
        System.out.println("The string in uppercase: " + outStr);

        // stringOp() is passed a block lambda that removes spaces
        outStr = stringOp((str) -> {
            String result = "";
            int i;
            for (i = 0; i < str.length(); i++)
                if(str.charAt(i) != ' ')
                    result += str.charAt(i);
                return result;
        }, inStr);
        System.out.println("Possible spaces have been removed from the given string: " + outStr);
        System.out.println();

        // **********************
        // Lambda expression exceptions example
        // **********************
        // Note: this example uses func() in DblNumericArrayFunc
        // Inclusion of the throws clause in func() is necessary, because without it,
        // the program would not compile because the lambda expression would no longer be compatible with func().
        System.out.println("Lambda expression exceptions example");
        double[] values = { 1.1, 2.2, 3.3, 4.4 };

        // Computing the avg of an array of doubles
        // Note: simply specifying 'n' although DblNumericArrayFunc func() requires an array
        // This works, because the type of the lambda expression is inferred from the target context
        DblNumericArrayFunc avg = (n) -> {
            double sum = 0;
            if(n.length == 0)
                throw new EmptyArrayException();

            for (int i=0; i < n.length; i++)
                sum += n[i];

            return sum / n.length;
        };

        System.out.println("The avg is: " + avg.func(values));
        // The following causes an EmptyArrayException to be thrown
        // System.out.println("The avg is " + avg.func(new double[0]));
        System.out.println();

        // **********************
        // Variable capture
        // **********************
        System.out.println("Variable capture");
        int somevalue = 5; // a local variable that can be captured
        NumFunc myLambda = (n) -> {
            int v = somevalue + n; // acceptable use of num because it does not modify num
            // num++; // illegal use of num because it attempts to modify its value
            return v;
        };
        // num = 9 // also causing an error because it would remove the effectively final status from num

        // **********************
        // Method reference: static method reference
        // **********************
        System.out.println("Method reference: static method reference");
        inStr = "More lambda stuff";
        System.out.println("Input string: " + inStr);

        // Passing a method reference to stringOp()
        // This works because strReverse is compatible with the StringFunc functional interface
        // MyStringOps::strReverse evaluates to a reference to an object
        // in which strReverse provides the implementation of func() in StringFunc
        outStr = stringOp(StaticMyStringOps::strReverse, inStr);
        System.out.println("Output string: " + outStr + "\n");

        // **********************
        // Method reference: instance method reference with different objects
        // **********************
        System.out.println("Method reference:  instance method reference with different objects");
        inStr = "More lambda stuff";
        System.out.println("Input string: " + inStr);

        // Create a MyStringOps object
        MyStringOps myStringOpsOb = new MyStringOps();

        // Pass a method reference to the instance method strReverse to stringOp()
        outStr = stringOp(myStringOpsOb::strReverse, inStr);
        System.out.println("Output string: " + outStr + "\n");

        // **********************
        // Method reference with generic classes and -methods
        // **********************
        System.out.println("Method reference with generic classes and -methods");
        Integer[] int_array = { 1, 2, 3, 4, 2, 3, 4, 4, 5 };
        String[] str_array = { "One", "Two", "Three", "Two" };

        // Notice that the passing of type argument Integer occurs after the ::
        // When a generic method is specified as a method reference, its type argument
        // comes after the :: and before the method name
        // In this situation, explicitly specifying the type argument is actually not required
        // because the type argument can be automatically inferred
        int count = myOp(MyArrayOps::<Integer>countMatching, int_array, 4);
        System.out.println("int_array contains: " + count + " 4s");

        count = myOp(MyArrayOps::<String>countMatching, str_array, "Two");
        System.out.println("int_array contains: " + count + " Twos" + "\n");
    }

    // Method with a functional interface, StringFunc sf, as the type of the first parameter.
    // It can be passed a reference to any instance of that interface.
    // Including the instance created by a lambda expression.
    // The second parameter, s, specifies the String to operate on
    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    // Method with MyFunc functional interface as the type of its first parameter
    // The other two parameters receive an array and a value, both of Type T
    static <T> int myOp(MyFunc<T> f, T[] vals, T v) {
        return f.func(vals, v);
    }
}
