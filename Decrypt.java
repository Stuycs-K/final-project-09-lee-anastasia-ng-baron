import java.util.*;

public class Decrypt {

    private String input;
    private String key;

    public Decrypt (String in, String k){
        input = in;
        key = k;
    }

    private static int Nr = 10; // Nr is 14 for AES 256, number of rounds
    private static int Nk = 4; // Nk is 8 for AES 256, key length in words
    private static byte [][] Rcon = {{},
                                    {0x01, 0x00, 0x00, 0x00},
                                    {0x02, 0x00, 0x00, 0x00},
                                    {0x04, 0x00, 0x00, 0x00},
                                    {0x08, 0x00, 0x00, 0x00},
                                    {0x10, 0x00, 0x00, 0x00},
                                    {0x20, 0x00, 0x00, 0x00},
                                    {0x40, 0x00, 0x00, 0x00},
                                    {(byte)0x80, 0x00, 0x00, 0x00},
                                    {0x1b, 0x00, 0x00, 0x00},
                                    {0x36, 0x00, 0x00, 0x00}};

    private int round = Nr;
    
    private static Matrix makeState(byte[] input) { //Takes 16 bytes and creates a 4x4 matrix

        Matrix state = new Matrix();
        for (int i = 0; i < 4; i++) {
            state.addColumn(input[4*i], input[4*i+1], input[4*i+2], input[4*i+3]);
        }
        
        return state;
    }

