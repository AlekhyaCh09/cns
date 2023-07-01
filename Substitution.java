import java.io.*;
import java.util.*;

public class Substitution {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String a = "abcdefghijklmnopqrstuvwxyz";
        String b = "zyxwvutsrqponmlkjihgfedcba";

        System.out.print("Enter a String: ");
        String msg = sc.nextLine();
        String decrypt = "";
        char c;
        for (int i = 0; i < msg.length(); i++) {
            c = msg.charAt(i);
            int j = a.indexOf(c);
            decrypt += b.charAt(i);
        }
        System.out.println("The encrypted data is " + decrypt);
    }
}