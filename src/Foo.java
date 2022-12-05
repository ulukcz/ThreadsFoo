import java.util.concurrent.atomic.AtomicInteger;

public class Foo {
    final AtomicInteger count = new AtomicInteger(1);

    public void first(Runnable r) throws InterruptedException {
        while (true) {
            if (count.get() == 1) {
                System.out.print("first");
                count.getAndIncrement();
                break;
            }
        }
    }
    public void second(Runnable r) throws InterruptedException {
        while (true) {
            if (count.get() == 2) {
                System.out.print("second");
                count.getAndIncrement();
                break;
            }
        }
    }
    public void third(Runnable r) throws InterruptedException {
        while (true) {
            if (count.get() == 3) {
                System.out.print("third");
                break;
            }
        }
    }
}