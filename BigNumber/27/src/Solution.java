import java.io.*;
import java.math.BigDecimal;

public class Solution {

    public static void main(String[] args) {

        BigDecimal A,B;

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String str1 = bufferedReader.readLine();
            String str2 = bufferedReader.readLine();
            bufferedReader.close();
            A = new BigDecimal(str1);
            B = new BigDecimal(str2);
        } catch (IOException e) {
            return;
        }

        System.out.println(A.add(B));
        System.out.println(A.multiply(B));

    }
}