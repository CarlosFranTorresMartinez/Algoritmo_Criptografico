package criptografia_SHA1_AES;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

public class SecretKey {

    public SecretKeySpec setKey(String myKey) {
        SecretKeySpec secretKey;
        try {
            //Convierto mi clave ingresada a bytes
            byte[] key = myKey.getBytes("UTF-8");

            //Llamo al metodo para usar SHA-1
            MessageDigest sha = MessageDigest.getInstance("SHA-1");

            //Encripto por SHA-1 mi key en bytes y me devuelve un arreglo con 20 elementos
            key = sha.digest(key);

            //1 elemento = 1 byte
            //Redusco esos 20 elementos a 16
            key = Arrays.copyOf(key, 16);

            //AES soporta 16 bytes
            //Obtengo mi arreglo y lo encripto con AES
            secretKey = new SecretKeySpec(key, "AES");

            return secretKey;
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }
}
