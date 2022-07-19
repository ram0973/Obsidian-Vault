package exceptions;

public class ExceptionExample {
    public static void main(String[] args) {
        try {
            int x = 3/0;
        } catch (Throwable ex) {
            for (StackTraceElement x : ex.getStackTrace()) {
                System.out.println(x.toString());
            }
        }
    }

}
