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
            //System.out.println(encrypted);

            // -------- Below is for testing using byte arrays -----------

            Encrypt t = new Encrypt("", "");
            
            byte[] state = new byte[] {0x32, 0x43, (byte)0xf6, (byte)0xa8, (byte)0x88, 0x5a, 0x30, (byte)0x8d, 0x31, 0x31, (byte)0x98, (byte)0xa2, (byte)0xe0, 0x37, 0x07, 0x34};
            byte[] key = new byte[]{0x2b, 0x7e, 0x15, 0x16, 0x28, (byte)0xae, (byte)0xd2, (byte)0xa6, (byte)0xab, (byte)0xf7, 0x15, (byte)0x88, 0x09, (byte)0xcf, 0x4f, 0x3c};
            
            byte [][] expanded_key = t.KeyExpansion(key);
            System.out.println ("-------------------");
            System.out.println ((t.Cipher(state, 10, expanded_key)).toHexString());
            System.out.println ("-------------------");

        } else if (args[0].equals("decrypt")){
           
        }

    }
}
