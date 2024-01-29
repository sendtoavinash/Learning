package com.avi;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

public class EncryptionUtil {

    private static final String PASSPHRASE = "951e641001e348e386a03727223e5cb7";

    public static String encryptData(String plainText) throws Exception {
        // Generate a random 16-character IV (Initialization Vector)
        SecureRandom random = new SecureRandom();
        byte[] ivBytes = new byte[16];
        random.nextBytes(ivBytes);
        IvParameterSpec iv = new IvParameterSpec(ivBytes);

        // Generate a random salt
        byte[] salt = new byte[8];
        random.nextBytes(salt);

        // Derive the key from the passphrase and salt using PBKDF2
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec keySpec = new PBEKeySpec(PASSPHRASE.toCharArray(), salt, 65536, 256);
        SecretKey secretKey = keyFactory.generateSecret(keySpec);
        SecretKey secret = new SecretKeySpec(secretKey.getEncoded(), "AES");

        // Create Cipher instance
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secret, iv);

        // Encrypt the data
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes("UTF-8"));

        // Combine IV, salt, and encrypted data
        byte[] combined = new byte[ivBytes.length + salt.length + encryptedBytes.length];
        System.arraycopy(ivBytes, 0, combined, 0, ivBytes.length);
        System.arraycopy(salt, 0, combined, ivBytes.length, salt.length);
        System.arraycopy(encryptedBytes, 0, combined, ivBytes.length + salt.length, encryptedBytes.length);

        // Encode the result in Base64
        return Base64.getEncoder().encodeToString(combined);
    }

    public static String decryptData(String encryptedData) throws Exception {
        // Decode Base64
        byte[] combined = Base64.getDecoder().decode(encryptedData);

        // Extract IV, salt, and encrypted data
        byte[] ivBytes = new byte[16];
        System.arraycopy(combined, 0, ivBytes, 0, ivBytes.length);

        byte[] salt = new byte[8];
        System.arraycopy(combined, ivBytes.length, salt, 0, salt.length);

        byte[] encryptedBytes = new byte[combined.length - ivBytes.length - salt.length];
        System.arraycopy(combined, ivBytes.length + salt.length, encryptedBytes, 0, encryptedBytes.length);

        // Derive the key from the passphrase and salt using PBKDF2
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec keySpec = new PBEKeySpec(PASSPHRASE.toCharArray(), salt, 65536, 256);
        SecretKey secretKey = keyFactory.generateSecret(keySpec);
        SecretKey secret = new SecretKeySpec(secretKey.getEncoded(), "AES");

        // Create Cipher instance
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(ivBytes));

        // Decrypt the data
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        // Convert decrypted bytes to String
        return new String(decryptedBytes, "UTF-8");
    }


    public static void main(String[] args) {
        try {
            String username = "717";
            String password = "Campa@2004";

            // Create a JSON object with the given username and password
            String jsonData = "{username: \"" + username + "\",\n" +
                    "\"password\": \"" + password + "\"\n" +
                    "}";

            // Encrypt the JSON data
            String encryptedData = encryptData(jsonData);
            System.out.println("Encrypted Data: " + encryptedData);

            // Decrypt the data
            String decryptedData = decryptData("1bb2fe2cd6705bfe79d692a4a8826081 65f16b6589e76f757655057c48ee8949 TXMl4ZcresfJoVz79i4BxFhzPqMpbcCchTx49Q4dldtcdex77BHAxYUsxfNJDfw6qqgDhEfctb2iyxk5Y15343NDjO0ZdDRUxkskHVxdyn0=");
            System.out.println("Decrypted Data: " + decryptedData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

