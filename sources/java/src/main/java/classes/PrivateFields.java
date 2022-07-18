package classes;

class Alpha {
    private char symbol;
    void show() {
        System.out.println("Символ: " + symbol);
    }
    void set(char s) {
        symbol = s;
    }
}

class Bravo extends Alpha {
}

public class PrivateFields {
    public static void main(String[] args) {
        Bravo B = new Bravo();
        B.set('B');
        B.show();
    }
}
