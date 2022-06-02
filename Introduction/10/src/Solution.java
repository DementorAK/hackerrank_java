import java.util.*;

public class Solution {

    static byte B,H;
    static short area=0;
    static boolean flag = true;

    static {
        Scanner scanner = new Scanner(System.in);
        B = scanner.nextByte();
        H = scanner.nextByte();
        scanner.close();

        if(B<=0 || H<=0)
            try {
                flag = false;
                throw new Exception("Breadth and height must be positive");
            } catch (Exception e) {
                System.out.print(e);
            }
    }

    public static void main(String[] args){
        if(flag){
            int area=B*H;
            System.out.print(area);
        }

    }//end of main

}//end of class
