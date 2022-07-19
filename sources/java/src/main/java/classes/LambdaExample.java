package classes;

interface Alpha2 {
    int get(String t);
}

public class LambdaExample {
    public static void main(String[] args) {
        Alpha2 A = (t) -> t.length();
    }
}
