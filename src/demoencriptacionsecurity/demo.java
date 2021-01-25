package demoencriptacionsecurity;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.BadPaddingException;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class demo {

    private static SecretKeySpec secretKey;
    private static byte[] key;
    private static final String key1 = "123";

    public static void setKey(String myKey) {
        try {

            key = myKey.getBytes("UTF-8");
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            System.out.println("Error: " + e);
        }
    }

    public static String encrypt(String stringToEncrypt, String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(stringToEncrypt.getBytes("UTF-8")));

        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            System.out.println("Error arised while encrypting: " + e.toString());
        }
        return null;
    }

    public static String decrypt(String stringToDecrypt, String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(stringToDecrypt)));
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            System.out.println("Error arised while decrypting: " + e.toString());
        }
        return null;
    }

    public static String Encriptar(String password){
        try {
            byte[] keyData = (key1).getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] hasil = cipher.doFinal(password.getBytes());
            return new String(Base64.getEncoder().encode(hasil));

        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static String Desencriptar(String string){
        try {
            byte[] keyData = (key1).getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] hasil = cipher.doFinal(Base64.getDecoder().decode(string));
            return new String(hasil);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String secretKey = "MiClaveSecreta";

        String originalString = "Encriptar en texto plano";
        String encryptedString = encrypt(originalString, secretKey);
        String decryptedString = decrypt(encryptedString, secretKey);

        System.out.println("Password ->" + originalString);
        System.out.println("Encriptacion ->" + encryptedString);
        System.out.println("Descencriptacion ->" + decryptedString);

        Scanner entrada = new Scanner(System.in);
        String password;
        String string;

        //Input para encriptar
        System.out.println("El texto a encriptar es:");
        password = entrada.nextLine();
        System.out.println("El texto encriptado es" + Encriptar(password));

        //Input para Desencriptar
        System.out.println("El texto a desencriptar es:");
        string = entrada.nextLine();
        System.out.println("El texto desencriptado es:" + Desencriptar(Encriptar(password)));

    }

}
