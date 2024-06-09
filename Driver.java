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
        
        // if (args[1] != null && args[2] != null){
        //     s1 = args[1];
        //     while (s1.length() % 16 != 0) {
        //         s1 += " ";
        //     }

        //     if (args[2].length() == 32){
        //         s2 = args[2];
        //     } else {
        //         System.out.println ("The Key is not the correct length of 32: " + args[2]);
        //         return;
        //     }
        // }

        if (args[0].equals("encrypt")){
            String encrypted = "";
            for (int i = 0; i < s1.length(); i+=16) { // encrypts for each block of 16 bytes
                Encrypt t = new Encrypt(s1.substring(i, i+16), s2);
                encrypted += t.AES256(s1.substring(i, i+16), s2).toSuperString();
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
