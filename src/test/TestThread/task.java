package test.TestThread;

public class task implements Runnable{
    @Override
    public void run() {
        synchronized (this){
        while(true) {
//            System.out.println(Thread.currentThread().isInterrupted());

            if(Thread.currentThread().isInterrupted())
            try {
                System.out.println("wait");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("wait break");
                System.out.println(Thread.currentThread().isInterrupted());

               // break;
            } finally {
                System.out.println("finally wait");

            }

        }}
    }
}
