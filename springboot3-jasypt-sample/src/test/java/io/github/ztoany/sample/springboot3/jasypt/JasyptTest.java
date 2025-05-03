package io.github.ztoany.sample.springboot3.jasypt;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

public class JasyptTest {
    public static void main(String[] args) {
        String password = "12345";
        String plainText = "admin";
        var encryptedText = encrypt(password, plainText);
        System.out.println(encryptedText);
        var decryptedText = decrypt(password, encryptedText);
        System.out.println(decryptedText);
    }

    private static String encrypt(String encryptorPwd, String text) {
        var encryptor = buildEncryptor(encryptorPwd);
        return encryptor.encrypt(text);
    }

    private static String decrypt(String encryptorPwd, String text) {
        var encryptor = buildEncryptor(encryptorPwd);
        return encryptor.decrypt(text);
    }

    private static PooledPBEStringEncryptor buildEncryptor(String encryptorPwd) {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(encryptorPwd);
        config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }
}
