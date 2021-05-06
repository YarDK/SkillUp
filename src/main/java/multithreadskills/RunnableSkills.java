package multithreadskills;

import java.sql.SQLOutput;

public class RunnableSkills {

    public static void main(String[] args) throws Exception{
        Thread worker = new WorkerThread();
        Thread sleeper = new SleeperThread();

        System.out.println("Starting threads");
        worker.start();
        sleeper.start();

        Thread.sleep(100);

        System.out.println("Interrupting threads");
        worker.interrupt();
        sleeper.interrupt();

        System.out.println("Joining threads");
        worker.join();
        sleeper.join();

        System.out.println("All done");

    }

    private static class WorkerThread extends Thread {

        @Override
        public void run() {
            long sum = 0;
            for (int i = 0; i < 1_000_000_000; ++i){
                sum += i;
                boolean isInterrupted = isInterrupted();
                if(i % 100 == 0 && isInterrupted){
                    System.out.println("Цикл прервался при значении i = " + i);
                    break;
                }
            }
        }
    }

    private static class SleeperThread extends Thread{

        @Override
        public void run() {
            try{
                Thread.sleep(10000);
            } catch (InterruptedException e){
                System.out.println("Сон прерван!");
            }
        }
    }
}
