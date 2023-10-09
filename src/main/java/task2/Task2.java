package task2;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class Task2 implements Runnable {
    int n;
    private AtomicBoolean isNumToProcess;
    private Consumer<Integer> processor;
    public Task2(Consumer<Integer> processor) {
        n = 0;
        isNumToProcess = new AtomicBoolean(false);
        this.processor = processor;
    }

    public void process(int n) {
        this.n = n;
        isNumToProcess.set(true);
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {

            if (!isNumToProcess.get())
                continue;
            processor.accept(n);
            isNumToProcess.set(false);
        }
    }
}
