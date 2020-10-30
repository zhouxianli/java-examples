package myjava.example.drools;

import org.drools.core.event.DebugAgendaEventListener;
import org.drools.core.event.DebugRuleRuntimeEventListener;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.List;

public class DroolsHelloWorldTest {

    @Test
    public void testHelloWorld() {
        KieServices ks = KieServices.get();
        KieContainer kc = ks.getKieClasspathContainer();

        // From the container, a session is created based on
        // its definition and configuration in the META-INF/kmodule.xml file
        KieSession ksession = kc.newKieSession("HelloWorldKS");

        // The application can also setup listeners
        ksession.addEventListener(new DebugAgendaEventListener());
        ksession.addEventListener(new DebugRuleRuntimeEventListener());

        // Set up a file based audit logger
        KieRuntimeLogger logger = ks.getLoggers().newFileLogger(ksession, "./helloworld");

        // The application can insert facts into the session
        final Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);

        ksession.insert(message);
        // and fire the rules
        ksession.fireAllRules();
        // Close logger
        logger.close();

        // and then dispose the session
        ksession.dispose();
    }

    public static class Message {
        public static final int HELLO = 0;
        public static final int GOODBYE = 1;

        private String message;

        private int status;

        public Message() {

        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(final String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(final int status) {
            this.status = status;
        }

        public static Message doSomething(Message message) {
            return message;
        }

        public boolean isSomething(String msg,
                                   List<Object> list) {
            list.add(this);
            return this.message.equals(msg);
        }
    }
}
