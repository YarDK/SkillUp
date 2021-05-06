package multithreadskills.atomar.demo1;

import java.util.ArrayList;
import java.util.List;

public class SequenceGenerator2 {

    private static int counter = 0;

    public static synchronized int nextInt() {
        return counter++;
    }


    public static void main(String[] args) throws Exception {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 100000; ++i) {
            Thread thread = new Thread(() -> nextInt());
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Counter final value: " + counter);
    }
}
