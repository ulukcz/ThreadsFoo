import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class FooDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Foo foo = new Foo();

        CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                foo.first(new Thread());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).get();
        CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                foo.second(new Thread());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).get();
        CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                foo.third(new Thread());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).get();
    }
}