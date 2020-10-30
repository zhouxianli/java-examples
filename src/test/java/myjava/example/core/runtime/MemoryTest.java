package myjava.example.core.runtime;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author zhouxianli
 */
public class MemoryTest {
    @Test
    public void testMemory() {
        for (int i = 0; i < 10; i++) {
            long maxMemory = Runtime.getRuntime().maxMemory() / 1024;
            long totalMemory = Runtime.getRuntime().totalMemory() / 1024;
            long usedMemory = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
            String[] array = new String[1024];
            Arrays.fill(array, "ABC");
            System.out.println(String.format("Memory: Max（<mx) %dK ，Total（>ms）%dK，Used %dK", maxMemory, totalMemory, usedMemory)
                    .toString());
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            assertTrue(totalMemory > usedMemory);
        }
    }
}
