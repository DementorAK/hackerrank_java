import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        java.security.MessageDigest mDigest = null;
        try {
            mDigest = java.security.MessageDigest.getInstance("MD5");
        } catch(Exception e) {}

        mDigest.update(input.getBytes());
        byte[] digest = mDigest.digest();
        String hash = (new java.math.BigInteger(1, digest)).toString(16);
        while(hash.length() < 32 ){
            hash = "0"+hash;
        }

        System.out.println(hash);

    }
}
