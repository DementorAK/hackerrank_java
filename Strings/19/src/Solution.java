import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();

        String[] tokens = s.split("[ !,?._'@]+");

        int count = tokens.length;
        if (tokens.length>0 && tokens[0].isEmpty()) count--;
        if (tokens.length>1 && tokens[tokens.length-1].isEmpty()) count--;

        System.out.println(count);
        for (String token : tokens) {
            if(!token.isEmpty())
                System.out.println(token);
        }
    }
}

