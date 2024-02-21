package com.avi.coreJava;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AesCbcEncryption {

    private static final String KEY = "951e641001e348e386a03727223e5cb7"; // 128-bit key
    private static final String IV = "RTTT3VxblbV5hI40"; // 16-byte IV

    public static String encrypt(String plaintext) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        SecretKeySpec secretKeySpec = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes(StandardCharsets.UTF_8));

        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String ciphertext) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        SecretKeySpec secretKeySpec = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes(StandardCharsets.UTF_8));

        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
        return new String(decryptedBytes, StandardCharsets.UTF_8).trim();
    }

    public static void main(String[] args) throws Exception {
        String username = "4368";
        String password = "Campa@2004";

        // Create a JSON object with the given username and password
//        String jsonData = "{\"username\": \"" + username + "\",\n" +
//                "\"password\": \"" + password + "\"\n" +
//                "}";
        String jsonData = """
                {username: " + username ,
                "password: " + password }
                """;
        System.out.println("Original Text: " + jsonData);

        String encryptedText = encrypt(jsonData);
        System.out.println("Encrypted Text: " + encryptedText);

        encryptedText = "YWsRMHEOd9TJJ+meJY4JuN9SbEO4vOpnqWL41vytxfeSIGctE1p6BGv9U1prOLqeD+L42B7Q7NZpVJdwcSLzdcIdqtCrWsaNqRvErs6A5cUjFclH7eLZzboKmguJPSRgwPE64s3LhzABjmLsHz/Roi7fy4Nf14jOq6nSW+NOcYU=";

        String decryptedText = decrypt(encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}

