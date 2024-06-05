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
            for (int i = 0; i < s1.length(); i+=16) {
                Encrypt t = new Encrypt(s1.substring(i, i+16), s2);
                encrypted += t.AES256(s1.substring(i, i+16), s2).toSuperString();
                // System.out.println (t.AES256(s1, s2));
                // System.out.println (t.AES256(s1, s2).toSuperString());
            }
            System.out.println(encrypted);
        } else if (args[0].equals("decrypt")){
           
        }

    }
}
