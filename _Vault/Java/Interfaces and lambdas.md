### Interfaces

Fields declared in an interface are considered **static by default** and are 
**constant** (as if they were declared with the keywords **final** and **static**,
but the corresponding keywords are not specified in the field declaration).

interface interfaceName {}

class Klass extends SuperKlass implements interfaceName {
}

```java
package classes;  
  
import static java.lang.Thread.sleep;  
  
public interface InterfaceExample {  
    int x = 1; //static final  
    void doSomething();  
  
    default void doNothing() {} // default method  
}  
  
class TestClass implements InterfaceExample {  
    @Override  
    public void doSomething() {  
        new TestClass().doNothing();  
    }  
}
```

### Lambdas

- Lambda expression can be assigned to interface variable. 
But the interface must be functional. 
`Alpha A = (t) -> t.length();`
- A functional interface is an interface that has exactly one abstract method (a method that is declared but not declared).
- A functional interface can contain several methods, but all of them, except for one, must have a default code.

```java
interface Alpha { // functional interface example
    int get(String t);
    default defaultMethod1 {};
    default defaultMethod2 {};
    default defaultMethod3 {};
    ...
}

Alpha A = (String t)-> { // full lambda expression
    return t.length();
};
```

- If it is possible to determine the type of arguments by the assignment command, the type of arguments can be omitted in the lambda expression.
`Alpha A = (t) -> { return t.length();}`
- If there is only one argument and its type is not specified, then parentheses can be omitted. If there are no arguments, empty parentheses are used.
`Alpha A = (t) -> t.length();`
`Beta B = () -> { return null;}`
- If the body of the lambda expression consists of a single command, then curly braces can be omitted.
`Alpha A = (t) -> t.length();`
- If the method body consists of one return statement, then the return statement can be omitted (only the expression whose value is returned by the method as a result is specified).

### Method reference

**Method references are a special type of lambda expressions**. They're often used to create simple lambda expressions by referencing existing methods.

There are four kinds of method references:

-   Static methods
-   Instance methods of particular objects
-   Instance methods of an arbitrary object of a particular type
-   Constructor

```java
package classes;  
  
class Klass1 {  
    int code;  
    void doNothing() {};  
    static void staticMethod() {};  
  
    public Klass1(int code) {  
        this.code = code;  
    }  
}  
  
interface Interface1 {  
    void doNothing();  
}  
  
interface Interface2 {  
    Klass1 create(int n);  
}  
  
public class ReferenceMethodExample {  
    public static void main(String[] args) {  
        Interface1 interface1 = new Klass1(1)::doNothing; // object  
        Interface1 interface2 = Klass1::staticMethod; // class  
        Interface2 interface3 = Klass1::new; // constructor  
    }  
}
```