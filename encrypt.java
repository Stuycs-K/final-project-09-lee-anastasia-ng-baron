import java.util.*;
public class encrypt {
    static Matrix state = new Matrix();
    public static void makeState(byte[] input) {
        for (int i = 0; i < 4; i++) {
            state.addColumn(input[4*i], input[4*i+1], input[4*i+2], input[4*i+3]);
        }
    }
    public static void SubBytes() {
        int[] sbox = {0x63, 0x7c, 0x77, 0x7b, 0xf2, 0x6b, 0x6f, 0xc5, 0x30, 0x01, 0x67, 0x2b, 0xfe, 0xd7, 0xab, 0x76};
        System.out.println((byte)sbox[5]);
        System.out.println(sbox.length);
    }
    public static void main(String[] args) {
        byte b = (byte)0b01101011;

        System.out.println((int)b);
        SubBytes();

    }
}