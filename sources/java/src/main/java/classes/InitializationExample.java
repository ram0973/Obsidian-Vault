package classes;

public class InitializationExample {
    public static void main(String[] args) {
        Child child = new Child();
    }
    static class Father {
        int nonStaticFather = 1;
        {
            System.out.println("Running Father non static block");
            nonStaticFather = 2;
            System.out.println("nonStaticFather == " + nonStaticFather);
        }

        static int staticFather = 1;
        static {
            System.out.println("Running Father static block");
            staticFather = 2;
            System.out.println("staticFather == " + staticFather);
        }
        Father() {
            staticFather = 3; nonStaticFather = 3;
            System.out.println("Running Father constructor");
            System.out.println("staticFather == " + staticFather);
            System.out.println("nonStaticFather == " + nonStaticFather);
        }
    }

    static class Child extends Father {
        int nonStaticChild = 1;
        {
            System.out.println("Running Child non static block");
            nonStaticChild = 2;
            System.out.println("nonStaticChild == " + nonStaticChild);
        }

        static int staticChild = 1;
        static {
            System.out.println("Running Child static block");
            staticChild = 2;
            System.out.println("staticChild == " + staticChild);
        }

        Child() {
            staticChild = 3; nonStaticChild = 3;
            System.out.println("Running Child constructor");
            System.out.println("staticChild == " + staticChild);
            System.out.println("nonStaticChild == " + nonStaticChild);
        }
    }
}


