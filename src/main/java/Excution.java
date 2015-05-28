import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * Created by sky on 5/17/15.
 */
public class Excution {
    private final Semaphore sem = new Semaphore(1);
    private int stage = 0;

    public class NumberPrinter implements Runnable {
        private final int value;
        private final Semaphore sem1;


        public NumberPrinter(int value, Semaphore sem) {
            this.value = value;
            this.sem1 = sem;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    synchronized(this) {
                        sem.acquire();
                        System.out.println(value);
                        sem.release();
                        Thread.sleep(1000);

                    }
                }
            } catch (InterruptedException e) {
            }
        }
    }

    public void startThreads() {
        try {
            Semaphore sem1 = new Semaphore(1, true);
            Semaphore sem2 = new Semaphore(1, true);
            Semaphore sem3 = new Semaphore(1, true);

            sem1.acquire();
            sem2.acquire();
            sem3.acquire();

            Thread t1 = new Thread(new NumberPrinter(1, sem1));
            t1.start();

            Thread t2 = new Thread(new NumberPrinter(2, sem2));
            t2.start();

            Thread t3 = new Thread(new NumberPrinter(3, sem3));
            t3.start();

            while (true) {
                sem1.release();
                sem1.acquire();
                sem2.release();
                sem2.acquire();
                sem3.release();
                sem3.acquire();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Excution().startThreads();
    }
}
