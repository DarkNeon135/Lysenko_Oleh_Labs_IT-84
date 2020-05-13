package Lab6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lab6 {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String encryptStr = encrypt("qewqeqw56", (char) 1);
        System.out.println("Encrypted String: " + encryptStr);
        String decryptStr = decrypt(encryptStr, (char) 1);
        System.out.println("Decrypted String: " + decryptStr);
    }

    public static String encrypt(String str, char a) {
        StringBuilder sb = new StringBuilder();
        for (Character b : str.toCharArray()) {
            char result = (b + a) > Character.MAX_VALUE ? Character.MAX_VALUE : (char)(a + b);
            sb.append(result);
        }
        return sb.toString();
    }

    public static String decrypt(String str, char a) {
        StringBuilder sb = new StringBuilder();
        for (Character b : str.toCharArray()) {
            char result = b - a < 0 ? (char) 0 : (char)(b - a);
            sb.append(result);
        }
        return sb.toString();
    }

}


