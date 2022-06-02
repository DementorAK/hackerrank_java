import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        java.security.MessageDigest mDigest = null;
        try {
            mDigest = java.security.MessageDigest.getInstance("SHA-256");
        } catch(Exception e) {}

        mDigest.update(input.getBytes());
        byte[] digest = mDigest.digest();
        StringBuilder sb = new StringBuilder(digest.length*2);
        for (int i = 0; i < digest.length; i++) {
            String numHex = Integer.toHexString(0xff & digest[i]);
            if (numHex.length() == 1) sb.append('0');
            sb.append(numHex);
        }

        System.out.println(sb.toString());
    }
}
