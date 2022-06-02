import java.util.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            // calculation and output
            int member = a;
            for (int j = 0; j < n; j++) {
                member += b * Math.pow(2, j);
                System.out.print(""+member+" ");
            }
            System.out.println();
        }
        in.close();
    }
}