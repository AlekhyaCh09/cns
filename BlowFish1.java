import javax.crypto.*;
import javax.swing.*;

public class BlowFish1 {
    public static void main(String[] args) throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance("BlowFish");
        SecretKey sk = kg.generateKey();
        Cipher cipher = Cipher.getInstance("BlowFish");
        String inputText = JOptionPane.showInputDialog("Input Your Message : ");
        byte[] encrypted = cipher.doFinal(inputText.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, sk);
        byte[] decrypted = cipher.doFinal(encrypted);
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
                "Encrypted text : " + new String(encrypted) + "\n" + "Decrypted text : " + new String(decrypted));
        System.exit(0);
    }
}
