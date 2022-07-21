package threads;

public class ThreadExample {
    static class MyThread extends Thread {
        public void run() {
            Thread t;
            t=Thread.currentThread();
            System.out.println("Главный поток: "+t);
            t.setName("Demo");
            System.out.println("Поток поменял имя: "+t);
            t.setPriority(7);
            System.out.println("Поток поменял приоритет: "+t);
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello from thread!");
            System.out.println(Thread.currentThread());
        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        MyThread thread = new MyThread();
        thread.setDaemon(true);
        thread.start();
    }
}
