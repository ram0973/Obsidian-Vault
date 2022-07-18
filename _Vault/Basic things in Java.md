# Basic things in Java
### First program

```java
package com.me.example;

class MainClass {
	public static void main(String[] args){
		System.out.println("Hello, world!")
	}
}
```

### Comments

`//` - one line
`/* */` - multiple lines
`/** */` - JavaDoc

### Imports

```java
import static javax.swing.JOptionPane.*; // import static methods and fields
...
showMessageDialog(null,str); // static import - no need to specify class name
```

### Primitive types

| Type    | Bits                          | Description                                                                                                                                                        | Wrapper class |     |
| ------- | ----------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------- | 
| byte    | 8                             | Integers in range from –128 to 127                                                                                                                             | Byte          |     |
| short   | 16                            | Integers in range from –32 768 to 32 767                                                                                                                       | Short         |     |
| int     | 32                            | Integers in range from –2147483648 to 2147483647                                                                                                               | Integer       |     |
| long    | 64                            | Integers in range from –9223372036854775808 to 9223372036854775807                                                                                             | Long          |     |
| float   | 32                            | Real (Действительные) numbers. Minimum step of discreteness (accuracy) is value 3.4 × 10–38, the maximum value value (modulo) - 3.4 × 1038                      | Float         |     |
| double  | 64                            | Real numbers (double precision). The minimum discrete step (accuracy) is 1.7 × 10–308, the maximum value (modulo) is 1.7 × 10308 | Double        |     |
| char    | 16                            | Symbols with codes from 0 to 65 536                                                                             | Character     |     |
| boolean | Depends to JVM | Logical - true false                                                            | Boolean       |     |

### Type casting

The types of the variables included in the expression must be compatible. For example,  an integer can be converted to a real number format, which cannot be said about the text string.
- The target type (the type being cast to) must be wider than original type. In other words, the transformation must be done without data loss.
- ==Important!== Before performing arithmetic operations, the types byte, short and char are
expand to type **int**.
- If the expression contains operands of type long, then the expansion is carried out to
**long** type.
- If the expression contains operands of type float, then the expansion is carried out to
**float** type.
- If the expression contains operands of type double, then the expansion is performed
to type **double**.

```java
byte x=1, y=2, z;
// All numbers on calculations converts to integers
z=x+y; // java: incompatible types: possible lossy conversion from int to byte
z=(byte)(x+y); // correct
```

### Operators priority

| Priority | Operators                |
| --------- | ---------------------------------------- |
| 1         | ( ), [], dot operator «.»              |
| 2         | Unary ++, --, ~, ! |    
| 3         | \*, \/, \%                              |
| 4         | +,  -                                                  |
| 5         | >>, << , >>>                                             | 
| 6         | >, >=, <=, <             |  
| 7         | \==, !=                                                    | 
| 8         | &                                                             |     
| 9         | ^                                               |     
| 10        | \|\|                                                          |     
| 11        | &&                                                           |     
| 12        | \|                                                          |     
| 13        | ?:                                                     |  
| 14        | =, +=, -=, *=, /=, %=                             |     

