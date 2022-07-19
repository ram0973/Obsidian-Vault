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
