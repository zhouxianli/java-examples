package myjava.example.core.owasp;

import org.junit.jupiter.api.Test;
import org.owasp.esapi.ESAPI;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OwaspEncodeTest {
    @Test
    public void testEncodeHTML(){
        assertEquals("&lt;a href&#x3d;&#x27;sdfs&#x27;&gt;&lt;&#x2f;a&gt; &lt;script&gt; alert&#x28;&#x29;&#x3b; &lt;&#x2f;script&gt;",ESAPI.encoder().encodeForHTML("<a href='sdfs'></a> <script> alert(); </script>"));

    }
}
