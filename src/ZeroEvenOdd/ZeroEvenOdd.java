package ZeroEvenOdd;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private Integer x=1;
    private boolean exit = false;
    Semaphore semaphore = new Semaphore(1);
    Semaphore semaphoreEven = new Semaphore(0);
    Semaphore semaphoreOdd = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        semaphore.acquire();
        printNumber.accept(0);
        if(x%2==0)
        semaphoreEven.release();
        else semaphoreOdd.release();
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
        semaphoreEven.acquire();
        printNumber.accept(i);
        x++;
        if(x>n){
            exit = true;
        }
        semaphore.release();
    }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <=n; i += 2) {
            semaphoreOdd.acquire();
            printNumber.accept(i);
            x++;
            if (x > n) {
                exit = true;
            }
            semaphore.release();
        }
    }
}
