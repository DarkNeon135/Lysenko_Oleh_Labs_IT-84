package Lab6;

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        char[] WhatToEncrypt = {'l','a','b','a','p','o','j','a','b','e'};
        char[] decrypted = new char[10];
        System.out.println("What To Encrypt: " + String.valueOf(WhatToEncrypt));
        try(CustomWriter customWriter = new CustomWriter(new FileWriter("enc.txt"),'5')) {

            customWriter.write(WhatToEncrypt);
            customWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
            FileReader fr = new FileReader("enc.txt");
            char[] encrypted = new char[10];
            fr.read(encrypted);

        try(CustomReader customReader = new CustomReader(new FileReader("enc.txt"), '5')) {

             customReader.read(decrypted);
                FileWriter dw = new FileWriter("dec.txt");
             dw.write(decrypted);
                dw.flush();
                 dw.close();
}
catch (IOException e){
    e.printStackTrace();
}
           System.out.println("Encrypted: " + String.valueOf(encrypted));
           System.out.println("Decrypted: " + String.valueOf(decrypted));




    }
}
