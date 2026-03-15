import java.util.Arrays;

public class SDES {

    // Permutation tables

    static int[] P10 = {3,5,2,7,4,10,1,9,8,6};
    static int[] P8  = {6,3,7,4,8,5,10,9};
    static int[] IP  = {2,6,3,1,4,8,5,7};
    static int[] IP_INV = {4,1,3,5,7,2,8,6};
    static int[] EP  = {4,1,2,3,2,3,4,1};
    static int[] P4  = {2,4,3,1};

    // S-Boxes
    static int[][] S0 = {
        {1,0,3,2},
        {3,2,1,0},
        {0,2,1,3},
        {3,1,3,2}
    };

    static int[][] S1 = {
        {0,1,2,3},
        {2,0,1,3},
        {3,0,1,0},
        {2,1,0,3}
    };

    static int[] K1, K2;

    // ================= Key Generation =================
    static void generateKeys(int[] key) {
        int[] p10 = permute(key, P10);
        int[] left = Arrays.copyOfRange(p10, 0, 5);
        int[] right = Arrays.copyOfRange(p10, 5, 10);

        left = leftShift(left, 1);
        right = leftShift(right, 1);
        K1 = permute(merge(left, right), P8);

        left = leftShift(left, 2);
        right = leftShift(right, 2);
        K2 = permute(merge(left, right), P8);
    }

    // ================= Encryption =================
    static int[] encrypt(int[] plaintext) {
        int[] ip = permute(plaintext, IP);
        int[] temp = fk(ip, K1);
        temp = swap(temp);
        temp = fk(temp, K2);
        return permute(temp, IP_INV);
    }

    // ================= Decryption =================
    static int[] decrypt(int[] ciphertext) {
        int[] ip = permute(ciphertext, IP);
        int[] temp = fk(ip, K2);
        temp = swap(temp);
        temp = fk(temp, K1);
        return permute(temp, IP_INV);
    }

    // ================= fk Function =================
    static int[] fk(int[] bits, int[] key) {
        int[] left = Arrays.copyOfRange(bits, 0, 4);
        int[] right = Arrays.copyOfRange(bits, 4, 8);

        int[] ep = permute(right, EP);
        int[] xor = xor(ep, key);

        int[] sboxOut = sBox(xor);
        int[] p4 = permute(sboxOut, P4);

        int[] resultLeft = xor(left, p4);
        return merge(resultLeft, right);
    }

    // ================= Helper Methods =================
    static int[] permute(int[] bits, int[] table) {
        int[] output = new int[table.length];
        for (int i = 0; i < table.length; i++)
            output[i] = bits[table[i] - 1];
        return output;
    }

    static int[] leftShift(int[] bits, int shifts) {
        int[] result = bits.clone();
        for (int i = 0; i < shifts; i++) {
            int temp = result[0];
            System.arraycopy(result, 1, result, 0, bits.length - 1);
            result[bits.length - 1] = temp;
        }
        return result;
    }

    static int[] xor(int[] a, int[] b) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++)
            result[i] = a[i] ^ b[i];
        return result;
    }

    static int[] sBox(int[] bits) {
        int[] left = Arrays.copyOfRange(bits, 0, 4);
        int[] right = Arrays.copyOfRange(bits, 4, 8);

        int row1 = (left[0] << 1) | left[3];
        int col1 = (left[1] << 1) | left[2];

        int row2 = (right[0] << 1) | right[3];
        int col2 = (right[1] << 1) | right[2];

        int[] out = new int[4];
        int val1 = S0[row1][col1];
        int val2 = S1[row2][col2];

        out[0] = (val1 >> 1) & 1;
        out[1] = val1 & 1;
        out[2] = (val2 >> 1) & 1;
        out[3] = val2 & 1;

        return out;
    }

    static int[] swap(int[] bits) {
        return merge(
                Arrays.copyOfRange(bits, 4, 8),
                Arrays.copyOfRange(bits, 0, 4)
        );
    }

    static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }


    public static void main(String[] args) {

        int[] key = {1,0,1,0,0,0,0,0,1,0};
        int[] plaintext = {1,0,0,1,0,1,1,1};

        generateKeys(key);

        int[] cipher = encrypt(plaintext);
        int[] decrypted = decrypt(cipher);

        System.out.println("Cipher Text: " + Arrays.toString(cipher));
        System.out.println("Decrypted Text: " + Arrays.toString(decrypted));
    }
}



