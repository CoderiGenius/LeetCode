package thread;

public class test {

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();

        Thread thread = new Thread(new Runner(o));
        thread.start();
        int i = 0;
        Thread.sleep(100);
        synchronized (o){
            while (true) {
                if(i>100){
                    //Thread.currentThread().join();

                    //o.notifyAll();
                    o.wait(10);
                }
                System.out.println("main:" + i);
                i++;
            }
        }

    }
}
