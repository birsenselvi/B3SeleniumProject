package gun19;

public class ThreadSample {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                }
            }
        };

        Thread t1 = new Thread(r);
        t1.setName("Ali");

        Thread t2 = new Thread(r);
        t2.setName("Veli");

        t1.start();
        t2.start();
    }
}
