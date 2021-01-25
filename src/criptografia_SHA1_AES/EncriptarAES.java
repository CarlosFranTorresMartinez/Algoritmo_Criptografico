package criptografia_SHA1_AES;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class EncriptarAES {

    SecretKey secretKey = new SecretKey();

    public String encrypt(String stringToEncrypt, String secret) {
        try {

            //LLamo a mi cipher para encriptar por AES
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            //Inicio la encriptacion con mi llave secreta
            cipher.init(Cipher.ENCRYPT_MODE, secretKey.setKey(secret));

            //Retorno la encriptacion con Base64
            return Base64.getEncoder().encodeToString(cipher.doFinal(stringToEncrypt.getBytes("UTF-8")));

        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            System.out.println("Error arised while encrypting: " + e.toString());
        }
        return null;
    }
}
