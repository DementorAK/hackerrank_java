import java.util.*;
import java.util.regex.*;

public class Solution{
    public static void main(String[] args){

        Pattern pattern = Pattern.compile("<(.+)>([^<>]*)</\\1>");

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();

            Matcher matcher = pattern.matcher(line);

            String content = "";
            while (matcher.find()) {
                String str = matcher.group(2);
                if(!str.isEmpty()){
                    content += str + '\n';
                }
            }

            if (content.isEmpty()) content = "None\n";
            System.out.print(content);

            testCases--;
        }
        in.close();
    }
}