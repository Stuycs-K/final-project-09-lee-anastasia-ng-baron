import java.util.*;
public class encrypt {
    static Matrix state = new Matrix();
    public static void makeState(byte[] input) {
        for (int i = 0; i < 4; i++) {
            state.addColumn(input[4*i], input[4*i+1], input[4*i+2], input[4*i+3]);
        }
    }
    public static void main(String[] args) {
        byte b = (byte)01000011;
        System.out.println((int)b);

    }
}