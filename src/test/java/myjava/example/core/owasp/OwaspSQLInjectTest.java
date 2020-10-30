package myjava.example.core.owasp;

import org.junit.jupiter.api.Test;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.codecs.MySQLCodec;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OwaspSQLInjectTest {
    @Test

    public void testSQLInjection() {
        String input1 = "2 ";
        String input2 = "超级管理员 ' or '1' != '";

        //被注入了
        assertEquals("select * from sys_user where id=2 and user_name ='超级管理员 ' or '1' != ''", toSQL(input1, input2));
//        //解决注入问题
//        input1 = "1 ";
//        input2 = "超级管理员";

        input1 = ESAPI.encoder().encodeForSQL(new MySQLCodec(MySQLCodec.Mode.STANDARD), input1);
        input2 = ESAPI.encoder().encodeForSQL(new MySQLCodec(MySQLCodec.Mode.STANDARD), input2);

        assertEquals("select * from sys_user where id=2 and user_name ='\\超\\级\\管\\理\\员 \\' or \\'1\\' \\!\\= \\''", toSQL(input1, input2));
    }

    private String toSQL(String param1, String param2) {
        return "select * from sys_user where id=" + param1 + "and user_name ='" + param2 + "'";
    }
}
