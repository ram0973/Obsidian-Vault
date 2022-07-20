package exceptions;

public class ExceptionExample {
    public static void main(String[] args) {
        try {
            try {
                System.out.println("1st try");
                int x = 3 / 0;
            } catch (ArithmeticException ex) {
                System.out.println("1st catch");
                throw new ArrayIndexOutOfBoundsException();
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("2nd catch");
            } finally {
                System.out.println("1st finally");
                String[] strings = {"123"};
                strings[1] = "456";
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("3rd catch");
        } finally {
            System.out.println("2nd finally");
        }
    }

}
