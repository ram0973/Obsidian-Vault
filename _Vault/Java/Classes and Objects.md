### Class definition

```java
class MyClass{
    String name;
    int number;
    char type;
   
    void set(String txt,int num, char type){
        name=txt;
        number=num;
        this.type = type;
    }
    
    void show(){
        System.out.println(name+": "+number);
    }
}
```

### Static methods

Static methods don't have access to non-static methods and fields

### Inner classes

An inner class is a class that is declared inside another class. The class in which an inner class is declared, called an outer class.

The inner class has several features:

- First, the members of the inner class are available only within the inner class and are not available in the outer class (even if they are public). 
- Secondly, in the inner class, you can access members of the outer class directly.

```java
package classes;  
  
class Alpha {  
    int outer_number = 123;  
    void show() {  
        Bravo bravo = new Bravo();  
        bravo.display();  
        bravo.innerNumber = 777; // access with inner object granted  
        // innerNumber = 888; // direct access to inner field denied    }  
        // display(); // direct access to inner method denied
  
    class Bravo {  
        int innerNumber = 666;  
        void display() {  
            System.out.println("Поле number: " + outer_number); // access to outer field granted  
        }  
    }  
}
```

### Anonymous object

```java
new MyClass().show("I am anonymous object");
```

### Constructor

-  The name of the constructor is the same as the name of the class
-  The constructor does not return a result, and the type identifier for the constructor
not specified;
- Like a regular method, a constructor can have arguments and can be overloaded.
- ==Important!== If at least one constructor in the class is declared, then
default constructor is no longer available.

When creating a subclass object, it is first called superclass constructor, and then commands are directly executed, associated with creating a subclass object. Superclass constructor allocates a place in memory for all members of an object, including "non-inherited" ones (private):

```java
this(...) - constructor execution
```

### Argument passing mechanism (by value)

In Java, when passing arguments to methods, variables that are actually used, are **copies of arguments**.

This is called passing arguments by value. Copies are created
automatically. After the method completes, the unnamed copies
arguments are automatically removed.


