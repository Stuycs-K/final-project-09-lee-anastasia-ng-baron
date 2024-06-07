public class Driver {
    public static void main (String [] args){
        
        String s1 = "abcdefghijklmnop";
        String s2 = "abcdefghijklmnopqrstuvwxyzabcdef";
        
        //System.out.println (s1.length() + " " + s2.length());
        if (args[1] != null && args[2] != null){
            s1 = args[1];
            while (s1.length() % 16 != 0) {
                s1 += " ";
            }

            if (args[2].length() == 32){
                s2 = args[2];
            } else {
                System.out.println ("The Key is not the correct length of 32: " + args[2]);
                return;
            }
        }

        if (args[0].equals("encrypt")){
            String encrypted = "";
            for (int i = 0; i < s1.length(); i+=16) { // encrypts for each block of 16 bytes
                Encrypt t = new Encrypt(s1.substring(i, i+16), s2);
                encrypted += t.AES256(s1.substring(i, i+16), s2).toSuperString();
                // System.out.println (t.AES256(s1, s2));
                // System.out.println (t.AES256(s1, s2).toSuperString());
            }
            System.out.println(encrypted);

            // -------- Below is for testing using byte arrays -----------
            // Encrypt t = new Encrypt("", "");
            byte[] state = new byte[]{0x32, 0x43, (byte)0xf6, (byte)0xa8, (byte)0x88, 0x5a, 0x30, (byte)0x8d, 0x31, 0x31, (byte)0x98, (byte)0xa2, (byte)0xe0, 0x37, 0x07, 0x34};
            byte[] key = new byte[]{0x60, 0x3d, (byte)0xeb, 0x10, 0x15, (byte)0xca, 0x71, (byte)0xbe, 0x2b, 0x73, (byte)0xae, (byte)0xf0, (byte)0x85, 0x7d, 0x77, (byte)0x81, 0x1f, 0x35, 0x2c, 0x07, 0x3b, 0x61, 0x08, (byte)0xd7, 0x2d, (byte)0x98, 0x10, (byte)0xa3, 0x09, 0x14, (byte)0xdf, (byte)0xf4};
            //System.out.println (t.AES256(state,key).toHexString());
        } else if (args[0].equals("decrypt")){
           
        }

    }
}
