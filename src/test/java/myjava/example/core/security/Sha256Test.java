package myjava.example.core.security;

import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhouxianli
 */
public class Sha256Test {
    private static MessageDigest SHA256_MESSAGE_DIGEST;

    static {
        try {
            SHA256_MESSAGE_DIGEST = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getSha256(String plain) {
        byte[] result = SHA256_MESSAGE_DIGEST.digest(plain.getBytes());
        return Hex.encodeHexString(result);
    }

    @Test
    public void testSHA256() {
        assertEquals("8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92", getSha256("123456"));
    }
}
