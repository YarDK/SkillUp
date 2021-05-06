package multithreadskills;

public class MainSkills {

    public static void main(String[] args) {
        //System.out.println("Прямое наследование от thread.");
        //directExtendsThread();

        //System.out.println("Прямое наследование от интерфейса Runnable.");
        //implementsRunnable();

        System.out.println("Запуск Thread через лямбда выражение");
        lambdaRunImplRunnable();

    }

    private static class HelloThread extends Thread {

        @Override
        public void run() {
            System.out.println("Hello from " + getName());
        }
    }

    public static void directExtendsThread() {
        for (int i = 0; i < 10; ++i) {
            Thread thread = new HelloThread();
            thread.start();
        }
        System.out.println("Hello from main thread");
    }


    private static class HelloRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("Hello from " + Thread.currentThread().getName());
        }
    }

    public static void implementsRunnable() {
        for (int i = 0; i < 10; ++i) {
            HelloRunnable helloRunnable = new HelloRunnable();
            Thread thread = new Thread(helloRunnable);
            thread.start();
        }
        System.out.println("Hello from main thread");
    }


    public static void lambdaRunImplRunnable() {
        for (int i = 0; i < 10; ++i) {
            Thread thread = new Thread(() ->
                    System.out.println("Hello from " + Thread.currentThread().getName()));
            thread.start();
        }
        System.out.println("Hello from main thread");
    }


}
