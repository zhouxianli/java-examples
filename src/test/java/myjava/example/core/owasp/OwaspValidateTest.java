package myjava.example.core.owasp;

import org.junit.jupiter.api.Test;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.codecs.MySQLCodec;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.servlet.http.HttpServletRequest;
public class OwaspValidateTest {
    @Test

    public void testValidate() {
        String input = "xxxx.com";

        if (!ESAPI.validator().isValidInput("", input, "Email", 11, false)) {
            System.out.println("出错了");
        }

        try {
            input = ESAPI.validator().getValidInput("", input, "Email", 11, false);
        } catch (Exception e) {
            System.out.println("输入错误");
            e.printStackTrace();
        }
    }
}
