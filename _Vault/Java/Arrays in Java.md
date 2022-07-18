### Number array 
```java
type[] name=new type[size];

int[] data={3,8,1,7};

int[] data;
data=new int[]{3,8,1,7};

int n=data.length;

// ---------------------
// Multidimensional arrays

type[][] name=new type[size][size];

type[][] name;
name=new type[size][size];

double[][] data={{0.1,0.2,0.3},{0.4,0.5,0.6}};
int nums[][]={{1,2,3},{4,5}};
// nums.lenght == 2

int[][] nums=new int[4][];
```

### Symbol and String array

```java
import java.util.Arrays;

class Demo {
    public static void main(String[] args) {
        char[] symbs={'J','a','v','a'};
        
        String str=Arrays.toString(symbs);
        
        String txt=new String(symbs);
        
        char[] word="Pascal".toCharArray();

        System.out.println(Arrays.toString(word));

        String[] strings = {"First", "Second", "Third"};
    }
}    
```

