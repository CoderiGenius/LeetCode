package thread;

public class Runner implements Runnable{

    Object object;

    public Runner(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        int i = 0;
        synchronized (object){
            while (true){
                if(i%10==0 ){
                    System.out.println("notify");
                    //object.notifyAll();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    System.out.println(i);
                }
                i++;
            }
        }
    }
}
