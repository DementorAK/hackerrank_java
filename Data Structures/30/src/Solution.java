import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int result = 0;
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
            for (int j = i; j >= 0; j--) {
                int sum = 0;
                for (int k = j; k <= i; k++) {
                    sum += array[k];
                }
                if (sum < 0) result ++;
            }
        }

        scanner.close();
        System.out.println(result);

    }
}