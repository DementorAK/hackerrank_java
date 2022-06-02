import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberRows = scanner.nextInt();
        List<List<Integer>> matrix = new ArrayList<>(numberRows);
        for (int i = 0; i < numberRows; i++) {
            int numberColumns = scanner.nextInt();
            List<Integer> row = new ArrayList<>(numberColumns);
            for (int j = 0; j < numberColumns; j++) {
                row.add(scanner.nextInt());
            }
            matrix.add(row);
        }

        int numberQueries = scanner.nextInt();
        for (int i = 0; i < numberQueries; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (x > numberRows) {
                System.out.println("ERROR!");
                continue;
            }
            List<Integer> row = matrix.get(x-1);
            if (y > row.size()) {
                System.out.println("ERROR!");
                continue;
            }
            System.out.println(row.get(y-1));
        }
    }
}