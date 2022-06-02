import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        leap = Math.max(leap, 1);
        int winIndex = game.length - leap - 1;

        // checking the ability to reach the end
        int lenghtOnes = 0;
        for (int i = 0; i < game.length; i++) {
            if (game[i]==0) {
                lenghtOnes = 0;
                continue;
            }
            lenghtOnes++;
            if (lenghtOnes==leap) return false;
        }

        /*
        It is necessary to mark the cells where you can jump,
        but from which you can only go backwards. Let it be 2
         */

        int currentPosition = 0;
        int numReversed = 0;
        while (true) {
            if (currentPosition>winIndex) return true;

            if (game[currentPosition]==2) {
                currentPosition--;
                numReversed++;
                continue;
            }

            if (game[currentPosition+leap]==0 || (game[currentPosition+leap]==2 && numReversed<leap)) {
                currentPosition += leap;
                numReversed = 0;
                continue;
            } else if (game[currentPosition+1]==0) {
                currentPosition++;
                numReversed = 0;
                continue;
            }

            if (currentPosition==0)
                return false;

            if (game[currentPosition-1]==1) {
                game[currentPosition] = 1;
                int i = 1;
                while (game[currentPosition+i] == 2) {
                    game[currentPosition + i] = 1;
                    i++;
                }
                // checking the ability to reach the end
                int positionOne = currentPosition-1;
                while (positionOne>0 && game[positionOne-1]==1)
                    positionOne--;
                int countOnes = 0;
                while (positionOne < game.length && game[positionOne]==1){
                    countOnes++; positionOne++;
                }
                if (countOnes>=leap) return false;
                currentPosition = 0;
                numReversed = 0;
            }
            else
                game[currentPosition]=2;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        //File file = new File("input");
        //Scanner scan = new Scanner(file);
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        int counter = 0;
        while (q-- > 0) {
            counter++;
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}