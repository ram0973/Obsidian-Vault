package generics;

class GenericsExample {
    static <T> void show(T[] a) {
        for (T t : a) {
            System.out.print("|" + t);
        }
        System.out.println("|");
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 3, 5, 7, 9, 11, 13};
        Character[] symbs = {'A', 'B', 'C', 'D'};
        String[] txt = {"Alpha", "Bravo", "Charlie"};
        show(nums);
        show(symbs);
        show(txt);
    }
}