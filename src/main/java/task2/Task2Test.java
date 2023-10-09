package task2;

public class Task2Test {
    public static void main(String[] args) {
        Task2 fizz = new Task2((i) -> {
            if (i % 3 == 0 && i % 5 != 0)
                System.out.println("fizz");
        });

        Task2 buzz = new Task2((i) -> {
            if (i % 5 == 0 && i % 3 != 0)
                System.out.println("buzz");
        });

        Task2 fizzbuzz = new Task2((i) -> {
            if (i % 3 == 0 && i % 5 == 0)
                System.out.println("fizzbuzz");
        });

        Task2 number = new Task2((i) -> {
            if (i % 3 != 0 && i % 5 != 0)
                System.out.println(i);
        });

        Thread thread1 = new Thread(fizz);
        Thread thread2 = new Thread(buzz);
        Thread thread3 = new Thread(fizzbuzz);
        Thread thread4 = new Thread(number);
        thread1.setName("fizz");
        thread2.setName("buzz");
        thread3.setName("fizzbuzz");
        thread4.setName("number");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        for (int i = 1; i <= 15; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            fizz.process(i);
            buzz.process(i);
            fizzbuzz.process(i);
            number.process(i);
        }


        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();
        thread4.interrupt();
        System.out.println(Thread.currentThread().getName() + " stopped");
    }
}
