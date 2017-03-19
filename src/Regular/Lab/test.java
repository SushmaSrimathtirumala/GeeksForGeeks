package Regular.Lab;

/**
 * Created by Gopala Akshintala on 3/14/17.
 */
public class test {
    public static void main(String[] args) {
        Thread t = new MyThread() {
            @Override
            public void run() {
                System.out.println(" foo");
            }
        };
        t.start();
    }
}

class MyThread extends Thread {
    MyThread() {
        System.out.println(" MyThread");
    }

    @Override
    public void run() {
        System.out.println(" bar");
    }

    public void run(String a) {
        super.run();
    }
}
