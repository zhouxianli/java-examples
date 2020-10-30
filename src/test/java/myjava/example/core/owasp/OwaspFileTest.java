package myjava.example.core.owasp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.owasp.esapi.ESAPI;

import java.util.ArrayList;

public class OwaspFileTest {
    @Test
    public void testValidateFile() {
        //校验文件名
        String inputfilename = "xxxx.txt";
        ArrayList<String> allowedExtension = new ArrayList<String>();
        allowedExtension.add("exe");
        allowedExtension.add("jpg");

        Assertions.assertFalse(ESAPI.validator().isValidFileName("upload", inputfilename, allowedExtension, false));

        //获取随机文件名
        System.out.println(ESAPI.randomizer().getRandomFilename("exe"));
    }
}
