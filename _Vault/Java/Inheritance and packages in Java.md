### Inheritance

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

All classes are divided into groups that and are called packages. 

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
