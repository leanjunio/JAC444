# Segment 1 - Methods

What are methods?
Methods are collection of statements that are grouped together to perform an operation.

![MethodsInJava](../../assets/methods/images/method_1.PNG)

## Types of Methods
There are two types of Methods in Java:
- Instance Methods
  - Object Level methods
  - Invocation: ObjRef.methodName()
  - Affect object state
- Static Methods
  - static keyword
  - Class level methods, i.e, No access to state, can't access instance variables/methods
  - Can access static variables
  - Invocation: className.methodName()

## Method Overloading
- If a class has multiple methods having same name but different in parameters, it is known as **Method Overloading**
- This can be done in two ways:
  - By changing the number of arguments
  - By changing the data type

*Can you overload a method by changing the return type?*
**NO.**

In Java, method overloading is not possible by changing the return type of the method only because of __ambiguity__.

```java
class Adder {
  static int add(int a, int b) { return a + b; }
  static double add(int a, int b) { return a + b; }
}

class TestOverloading3 {
  public static void main(String[] args) {
    System.out.println(Adder.add(11, 11)); // ambiguity
  }
}
```

*Can you overload the main function in Java?*
**Yes**

Yes, by method overloading. You can have any number of main methods in a class by method overloading. **HOWEVER**, keep in mind that the JVM only calls the main() method which receives a string array as its argument
```java
class TestOverloading4{
  public static void main(String[] args) {
    System.out.println("main with String[]");
  }
  public static void main(String args) {
    System.out.println("main with String");
  }
  public static void main() {
    System.out.println("main without args");
  }
}
```

## String[] args
String[] arguments is the array for runtime argument to our java program, if required we can pass arguments to our java program through the command line

```java
public class ArgumentTest {
  public static void main(String[] args) {
    for (String str : args) {
      System.out.println(str);
    }
  }
}

public class Addition {
  public static void main(String[] args) {
    if (args.length == 2) {
      int a = Integer.parseInt(args[0]);
      int b = Integer.parseInt(args[1]);
      System.out.println("The addition of two numbers: " + (a + b));
    } else
      System.out.println("Please enter two integer values!!!");
  }
}
```