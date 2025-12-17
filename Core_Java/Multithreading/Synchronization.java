public class Synchronization {

    public static void main(String[] args) {

        try {

            Counter c = new Counter();

            Runnable task = () -> {
                for (int i = 0; i < 10000; i++) {
                    c.increment();
                }
            };

            Thread t1 = new Thread(task);
            Thread t2 = new Thread(task);

            t1.start();
            t2.start();

            t1.join();
            t2.join();

            System.out.println("Final count = " + c.count);

        } catch (Exception e) {
            System.out.println(e);
        }   

    }

}

class Counter {
    int count = 0;

    synchronized void increment() {
        count++;
    }
}