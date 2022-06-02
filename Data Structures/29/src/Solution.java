import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Hourglass{
    List<List<Integer>> data;
    Hourglass(List<List<Integer>> data){
        this.data = data;
    }
    int calculate(){
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result = Math.max(result, getSum(i,j));
            }
        }
        return result;
    }
    int getSum(int x, int y){
        return data.get(x).get(y) +
                data.get(x).get(y+1) +
                data.get(x).get(y+2) +
                data.get(x+1).get(y+1) +
                data.get(x+2).get(y) +
                data.get(x+2).get(y+1) +
                data.get(x+2).get(y+2);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

        System.out.println(new Hourglass(arr).calculate());

    }
}
