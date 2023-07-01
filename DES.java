import java.util.*;
import javax.crypto.*;
import java.io.*;
import java.security.*;
import java.security.spec.*;

public class DES {
    public static void main(String[] args) throws Exception {
        String msg = "welcome";
        byte[] myMsg = msg.getBytes();
        KeyGenerator kg = KeyGenerator.getInstance("DES");
        SecretKey sk = kg.generateKey();
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, sk);
        byte[] encryptedBytes = cipher.doFinal(myMsg);
        cipher.init(cipher.DECRYPT_MODE, sk);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String encryptedData = new String(encryptedBytes);
        String decryptedData = new String(decryptedBytes);
        System.out.println("Message : " + msg);
        System.out.println("Encrypted Data : " + encryptedData);
        System.out.println("Decrypted Data : " + decryptedData);
    }
}