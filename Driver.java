import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Driver {
    public static void main (String [] args) throws IOException {
        // args[1] type
        // args[2] inputFile
        // args[3] keyFile
        // args[4] outputFile
        
        // String s1 = "";
        // String s2 = "";
        boolean check = (args[1] == null) || (args[2] == null) || (args[3] == null) || (args[4] == null);
        if (check) {
            System.out.println("Some parameters are missing. Please try again.");
            return;
        }

        byte[] input = Files.readAllBytes(Paths.get(args[2]));
        byte[] key = Files.readAllBytes(Paths.get(args[3]));
        if (key.length != 32) {
            System.out.println("The key is not the correct length of 32");
            return;
        }
        FileWriter cipher = new FileWriter(args[4]);

        int newLength = 16*(int)Math.ceil(input.length/16.0);
        byte[] padded = new byte[newLength];
        for (int i = 0; i < input.length; i++) {
            padded[i] = input[i];
        }

        for (int i = input.length; i < newLength; i++) {
            padded[i] = (byte)0x20;
        }

        if (args[0].equals("encrypt")){
            String encrypted = "";
            for (int i = 0; i < padded.length; i+=16) { // encrypts for each block of 16 bytes
                
                encrypted += t.AES256(seg, key).toSuperString();
                // System.out.println (t.AES256(s1, s2));
                // System.out.println (t.AES256(s1, s2).toSuperString());
            }
            System.out.println(encrypted);

        } else if (args[0].equals("decrypt")){
           
            // -------- Below is for testing using byte arrays -----------
            
            Decrypt t = new Decrypt("", "");
            
            //byte[] state = new byte[] {0x39, 0x25, (byte)0x84, 0x1d, 0x02, (byte)0xdc, 0x09, (byte)0xfb, (byte)0xdc, 0x11, (byte)0x85, (byte)0x97, 0x19, 0x6a, 0x0b, 0x32};
            //byte[] key = new byte[]{0x2b, 0x7e, 0x15, 0x16, 0x28, (byte)0xae, (byte)0xd2, (byte)0xa6, (byte)0xab, (byte)0xf7, 0x15, (byte)0x88, 0x09, (byte)0xcf, 0x4f, 0x3c};
            
            //byte [][] expanded_key = t.KeyExpansion(key);
            System.out.println ("-------------------");
            //System.out.println ((t.InvCipher(state, 10, expanded_key)).toHexString());
            System.out.println ("-------------------");


        }

    }
}
