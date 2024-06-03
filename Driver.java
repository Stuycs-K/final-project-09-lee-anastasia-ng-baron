public class Driver {
    public static void main (String [] args){
        
        String s1 = "abcdefghijklmnop";
        String s2 = "abcdefghijklmnopqrstuvwxyzabcdef";
        
        System.out.println (s1.length() + " " + s2.length());

        if (args[1] != null && args[2] != null){
            if (args[1].length() == 16){
                s1 = args[1];
            } else {
                System.out.println ("The Input is not the correct length of 16:" + args[0]);
                return;
            }

            if (args[2].length() == 32){
                s2 = args[2];
            } else {
                System.out.println ("The Input is not the correct length of 32:" + args[1]);
                return;
            }
        }

        if (args[0].equals("encrypt")){
            Encrypt t = new Encrypt(s1, s2);

            System.out.println (t.AES256(s1, s2));
        } else if (args[0].equals("decrypt")){
           
        }

    }
}