    private static Integer[] sbox = {0x63, 0x7c, 0x77, 0x7b, 0xf2, 0x6b, 0x6f, 0xc5, 0x30, 0x01, 0x67, 0x2b, 0xfe, 0xd7, 0xab, 0x76,
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
    
    private static List<Integer> sbox2 = new ArrayList<Integer>(Arrays.asList(sbox));
    
    private static Matrix InvSubBytes(Matrix state) {

        for (int c = 0; c < 4; c++) {
            for (int r = 0; r < 4; r++) {
                byte b = state.get(c)[r];
                state.get(c)[r] = (byte)sbox2.indexOf(b & 0xff);
            }
        }

        return state;
    }

    private static Matrix InvShiftRows(Matrix m){

        System.out.println (m.toHexString());
        byte [] c1 = m.get(0);
        byte [] c2 = m.get(1);
        byte [] c3 = m.get(2);
        byte [] c4 = m.get(3);
        byte [][] state = {c1, c2, c3, c4};
        
        Matrix modified_state = new Matrix();

        for (int col = 0; col < 4; col++){
            byte a = state[col][0];
            byte b = state[(col + 3) % 4][1]; // row 2, +3 bc otherwise it would be negative indexing
            byte c = state[(col + 2) % 4][2]; // row 3, +2 bc otherwise it would be negative indexing
            byte d = state[(col + 1) % 4][3]; // row 4, +1 bc otherwise it would be negative indexing
            modified_state.addColumn(a,b,c,d);
        }

        return modified_state;
    }

    // InvMixColumns() multiplies each of the four columns of the state by a fixed matrix.
    // The Fixed Matrix = [a0, a1, a2, a3] = [{0e}, {09}, {0d}, {0b}]. 
    private static Matrix InvMixColumns(Matrix state) {

        Matrix a = new Matrix();

        for (int c = 0; c < 4; c++) {
            byte[] given = state.m.get(c);
            byte[] col = new byte[4];
            
            col[0] = (byte)(TimesE(given[0]) ^ TimesB(given[1]) ^ TimesD(given[2]) ^ Times9(given[3]));
            col[1] = (byte)(Times9(given[0]) ^ TimesE(given[1]) ^ TimesB(given[2]) ^ TimesD(given[3]));
            col[2] = (byte)(TimesD(given[0]) ^ Times9(given[1]) ^ TimesE(given[2]) ^ TimesB(given[3]));
            col[3] = (byte)(TimesB(given[0]) ^ TimesD(given[1]) ^ Times9(given[2]) ^ TimesE(given[3]));

        }

        return a;
    }

    private static byte xTimes(byte b) {
        byte prod = (byte)(b << 1);
        if (b >> 7 != 0) {
            prod = (byte)(prod ^ 0x1b);
        }
        return prod;
    }

    // 09 = 08 + 01
    private static byte Times9(byte b) {
        return (byte)(b ^ xTimes(xTimes(xTimes(b))));
    }

    // 0B = 08 + 02 + 01
    private static byte TimesB(byte b) {
        return (byte)(b ^ xTimes(b) ^ xTimes(xTimes(xTimes(b))));
    }

    // 0D = 08 + 04 + 01
    private static byte TimesD(byte b) {
        return (byte)(b ^ xTimes(xTimes(b)) ^ xTimes(xTimes(xTimes(b))));
    }

    // 0E = 08 + 04 + 02
    private static byte TimesE(byte b) {
        return (byte)(xTimes(b) ^ xTimes(xTimes(b)) ^ xTimes(xTimes(xTimes(b))));
    }

    // AddRoundKey is its own inverse
    private Matrix AddRoundKey(Matrix state, byte[][] w){

        Matrix modified = new Matrix();

        for (int c = 0; c < 4; c++) {
            
            byte[] before = state.m.get(c);
            int index = (4 * round) + c; // round comes from Cipher()
            byte[] word = w[index];
            byte[] after = new byte[4];
            after = XOR(before, word);

            modified.addColumn(after[0], after[1], after[2], after[3]);
        }

        return modified;
    }

    // Generates 4*(Nr + 1) words, four for each operation of AddRoundKey, which runs (Nr + 1) times
    // KeyExpansion() has 10 fixed words called round constants
    // For AES 256, only the first 7 round constants are used
    // Nr means 'number of rounds'; Nk means "key length" in 32 bit words
    // input "key" is an array of Nk words
    // variables:
    // i = index for the output array of words ; 0 ≤ i < 4 ∗ (Nr + 1)
    // j = index for the Rconstants ; 1 ≤ j ≤ 10
    public static byte[][] KeyExpansion(byte[] key){ // key is 32 bytes
        
        byte [][] w = new byte[4 * (Nr + 1)][4]; // The output array of words; key schedule
        
        int i = 0;
        
        while (i <= Nk - 1){// iterates through the 8 words in the key
            w[i] = new byte []{key[4 * i], key[4 * i + 1], key[4 * i + 2], key[4 * i + 3]};
            i++;
        } // First Nk words of the expanded key, w, are the key itself

        while (i <= 4 * Nr + 3){ // 15 as req number of rounds
            byte[] temp = w[i - 1]; // researched from Wikipedia
            if (i % Nk == 0){
                temp = XOR (SubWord(RotWord(temp)), Rcon[i / Nk]);
            } else if ((Nk > 6) && (i % Nk == 4)){
                temp = SubWord(temp);
            }
            w[i] = XOR (w[i - Nk], temp);
            i++;
        }
        return w; // if I am understanding this correctly, this should be be 60 x 4, enough for (Nr + 1) round keys!
    }
    
    // Used by KeyExpansion()
    private static byte[] RotWord(byte [] word){
        byte [] modified_word = {word[1], word[2], word[3], word[0]};
        return modified_word;
    }
    // Used by KeyExpansion()
    private static byte[] SubWord(byte [] b){
        return new byte[]{(byte)(int)sbox[b[0] & 0xff], (byte)(int)sbox[b[1] & 0xff], (byte)(int)sbox[b[2] & 0xff], (byte)(int)sbox[b[3] & 0xff]};
    }

    private static byte[] XOR (byte [] word1, byte[] word2){

        byte [] b = new byte[4];
        for (int i = 0; i < word1.length; i++){
            b[i] = (byte)(word1[i] ^ word2[i]);
        }
        return b;
    }

    // - KeyExpansion is called outside of Cipher()
    // - Nr is set outside of Cipher()
    // - in is 256 bits, or 16 bytes worth of data in array form
    public Matrix InvCipher(byte [] in, int Nr, byte[][] w){

        Matrix state = makeState(in);
        state = AddRoundKey(state, w);

        // state <- round key addition
        for (round = Nr - 1; round >= 1; round--){ // confirmed in AddRoundKey: 1 ≤ round ≤ Nr
            state = InvShiftRows(state);
            state = InvSubBytes(state);
            state = AddRoundKey(state, w);
            state = InvMixColumns(state);
        }
        state = InvShiftRows(state);
        state = InvSubBytes(state);
        // MixColumns() is omitted; idk what that means
        state = AddRoundKey(state, w);
        return state;
    }


    // The Wrapper function for everything
    public Matrix AES256 (String s, String k){
        byte[] input = s.getBytes();
        byte[] key = k.getBytes();
        byte [][] expanded_key = KeyExpansion(key); // KeyExpansion is supposedly the same
        return InvCipher(input, Nr, expanded_key);
    }

    public static void main(String[] args) {
        Matrix m = makeState(new byte []{0,0,0,0,1,1,1,1,2,2,2,2,3,3,3,3});

        System.out.println (InvShiftRows(m).toIntString());
    }
}
