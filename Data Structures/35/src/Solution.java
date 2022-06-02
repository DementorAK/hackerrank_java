import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

class Solution{

    public static void main(String []argh)
    {
        Stack<Character> stack = new Stack<>();

        Function<Character,Boolean> isOpen  =
                (ch) -> ch.equals('(')||ch.equals('[')||ch.equals('{');
        Function<Character,Boolean> isClose =
                (ch) -> ch.equals(')')||ch.equals(']')||ch.equals('}');
        BiFunction<Character,Character,Boolean> isMatch =
            (ch1, ch2) -> ch1.equals('(')&&ch2.equals(')')
                    ||ch1.equals('[')&&ch2.equals(']')
                    ||ch1.equals('{')&&ch2.equals('}');

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input=sc.next();
            stack.clear();
            boolean balanced = true;
            for (Character ch: input.toCharArray()) {
                if (isOpen.apply(ch)) {
                    stack.push(ch);
                } else if (isClose.apply(ch)) {
                    if (stack.size()==0)
                        balanced = false;
                    else {
                        Character prevCh = stack.pop();
                        if (!isMatch.apply(prevCh, ch))
                            balanced = false;
                    }
                }
            }
            if (stack.size()>0) balanced = false;
            System.out.println(balanced);
        }
        sc.close();
    }
}
