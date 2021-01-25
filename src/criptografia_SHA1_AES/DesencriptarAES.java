package criptografia_SHA1_AES;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class DesencriptarAES {

    SecretKey secretKey = new SecretKey();

    public String decrypt(String stringToDecrypt, String secret) {
        try {

            //LLamo a mi cipher para encriptar por AES
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");

            //Inicio la desencriptacion con mi llave secreta
            cipher.init(Cipher.DECRYPT_MODE, secretKey.setKey(secret));

            //Retorno la desencriptacion
            return new String(cipher.doFinal(Base64.getDecoder().decode(stringToDecrypt)));
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            System.out.println("Error arised while decrypting: " + e.toString());
        }
        return null;
    }
}
