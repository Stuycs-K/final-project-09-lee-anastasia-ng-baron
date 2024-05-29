public class encrypt {

    public static Matrix makeState(byte[] input) { //Takes 16 bytes and creates a 4x4 matrix
        Matrix state = new Matrix();
        for (int i = 0; i < 4; i++) {
            state.addColumn(input[4*i], input[4*i+1], input[4*i+2], input[4*i+3]);
        }
        return state;
    }

    public static int[] sbox = {0x63, 0x7c, 0x77, 0x7b, 0xf2, 0x6b, 0x6f, 0xc5, 0x30, 0x01, 0x67, 0x2b, 0xfe, 0xd7, 0xab, 0x76,
                                0xca, 0x82, 0xc9, 0x7d, 0xfa, 0x59, 0x47, 0xf0, 0xad, 0xd4, 0xa2, 0xaf, 0x9c, 0xa4, 0x72, 0xc0,
                                0xb7, 0xfd, 0x93, 0x26, 0x36, 0x3f, 0xf7, 0xcc, 0x34, 0xa5, 0xe5, 0xf1, 0x71, 0xd8, 0x31, 0x15,
                                0x04, 0xc7, 0x23, 0xc3, 0x18, 0x96, 0x05, 0x9a, 0x07, 0x12, 0x80, 0xe2, 0xeb, 0x27, 0xb2, 0x75,
                                0x09, 0x83, 0x2c, 0x1a, 0x1b, 0x6e, 0x5a, 0xa0, 0x52, 0x3b, 0xd6, 0xb3, 0x29, 0xe3, 0x2f, 0x84,
                                0x53, 0xd1, 0x00, 0xed, 0x20, 0xfc, 0xb1, 0x5b, 0x6a, 0xcb, 0xbe, 0x39, 0x4a, 0x4c, 0x58, 0xcf,
                                0xd0, 0xef, 0xaa, 0xfb, 0x43, 0x4d, 0x33, 0x85, 0x45, 0xf9, 0x02, 0x7f, 0x50, 0x3c, 0x9f, 0xa8,
                                0x51, 0xa3, 0x40, 0x8f, 0x92, 0x9d, 0x38, 0xf5, 0xbc, 0xb6, 0xda, 0x21, 0x10, 0xff, 0xf3, 0xd2,
                                0xcd, 0x0c, 0x13, 0xec, 0x5f, 0x97, 0x44, 0x17, 0xc4, 0xa7, 0x7e, 0x3d, 0x64, 0x5d, 0x19, 0x73,
                                0x60, 0x81, 0x4f, 0xdc, 0x22, 0x2a, 0x90, 0x88, 0x46, 0xee, 0xb8, 0x14, 0xde, 0x5e, 0x0b, 0xdb,
                                0xe0, 0x32, 0x3a, 0x0a, 0x49, 0x06, 0x24, 0x5c, 0xc2, 0xd3, 0xac, 0x62, 0x91, 0x95, 0xe4, 0x79,
                                0xe7, 0xc8, 0x37, 0x6d, 0x8d, 0xd5, 0x4e, 0xa9, 0x6c, 0x56, 0xf4, 0xea, 0x65, 0x7a, 0xae, 0x08,
                                0xba, 0x78, 0x25, 0x2e, 0x1c, 0xa6, 0xb4, 0xc6, 0xe8, 0xdd, 0x74, 0x1f, 0x4b, 0xbd, 0x8b, 0x8a,
                                0x70, 0x3e, 0xb5, 0x66, 0x48, 0x03, 0xf6, 0x0e, 0x61, 0x35, 0x57, 0xb9, 0x86, 0xc1, 0x1d, 0x9e,
                                0xe1, 0xf8, 0x98, 0x11, 0x69, 0xd9, 0x8e, 0x94, 0x9b, 0x1e, 0x87, 0xe9, 0xce, 0x55, 0x28, 0xdf,
                                0x8c, 0xa1, 0x89, 0x0d, 0xbf, 0xe6, 0x42, 0x68, 0x41, 0x99, 0x2d, 0x0f, 0xb0, 0x54, 0xbb, 0x16};
    
    // Takes the State as input, Outputs the modified state
    // For each byte, sbox is applied
    public static Matrix SubBytes(Matrix state) {
        for (int c = 0; c < 4; c++) {
            for (int r = 0; r < 4; r++) {
                byte b = state.get(c)[r];
                state.get(c)[r] = (byte)sbox[b & 0xff];
            }
        }

        return state;
        //System.out.println((byte)sbox[5]);
        //System.out.println(sbox.length);
    }

    // ShiftRows() is a transformation of the state in which 
    // the bytes in the last three rows of the state are cyclically shifted. 
    //
    // The number of positions by which the bytes are shifted depends on the row index _r_.
    public static Matrix ShiftRows(Matrix m, int r){
        r = r % 4;
        if (r > 0){

            byte [] c1 = m.get(0);
            byte [] c2 = m.get(1);
            byte [] c3 = m.get(2);
            byte [] c4 = m.get(3);
            byte [][] rows = {{c1[1], c1[2], c1[3]},{c2[1], c2[2], c2[3]},{c3[1], c3[2], c3[3]},{c4[1], c4[2], c4[3]}}; // the last 3 rows
            
            Matrix modified_state = new Matrix();

            if (r == 1){
                modified_state.addColumn(c1[0], rows[1][0], rows[1][1], rows[1][2]);
                modified_state.addColumn(c2[0], rows[2][0], rows[2][1], rows[2][2]);
                modified_state.addColumn(c3[0], rows[3][0], rows[3][1], rows[3][2]);
                modified_state.addColumn(c4[0], rows[0][0], rows[0][1], rows[0][2]);
            } else if (r == 2){
                modified_state.addColumn(c1[0], rows[2][0], rows[2][1], rows[2][2]);
                modified_state.addColumn(c2[0], rows[3][0], rows[3][1], rows[3][2]);
                modified_state.addColumn(c3[0], rows[0][0], rows[0][1], rows[0][2]);
                modified_state.addColumn(c4[0], rows[1][0], rows[1][1], rows[1][2]);
            } else if (r == 3){
                modified_state.addColumn(c1[0], rows[3][0], rows[3][1], rows[3][2]);
                modified_state.addColumn(c2[0], rows[0][0], rows[0][1], rows[0][2]);
                modified_state.addColumn(c3[0], rows[1][0], rows[1][1], rows[1][2]);
                modified_state.addColumn(c4[0], rows[2][0], rows[2][1], rows[2][2]);
            }else {
                System.out.println ("Shift rows acting sus");
            }

            return modified_state;
        }
        return m;
    }

    // MixColumns() multiplies each of the four columns of the state by a fixed matrix.
    // The Fixed Matrix = [a0, a1, a2, a3] = [{02}, {01}, {01}, {03}]. 
    public static Matrix MixColumns(Matrix state) {
        Matrix c = new Matrix();
        c.addColumn((byte)02, (byte)01, (byte)01, (byte)03);
        c.addColumn((byte)03, (byte)02, (byte)01, (byte)01);
        c.addColumn((byte)01, (byte)03, (byte)02, (byte)01);
        c.addColumn((byte)01, (byte)01, (byte)03, (byte)02);
        state.mult(c);
        return state;
    }

    public static void main(String[] args) {
        byte b = (byte)0b01101011;
        byte[] input = {(byte)0b10101010, (byte)0b11111100, (byte)0b01010011, (byte)0b11001010, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
        Matrix state = makeState(input);
        //System.out.println((int)b);
        //SubBytes(state);
        //System.out.println(state);

        state = MixColumns(state);
        System.out.println(state);

        // byte[] input2 = {(byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)3, (byte)3, (byte)3, (byte)3, (byte)4, (byte)4, (byte)4, (byte)4};
        // Matrix state2 = makeState(input2);
        // state2 = ShiftRows(state2, 3);
        // System.out.println(state2);
    }
}