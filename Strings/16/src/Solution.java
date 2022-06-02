import java.util.Scanner;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        if (k >= s.length()){
            smallest = s;
            largest = s;
        } else {
            smallest = s.substring(0,k);
            largest = s.substring(0,k);
            for (int i = 1; i <= s.length()-k; i++) {
                String currenString = s.substring(i, k+i);
                if (smallest.compareTo(currenString)>0) {
                    smallest = currenString;
                }
                if (largest.compareTo(currenString)<0) {
                    largest = currenString;
                }
            }
        }

        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}