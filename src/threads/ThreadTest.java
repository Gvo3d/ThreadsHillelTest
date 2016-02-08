package threads;

/**
 * Created by User on 08.02.2016.
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread thr = new MyThread();
        Runnable thr2 = new MyThread2();
        Thread thr3 = new Thread(thr2);

        thr3.setPriority(8);
        thr.start();
        thr3.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("int main");
        }
        System.out.println(Thread.currentThread().getId());
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getId() + " In MyThread " + i);
        }
    }
}

class MyThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getId() + " In MyThread2 " + i);
        }
    }
}