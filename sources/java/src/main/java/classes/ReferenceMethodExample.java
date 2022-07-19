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
