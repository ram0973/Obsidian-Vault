d### Inheritance

```java
class Alpha {  
    private char symbol;  
    void set(char s) { symbol = s; }  
}  
  
class Bravo extends Alpha {}
...
new Bravo().set('A'); // private field is not "inherited", but accessible

```
### Packages

All classes are divided into groups called packages. 

The class name must be unique within a package.

It does not matter if there is a class with the same name in another package.

To define a package, it is necessary specify the package statement and the package name, for example:

`package mypack;`

The file can have only one package statement, or none at all. 
In last case, the classes fall into the so-called **"default"** package.

### Imports

```java
import static javax.swing.JOptionPane.*; // import static methods and fields
...
showMessageDialog(null,str); // static import - no need to specify class name

import mypack.subpack.MyClass;
import mypack.subpack.*;
```
- You can only import open classes (public or package-private).
- The java.lang package (base library) does not need to be imported - it is available 
by default.
- The file name must match the name of the public class, if such a class
is in the file.
- If there are several open classes in the package, they must be placed in different
files (one file can have only one public class).
- Private outer class would be useless as nothing can access it, so we cannot define private outer class.

### Access to class methods and fields

| Place where we want access     | private | package-private | protected | public |
| ------------------------------ | ------- | --------------- | --------- | ------ |
| Same class                     | +       | +               | +         | +      |
| Subclass in same package       | -       | +               | +         | +      |
| Usual class in same package    | -       | +               | +         | +      |
| Subclass in another package    | -       | -               | +         | +      |
| Usual class in another package | -       | -               | -         | +      |

### Java class initialization order

1.  **Static** fields and static blocks **of ancestors**.  
    In each class they are initialized in **order of appearance**.
2.  **Static** fields and static block of current class.
    In each class they are initialized in **order of appearance**.
4.  **Instance** fields and initialization blocks **of ancestors**.  
    In each class they are initialized in **order of appearance**.
4.  **Constructor of ancestor** after initialization of its instance fields.
5.  **Instance** fields and initialization blocks **of the current class**.  
    Also in order of appearance.
6.  **Constructor of the current class**.

On Russian:
1. Статические блок(и) инициализации и статические переменные parent (равноценны, инициализируются по очереди т.е. сверху вниз по коду) 
2. Статические блок(и) инициализации и статические переменные child (инициализируются по очереди) 
3. Нестатические блок(и) инициализации и нестатические переменные parent (инициализируются по очереди) 
4. Конструктор parent 
5. Нестатический блок(и) инициализации и нестатические переменные child (инициализируются по очереди) 
6. Конструктор child

```java
package classes;  
  
class Alpha1 {  
    int number;  
  
    Alpha1() {  
        set();  
    }  
  
    void show() {  
        System.out.println("Alpha1");  
        System.out.println("number: " + number);  
    }  
  
    void set() {  
        number = 100;  
    }  
  
    void display() {  
        show();  
    }  
}  
  
class Bravo1 extends Alpha1 {  
    // Символьное поле:  
    char symbol;  
  
    @Override  
    void show() {  
        System.out.println("Bravo1");  
        System.out.println("number: " + number);  
        System.out.println("symbol: " + symbol);  
    }  
  
    @Override  
    void set() {  
        number = 200;  
        symbol = 'B';  
    }  
}  
  
public class VirtualMethodsExample {  
    public static void main(String[] args) {  
        Alpha1 A = new Alpha1();  
        A.display();  
        Bravo1 B = new Bravo1();  
        B.display();  
        Alpha1 C = new Bravo1();  
        C.display();  
    }  
}
```
Output:
Alpha1
number: 100
Bravo1
number: 200
symbol: B
Bravo1
number: 200
symbol: B

When a method is called via variable, the version of the method is determined by the type of the object referred, not the variable type. (Variable C)
При вызове метода версия метода определяется не типом объектной переменной,
через которую вызывается метод, а типом объекта, на который ссылается пере-
менная (переменная С). 

### Abstract classes

```java
package classes;  
  
class Klass {  
    void doNothing() {}  
}  
abstract class AbstractClass extends Klass {  
    private void doSmth() {}  
}  
  
class NonAbstractClass extends AbstractClass {}  
  
public class AbstractClassExample {  
    public static void main(String[] args) {  
        new NonAbstractClass().doNothing();  
    }  
}
```
