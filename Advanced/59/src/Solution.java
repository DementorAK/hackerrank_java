import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {

    private int sumLeaves = 0;

    public int getResult() {
        return sumLeaves;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        sumLeaves += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {

    private long result = 1;
    private final int M = 1000000007;

    public int getResult() {
        return (int) result;
    }

    public void visitNode(TreeNode node) {
        if(node.getColor().equals(Color.RED)) {
            result = (result * node.getValue()) % M;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if(leaf.getColor().equals(Color.RED)) {
            result = (result * leaf.getValue()) % M;
        }
    }
}

class FancyVisitor extends TreeVis {

    private int sumEvenNodes = 0;
    private int sumGreenLeaves = 0;

    public int getResult() {
        return Math.abs(sumEvenNodes-sumGreenLeaves);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() == 0 || node.getDepth() % 2 == 0)
            sumEvenNodes += node.getValue();
    }

    public void visitLeaf(TreeLeaf leaf) {
        if(leaf.getColor()==Color.GREEN)
            sumGreenLeaves += leaf.getValue();
    }
}

public class Solution {

    static int[] values;
    static Color[] colors;

    static Map<Integer, Set> allNodes;

    static void constructEnge(int start, Tree startNode, int parent){
        if(startNode instanceof TreeLeaf){
            return;
        }
        Iterator<Integer> neighburs = allNodes.get(start).iterator();
        while (neighburs.hasNext()) {
            int end = neighburs.next();
            if(end == parent) continue;
            constructEnge(end, createNode(startNode, end), start);
        }
    }

    static Tree createNode(Tree parent, int child){
        TreeNode parentNode = (TreeNode) parent;
        if (allNodes.get(child).size()>1){
            TreeNode newNode = new TreeNode(values[child], colors[child], parentNode.getDepth()+1);
            parentNode.addChild(newNode);
            return newNode;
        } else {
            TreeLeaf newLeaf = new TreeLeaf(values[child], colors[child], parentNode.getDepth()+1);
            parentNode.addChild(newLeaf);
            return newLeaf;
        }
    }

    public static Tree solve() {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        values = new int [n];
        colors = new Color [n];

        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            colors[i] = (scanner.nextInt()==0?Color.RED:Color.GREEN);
        }

        allNodes = new HashMap<Integer, Set>(n);
        for (int i = 0; i < n-1; i++) {
            scanner.nextLine();
            int node1 = scanner.nextInt()-1;
            int node2 = scanner.nextInt()-1;
            if(!allNodes.containsKey(node1))
                allNodes.put(node1, new HashSet<Integer>());
            allNodes.get(node1).add(node2);
            if(!allNodes.containsKey(node2))
                allNodes.put(node2, new HashSet<Integer>());
            allNodes.get(node2).add(node1);
        }

        scanner.close();

        Tree result = new TreeNode(values[0], colors[0], 0);
        constructEnge(0, result, 0);
        return result;

    }


    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}