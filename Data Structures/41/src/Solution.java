import java.io.*;
import java.util.*;

public class Solution {

    static class Calculation{
        BitSet b1, b2;
        Calculation(int size){
            b1 = new BitSet(size);
            b2 = new BitSet(size);
        }
        void add(int numb1, int numb2){
            BitSet operator1 = numb1==1?b1:b2;
            BitSet operator2 = numb2==1?b1:b2;
            operator1.and(operator2);
        }
        void or(int numb1, int numb2){
            BitSet operator1 = numb1==1?b1:b2;
            BitSet operator2 = numb2==1?b1:b2;
            operator1.or(operator2);
        }
        void xor(int numb1, int numb2){
            BitSet operator1 = numb1==1?b1:b2;
            BitSet operator2 = numb2==1?b1:b2;
            operator1.xor(operator2);
        }
        void flip(int numb1, int index){
            BitSet operator1 = numb1==1?b1:b2;
            operator1.flip(index);
        }
        void set(int numb1, int index){
            BitSet operator1 = numb1==1?b1:b2;
            operator1.set(index);
        }
        public void print() {
            System.out.printf("%d %d%n", b1.cardinality(), b2.cardinality());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        Calculation calculation = new Calculation(size);

        int numberOperations = scanner.nextInt();
        for (int i = 0; i < numberOperations; i++) {
            scanner.nextLine(); // skip end of line
            String operation = scanner.next("\\w+\\b");
            switch (operation) {
                case "AND": {
                    calculation.add(scanner.nextInt(), scanner.nextInt());
                    break;
                }
                case "OR": {
                    calculation.or(scanner.nextInt(), scanner.nextInt());
                    break;
                }
                case "XOR": {
                    calculation.xor(scanner.nextInt(), scanner.nextInt());
                    break;
                }
                case "FLIP": {
                    calculation.flip(scanner.nextInt(), scanner.nextInt());
                    break;
                }
                case "SET": {
                    calculation.set(scanner.nextInt(), scanner.nextInt());
                    break;
                }
            }
            calculation.print();
        }
        scanner.close();
    }
}