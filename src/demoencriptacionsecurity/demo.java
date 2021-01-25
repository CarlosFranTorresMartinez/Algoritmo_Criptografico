package demoencriptacionsecurity;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import criptografia_SHA1_AES.DesencriptarAES;
import criptografia_SHA1_AES.EncriptarAES;

public class demo {

    private static final String key1 = "123";

    public static String Encriptar(String password) {
        try {
            byte[] keyData = (key1).getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] hasil = cipher.doFinal(password.getBytes());
            return new String(Base64.getEncoder().encode(hasil));

        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            return null;
        }
    }

    public static String Desencriptar(String string) {
        try {
            byte[] keyData = (key1).getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] hasil = cipher.doFinal(Base64.getDecoder().decode(string));
            return new String(hasil);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {

            return null;
        }
    }

    public static void main(String[] args) {
        String secretKey = "MiClaveSecreta";

        EncriptarAES encriptarAES = new EncriptarAES();
        DesencriptarAES desencriptarAES = new DesencriptarAES();

        String originalString = "MiContrasenia";
        String encryptedString = encriptarAES.encrypt(originalString, secretKey);
        String decryptedString = desencriptarAES.decrypt(encryptedString, secretKey);

        System.out.println("Contraseña ->" + originalString);
        System.out.println("Encriptacion ->" + encryptedString);
        System.out.println("Descencriptacion ->" + decryptedString);

        //Scanner entrada = new Scanner(System.in);
        //String password;
        //String string;
        //Input para encriptar
        //System.out.println("El texto a encriptar es:");
        //password = entrada.nextLine();
        //System.out.println("El texto encriptado es" + Encriptar(password));
        //Input para Desencriptar
        //System.out.println("El texto a desencriptar es:");
        //string = entrada.nextLine();
        //System.out.println("El texto desencriptado es:" + Desencriptar(Encriptar(password)))
    }
}
