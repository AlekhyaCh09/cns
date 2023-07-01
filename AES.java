import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;

public class AES {
    public static String asHex(byte buf[]) {
        StringBuffer buff = new StringBuffer(buf.length * 2);
        for (int i = 0; i < buf.length; i++) {
            if (((int) buf[i] & 0xff) < 0x10)
                buff.append("0");
            buff.append(Long.toString((int) buf[i] & 0xff, 16));
        }
        return buff.toString();
    }

    public static void main(String[] args) throws Exception {
        String msg = "AES Algorithm";
        KeyGenerator kg = KeyGenerator.getInstance("AES");
        kg.init(128);
        SecretKey sk = kg.generateKey();
        byte[] raw = sk.getEncoded();
        SecretKeySpec skspec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skspec);
        byte[] encrypted = cipher.doFinal((args.length == 0 ? msg : args[0]).getBytes());
        System.out.println("Encrypted string : " + asHex(encrypted));
        cipher.init(Cipher.DECRYPT_MODE, skspec);
        byte[] original = cipher.doFinal(encrypted);
        String originalString = new String(original);
        System.out.println("original String in Hexadecimal : " + asHex(original));
        System.out.println("Original String : " + originalString);

    }
}
