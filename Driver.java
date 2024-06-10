import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Driver {
    public static void main (String [] args) throws IOException {
        // args[0] encrypt / decrypt
        // args[1] Input Mode
        // args[2] inputFile / inputString
        // args[3] keyFile / keyString
        // args[4] outputFile
        
        if (!check0) {
            System.out.println("Invalid. Choose encrypt or decrypt.");
        }
        if (check) {
            System.out.println("Some parameters are missing.");
            return;
        }

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
        } else {
            System.out.println("Invalid Input mode. Choose FILE or STRING.");
            return;
        }

        // -------------- Padding the Input -----------------

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
        } else {
            System.out.println("Invalid Input mode. Choose FILE or STRING.");
            return;
        }
        
        if (key.length != 32) {
            System.out.println("The key is not the correct length of 32");
            return;
        }

        int newLength = 16*(int)Math.ceil(input.length/16.0);
        byte[] padded = new byte[newLength];
        for (int i = 0; i < input.length; i++) {
            padded[i] = input[i];
        }

        for (int i = input.length; i < newLength; i++) {
            padded[i] = (byte)0x20;
        }

        // -------------- Encryption / Decryption -----------------

        FileOutputStream output = new FileOutputStream(new File(args[4]));

        for (int i = 0; i < padded.length; i+=16) { // encrypts for each block of 16 bytes
            if (i != 0) {
                output.append("\n");
            }
            byte[] seg = new byte[16];
            for (int j = i; j < i+16; j++) {
                seg[j % 16] = padded[j];
            }

            if (args[0].equals("encrypt")) {

                Encrypt t = new Encrypt(seg, key);

            } else if (args[0].equals("decrypt"){


                output.write(padded);

            }
        }

        output.close();

    }
}
