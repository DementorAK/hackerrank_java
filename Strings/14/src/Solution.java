import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Solution {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        sc.close();

        System.out.println(A.length()+B.length());
        System.out.println(A.compareTo(B)>0 ? "Yes" : "No");

        Function<String,String> capitalize = str -> str.substring(0, 1).toUpperCase() + str.substring(1);
        System.out.println(capitalize.apply(A)+" "+capitalize.apply(B));
    }
}



