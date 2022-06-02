import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lineNumber = 0;
        while(scanner.hasNext())
            System.out.printf("%d "+scanner.nextLine()+"%n",++lineNumber);
        scanner.close();
    }
}