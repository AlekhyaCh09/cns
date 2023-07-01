import java.io.*;
import java.util.*;

public class Ceaser {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter a String: ");
        String msg = sc.nextLine();
        System.out.print("Enter the key: ");
        int key = sc.nextInt();
        String encrypted = encrypt(msg, key);
        System.out.println("Encrypted String is : " + encrypted);
        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted String is : " + decrypted);
    }

    public static String encrypt(String msg, int key) {
        String encrypted = "";
        for (int i = 0; i < msg.length(); i++) {
            int c = msg.charAt(i);
            if (Character.isUpperCase(c)) {
                c = c + (key % 26);
                if (c > 'Z')
                    c = c - 26;
            } else if (Character.isLowerCase(c)) {
                c = c + (key % 26);
                if (c > 'z')
                    c = c - 26;
            }
            encrypted += (char) c;
        }
        return encrypted;
    }

    public static String decrypt(String msg, int key) {
        String decrypted = "";
        for (int i = 0; i < msg.length(); i++) {
            int c = msg.charAt(i);
            if (Character.isUpperCase(c)) {
                c = c - (key % 26);
                if (c < 'A')
                    c = c + 26;
            } else if (Character.isLowerCase(c)) {
                c = c - (key % 26);
                if (c < 'a')
                    c = c + 26;
            }
            decrypted += (char) c;
        }
        return decrypted;
    }
}