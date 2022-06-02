import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {

        if (a.length()!=b.length()) return false;

        java.util.List<Character> list_a = a.chars().
                mapToObj(item->(char)item).
                map(Character::toUpperCase).
                sorted().
                collect(java.util.stream.Collectors.toList());
        java.util.List<Character> list_b = b.chars().
                mapToObj(item->(char)item).
                map(Character::toUpperCase).
                sorted().
                collect(java.util.stream.Collectors.toList());

        for (int i = 0; i < a.length(); i++) {
            if (!list_a.get(i).equals(list_b.get(i))){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
