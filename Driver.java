import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Driver {
    public static void main (String [] args) throws IOException {
        // args[1] type
        // args[2] inputFile
        // args[3] keyFile
        // args[4] outputFile
        
        boolean check0 = (args[0].equals("encrypt")) || (args[0].equals("decrypt"));
        boolean check1 = (args[1].equals("byte")) || (args[1].equals("hex")) || (args[1].equals("text"));
        boolean check = (args[2] == null) || (args[3] == null) || (args[4] == null);
        if (!check0) {
            System.out.println("Invalid mode. Choose encrypt or decrypt.");
        }
        if (!check1) {
            System.out.println("Invalid type. Choose byte, hex, or text.");
            return;
        }
        if (check) {
            System.out.println("Some parameters are missing");
            return;
        }

        byte[] input;
        byte[] key;

        if (args[1].equals("hex")) {
            String s = Files.readString(Paths.get(args[2]));
            s = s.replaceAll("\\s", "");
            input = HexFormat.of().parseHex(s);

            String s1 = Files.readString(Paths.get(args[3]));
            s1 = s1.replaceAll("\\s", "");
            key = HexFormat.of().parseHex(s1);
        }
        else {
            input = Files.readAllBytes(Paths.get(args[2]));
            key = Files.readAllBytes(Paths.get(args[3]));
        }
        
        if (key.length != 32) {
            System.out.println("The key is not the correct length of 32");
            return;
        }
        FileWriter output = new FileWriter(args[4]);

        int newLength = 16*(int)Math.ceil(input.length/16.0);
        byte[] padded = new byte[newLength];
        for (int i = 0; i < input.length; i++) {
            padded[i] = input[i];
        }

        for (int i = input.length; i < newLength; i++) {
            padded[i] = (byte)0x20;
        }

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
                if (args[1].equals("byte")) {
                    output.append(t.AES256(seg, key).toIntString());
                }
                else if (args[1].equals("hex")) {
                    output.append(t.AES256(seg, key).toHexString().trim());
                }
                else if (args[1].equals("text")) {
                    output.append(t.AES256(seg, key).toSuperString());
                }
            } else {
                Decrypt t = new Decrypt(seg, key);
                if (args[1].equals("byte")) {
                    output.append(t.AES256(seg, key).toIntString());
                }
                else if (args[1].equals("hex")) {
                    output.append(t.AES256(seg, key).toHexString().trim());
                }
                else if (args[1].equals("text")) {
                    output.append(t.AES256(seg, key).toSuperString());
                }
            }
        }
        output.close();

    }
}
