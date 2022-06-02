import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int result = 0;
        Set<Integer> unique = new HashSet<>(m);

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            /* First try - got Time limit exceeded
            if (deque.size()==m){
                deque.removeFirst();
            }
            deque.addLast(num);

            unique = (Set<Integer>) deque.stream().collect(Collectors.toSet());
            result = Math.max(result, unique.size());
            */

            if (result == m) continue;

            deque.addLast(num);
            unique.add(num);

            if (deque.size()==m){
                if(unique.size()>result)
                    result = unique.size();
                Integer removed = deque.removeFirst();
                if (!deque.contains(removed))
                    unique.remove(removed);
            }

        }
        System.out.println(result);
    }
}
