import java.util.*;
public class encrypt {
    Matrix state = new Matrix();
    public void makeState(byte[] input) {
        for (int i = 0; i < 4; i++) {
            state.addColumn(input[4*i], input[4*i+1], input[4*i+2], input[4*i+3]);
        }
    }
}