import java.math.*;
import java.util.*;

public class RSA {
    public static void main(String[] args) {
        int p = 3, q = 11, n, z, d = 0, e, i;
        int msg = 12;
        double c;
        BigInteger msgBack;
        n = p * q;
        z = (p - 1) * (q - 1);
        System.out.println("Value of z : " + z);
        for (e = 2; e < z; e++)
            if (gcd(e, z) == 1)
                break;

        System.out.println("Value of e : " + e);
        for (i = 0; i <= q; i++) {
            int x = 1 + (i * z);
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }
        System.out.println("The value of d : " + d);
        c = Math.pow(msg, e) % n;
        System.out.println("Encrypted msg is " + c);
        BigInteger N = BigInteger.valueOf(n);
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        msgBack = (C.pow(d)).mod(N);
        System.out.println("Decrypted msg : " + msgBack);
    }

    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(a % b, a);
    }

}