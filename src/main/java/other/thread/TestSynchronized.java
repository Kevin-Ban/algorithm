package other.thread;

import org.junit.jupiter.api.Test;

public class TestSynchronized {

    @Test
    public void test() {
        synchronized (this) {
            System.out.println("123");
        }
    }
}
