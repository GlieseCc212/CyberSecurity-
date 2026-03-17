import java.util.Scanner;

public class SAES {

    // S-Box and Inverse S-Box
    static int[] SBOX = {
        0x9, 0x4, 0xA, 0xB,
        0xD, 0x1, 0x8, 0x5,
        0x6, 0x2, 0x0, 0x3,
        0xC, 0xE, 0xF, 0x7
    };

    static int[] RCON = {0x80, 0x30};

    // Multiply in GF(2^4)
    static int gfMultiply(int a, int b) {
        int p = 0;
        while (b > 0) {
            if ((b & 1) != 0)
                p ^= a;
            a <<= 1;
            if ((a & 0x10) != 0)
                a ^= 0x13; // x^4 + x + 1
            b >>= 1;
        }
        return p & 0xF;
    }

    // Substitute nibble
    static int subNib(int nib) {
        return SBOX[nib];
    }

    // g-function
    static int gFunction(int word, int round) {
        int left = (word >> 4) & 0xF;
        int right = word & 0xF;

        int rotated = (right << 4) | left;
        int sub = (subNib((rotated >> 4) & 0xF) << 4)
                | subNib(rotated & 0xF);

        return sub ^ RCON[round];
    }

    // Key Expansion
    static int[] keyExpansion(int key) {
        int[] w = new int[6];
        w[0] = (key >> 8) & 0xFF;
        w[1] = key & 0xFF;

        w[2] = w[0] ^ gFunction(w[1], 0);
        w[3] = w[2] ^ w[1];
        w[4] = w[2] ^ gFunction(w[3], 1);
        w[5] = w[4] ^ w[3];

        return w;
    }

    // Add Round Key
    static int addRoundKey(int state, int key) {
        return state ^ key;
    }

    // SubNib on state
    static int subNibbles(int state) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            int nib = (state >> (12 - 4 * i)) & 0xF;
            result |= subNib(nib) << (12 - 4 * i);
        }
        return result;
    }

    // ShiftRows
    static int shiftRows(int state) {
        int a = (state >> 12) & 0xF;
        int b = (state >> 8) & 0xF;
        int c = (state >> 4) & 0xF;
        int d = state & 0xF;

        return (a << 12) | (d << 8) | (c << 4) | b;
    }

    // MixColumns
    static int mixColumns(int state) {
        int a = (state >> 12) & 0xF;
        int b = (state >> 8) & 0xF;
        int c = (state >> 4) & 0xF;
        int d = state & 0xF;

        int r0 = gfMultiply(a, 1) ^ gfMultiply(c, 4);
        int r1 = gfMultiply(b, 1) ^ gfMultiply(d, 4);
        int r2 = gfMultiply(a, 4) ^ gfMultiply(c, 1);
        int r3 = gfMultiply(b, 4) ^ gfMultiply(d, 1);

        return (r0 << 12) | (r1 << 8) | (r2 << 4) | r3;
    }

    // Encryption
    static int encrypt(int plaintext, int[] w) {

        int state = addRoundKey(plaintext, (w[0] << 8) | w[1]);

        // Round 1
        state = subNibbles(state);
        state = shiftRows(state);
        state = mixColumns(state);
        state = addRoundKey(state, (w[2] << 8) | w[3]);

        // Round 2
        state = subNibbles(state);
        state = shiftRows(state);
        state = addRoundKey(state, (w[4] << 8) | w[5]);

        return state;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 16-bit plaintext (hex): ");
        int plaintext = Integer.parseInt(sc.next(), 16);

        System.out.print("Enter 16-bit key (hex): ");
        int key = Integer.parseInt(sc.next(), 16);

        int[] w = keyExpansion(key);
        int ciphertext = encrypt(plaintext, w);

        System.out.printf("\nCiphertext: %04X\n", ciphertext);
    }
}