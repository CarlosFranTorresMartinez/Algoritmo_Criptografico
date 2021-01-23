package com.vallegrande;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class BlowFish {

    public static void main(String[] args) {

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

    private static final String key = "123";

    public static String Encriptar(String password){
        try {
            byte[] keyData = (key).getBytes();
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
            byte[] keyData = (key).getBytes();
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
}
