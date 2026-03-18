import java.util.Scanner;

public class SimpleRSA {

    // Method to find gcd
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    // Method to find modular inverse (for d)
    static int modInverse(int e, int phi) {
        for (int d = 1; d < phi; d++) {
            if ((e * d) % phi == 1)
                return d;
        }
        return -1;
    }

    // Method for modular exponentiation
    static int modPower(int base, int exp, int mod) {
        int result = 1;
        base = base % mod;

        while (exp > 0) {
            if (exp % 2 == 1)
                result = (result * base) % mod;

            exp = exp / 2;
            base = (base * base) % mod;
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter prime number p: ");
        int p = sc.nextInt();

        System.out.print("Enter prime number q: ");
        int q = sc.nextInt();

        int n = p * q;
        int phi = (p - 1) * (q - 1);

        int e;
        System.out.print("Enter public key e: ");
        e = sc.nextInt();

        while (gcd(e, phi) != 1) {
            System.out.println("e is not valid. Enter another e:");
            e = sc.nextInt();
        }

        int d = modInverse(e, phi);

        System.out.println("Public Key: (" + e + ", " + n + ")");
        System.out.println("Private Key: (" + d + ", " + n + ")");

        System.out.print("Enter message (number < n): ");
        int message = sc.nextInt();

        int cipher = modPower(message, e, n);
        System.out.println("Encrypted message: " + cipher);

        int decrypted = modPower(cipher, d, n);
        System.out.println("Decrypted message: " + decrypted);

        sc.close();
    }
}