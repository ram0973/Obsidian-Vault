package basic;

public class Basic {
    byte x=1, y=2, z;
    char a = 'A';
    {
        // z = x + y; //wrong
        z = (byte) (x + y);
        a += 1;
        a = (char) (a + 1);
    }
}
