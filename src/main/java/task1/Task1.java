package task1;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            long startedTime = System.currentTimeMillis();
            long curTime = 0;

            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                curTime = System.currentTimeMillis();
                System.out.println((curTime - startedTime) / 1000);
            }
        }).start();

        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Elapsed 5 secs");
            }
        }).start();

    }
}