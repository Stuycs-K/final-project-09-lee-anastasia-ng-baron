import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Driver {
    public static void main (String [] args) throws IOException {
        // args[0] encrypt / decrypt
        // args[1] Input Mode
        // args[2] inputFile / inputString
        // args[3] keyFile / keyString
        // args[4] outputFile

        // -------------- Reading Input -----------------

        byte[] input;
        byte[] key;

        if (args[1].equals("STRING")){
            input = args[2].getBytes();
            key = args[3].getBytes();
        } else if (args[1].equals("FILE")){
            FileInputStream inputFIR = new FileInputStream(new File(args[2]));
            FileInputStream keyFIR = new FileInputStream(new File(args[3]));
            input = inputFIR.readAllBytes();
            key = keyFIR.readAllBytes();
            inputFIR.close();
            keyFIR.close();
        } else {
            System.out.println("Invalid Input mode. Choose FILE or STRING.");
            return;
        }

        // -------------- Padding the Input -----------------

        if (key.length != 32) {
            System.out.println("The key is not the correct length of 32.");
            return;
        }
    
        // This padding works for both modes
        int paddedLength = 16 * (int)Math.ceil(input.length/16.0);
        //System.out.println (paddedLength - input.length);
        byte[] padded = new byte[paddedLength];
        
        for (int i = 0; i < input.length; i++) { // fill up new array with contents
            padded[i] = input[i];
        }
        for (int i = input.length; i < paddedLength; i++) { // fill up the array with filler
            padded[i] = (byte)0x20; // same as a space: " "
        }

        // -------------- Encryption -----------------

        if (args[0].equals("encrypt")){

            byte[] encrypted = new byte[paddedLength];
            for (int i = 0; i < paddedLength; i+=16){
                Encrypt t = new Encrypt();
                byte [] b = new byte[]{padded[i], padded[i+1], padded[i+2], padded[i+3], padded[i+4], padded[i+5], padded[i+6], padded[i+7], padded[i+8], padded[i+9], padded[i+10], padded[i+11], padded[i+12], padded[i+13], padded[i+14], padded[i+15]};
                Matrix result = t.AES256(b, key);
                for (int j = 0; j < 4; j++){ // move the encrypted results into a single byte array
                    encrypted[i + j] = result.get(0)[j];
                }
                for (int j = 0; j < 4; j++){
                    encrypted[i + 4 + j] = result.get(1)[j];
                }
                for (int j = 0; j < 4; j++){
                    encrypted[i + 8 + j] = result.get(2)[j];
                }
                for (int j = 0; j < 4; j++){
                    encrypted[i + 12 + j] = result.get(3)[j];
                }

            }

            if (args[1].equals("STRING")){

                String s = "";

                for (int i = 0; i < paddedLength; i++){
                    s += (char)(encrypted[i] & 0xff);
                }

                System.out.println (s);

                FileOutputStream output = new FileOutputStream(new File(args[4]));
                output.write(encrypted);
                output.close();

            } else if (args[1].equals("FILE")){
                
                FileOutputStream output = new FileOutputStream(new File(args[4]));
                output.write(encrypted);
                output.close();

            }

        }

        // -------------- Decryption -----------------

        else if (args[0].equals("decrypt")){

            byte[] decrypted = new byte[paddedLength];
            for (int i = 0; i < paddedLength; i+=16){

                Decrypt t = new Decrypt();
                byte [] b = new byte[]{padded[i], padded[i+1], padded[i+2], padded[i+3], padded[i+4], padded[i+5], padded[i+6], padded[i+7], padded[i+8], padded[i+9], padded[i+10], padded[i+11], padded[i+12], padded[i+13], padded[i+14], padded[i+15]};
                Matrix result = t.AES256(b, key);

                for (int j = 0; j < 4; j++){ // move the decrypted results into a single byte array
                    decrypted[i + j] = result.get(0)[j];
                }
                for (int j = 0; j < 4; j++){
                    decrypted[i + 4 + j] = result.get(1)[j];
                }
                for (int j = 0; j < 4; j++){
                    decrypted[i + 8 + j] = result.get(2)[j];
                }
                for (int j = 0; j < 4; j++){
                    decrypted[i + 12 + j] = result.get(3)[j];
                }
            }

            if (args[1].equals("STRING")){

                String s = "";

                for (int i = 0; i < paddedLength; i++){
                    s += (char)(decrypted[i] & 0xff);
                }

                System.out.println (s);

            } else if (args[1].equals("FILE")){
                
                FileOutputStream output = new FileOutputStream(new File(args[4]));
                output.write(decrypted);
                output.close();

            }

        } else {
            System.out.println("Invalid: encryption or decryption only.");
        }

    }
}
