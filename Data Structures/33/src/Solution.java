import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        List<Integer> list = new ArrayList<>(number);
        for (int i = 0; i < number; i++) {
            list.add(scanner.nextInt());
        }

        number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            scanner.nextLine();
            String command = scanner.nextLine();
            if (command.equals("Insert")){
                int index = scanner.nextInt();
                int value = scanner.nextInt();
                list.add(index, value);
            } else if (command.equals("Delete")) {
                int index = scanner.nextInt();
                list.remove(index);
            }
        }

        scanner.close();
        System.out.println(list.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }
}