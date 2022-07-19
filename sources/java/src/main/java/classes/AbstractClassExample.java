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
