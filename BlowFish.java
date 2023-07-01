import java.io.*;
import java.security.*;
import java.util.*;
import java.util.Base64.Encoder;

import javax.crypto.*;
public class BlowFish {
    public static void main(String[] args) throws Exception{
        KeyGenerator kg = KeyGenerator.getInstance("BlowFish");
        kg.init(128);
        SecretKey sk = kg.generateKey();
        Cipher cipher = Cipher.getInstance("BlowFish");
        cipher.init(Cipher.ENCRYPT_MODE, sk);
        Encoder encoder = Base64.getEncoder();
        byte iv[] = cipher.getIV();
        if(iv != null) {
            System.out.println("Initialisation Vector " + encoder.encodeToString(iv));
            FileInputStream fin = new FileInputStream("inputFile.txt");
            FileOutputStream fout = new FileOutputStream("OutputFile.txt");
            CipherOutputStream cout = new CipherOutputStream(fout, cipher);
            int input = 0;
            while((input = fin.read()) != -1) cout .write(input);
            fin.close();
            cout.close();
        }
        
    }
}
