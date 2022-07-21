package threads;

class MyThread extends Thread {
    MyThread(String name) {
        super(name);
        start();
    }

    public void run() {
        SynchronizedExample.show();
    }
}

// Главный класс:
class SynchronizedExample {
    public synchronized static void show() {
        Thread t = Thread.currentThread();
        for (int k = 1; k <= 3; k++) {
            System.out.println(t.getName() + " [" + k + "]");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
        }
    }

    public static void main(String[] args) {
        new MyThread("Alpha");
        new MyThread("Bravo");
    }
}
