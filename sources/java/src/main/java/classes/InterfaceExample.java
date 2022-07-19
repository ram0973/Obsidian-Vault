package classes;

import static java.lang.Thread.sleep;

public interface InterfaceExample {
    int x = 1; //static final
    void doSomething();

    default void doNothing() {} // default method
}

class TestClass implements InterfaceExample {
    @Override
    public void doSomething() {
        new TestClass().doNothing();
        InterfaceExample example = new InterfaceExample() { // anonymous class based on interface
            @Override
            public void doSomething() {
                System.out.println("Hello, world!");
            }
        };
    }
}
