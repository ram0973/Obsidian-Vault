package classes;

class Alpha {
    private char symbol;
    static int x = 1;
    void show() {
        System.out.println("Символ: " + symbol);
        System.out.println("x: " + x);
        System.out.println("A x: " + Alpha.x);
        System.out.println("B x: " + Bravo.x);
    }
    void set(char s) {
        symbol = s;
    }
}

class Bravo extends Alpha {
    static int x = 2;
}

public class PrivateFields {
    public static void main(String[] args) {
        Bravo B = new Bravo();
        B.set('B');
        B.show();
    }
}
