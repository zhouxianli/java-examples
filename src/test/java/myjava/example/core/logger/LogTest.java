package myjava.example.core.logger;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
public class LogTest {
    @Test
    public void testLogMethod() {
        Integer value = new Random().nextInt();
        assertNotNull(value);
        log.trace("Trace with {}", value);
        log.debug("Debug with {}", value);
        log.info("Info with {}", value);
        log.warn("Warn with {}", value);
        log.error("Error with {}", value);

    }

}
