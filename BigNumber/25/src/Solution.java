import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
class Solution{
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        Arrays.sort(s, (a,b)->{
            if(a == null) return  1;
            if(b == null) return -1;
            BigDecimal A = new BigDecimal(a);
            BigDecimal B = new BigDecimal(b);
            if(A.equals(B))
                return - a.compareTo(b);
            return - A.compareTo(B);
        });

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}