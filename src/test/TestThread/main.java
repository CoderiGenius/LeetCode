package test.TestThread;

public class main {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new task();
        Thread t = new Thread(runnable);
        t.start();
        Thread.sleep(2000);
        t.interrupt();
        t.join();
    }
}
