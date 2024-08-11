package com.avi.coreJava;

//RSA (Rivest–Shamir–Adleman)
//RSA is an asymmetric encryption algorithm used for secure data transmission.
//It uses a pair of keys: a public key for encryption and a private key for decryption.

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class RsaEncrypt {

    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        return keyGen.generateKeyPair();
    }

    public static String encrypt(String plainText, PublicKey publicKey) throws Exception {
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] encryptedBytes = encryptCipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedText, PrivateKey privateKey) throws Exception {
        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] decryptedBytes = decryptCipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes);
    }

//    public static void main(String[] args) throws Exception {
//        KeyPair keyPair = generateKeyPair();
//        String plainText = "Test@1234";
//        String encryptedText = encrypt(plainText, keyPair.getPublic());
//        String decryptedText = decrypt(encryptedText, keyPair.getPrivate());
//
//        System.out.println("Original Text: " + plainText);
//        System.out.println("Encrypted Text: " + encryptedText);
//        System.out.println("Decrypted Text: " + decryptedText);
//    }

    public static String getPublicKeyAsString(PublicKey publicKey) {
        return Base64.getEncoder().encodeToString(publicKey.getEncoded());
    }

    public static String getPrivateKeyAsString(PrivateKey privateKey) {
        return Base64.getEncoder().encodeToString(privateKey.getEncoded());
    }

    public static void main(String[] args) throws Exception {
        // Generate the key pair
        KeyPair keyPair = generateKeyPair();

        // Convert keys to Base64 encoded strings
        String publicKeyString = getPublicKeyAsString(keyPair.getPublic());
        String privateKeyString = getPrivateKeyAsString(keyPair.getPrivate());

        // Print the keys
        System.out.println("Public Key: " + publicKeyString);
        System.out.println("Private Key: " + privateKeyString);

        // Original text
        String plainText = "Test@1234";

        // Encrypt the text using the public key
        String encryptedText = encrypt(plainText, keyPair.getPublic());

        // Decrypt the text using the private key
        String decryptedText = decrypt(encryptedText, keyPair.getPrivate());

        // Print the results
        System.out.println("Original Text: " + plainText);
        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
