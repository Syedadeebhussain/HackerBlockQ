import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        BinaryTree bt = new BinaryTree(arr);
        bt.topview();
    }
}

class BinaryTree {
    private class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    BinaryTree(String[] arr) {
        Queue<Node> queue = new LinkedList<>();
        construct(arr, queue);
    }

    private void construct(String[] arr, Queue<Node> queue) {
        if (arr.length == 0 || arr[0].equals("-1")) return;

        root = new Node(Integer.parseInt(arr[0]));
        queue.add(root);

        int i = 1;
        while (i < arr.length) {
            Node parent = queue.poll();
            if (parent == null) continue;

            if (i < arr.length && !arr[i].equals("-1")) {
                parent.left = new Node(Integer.parseInt(arr[i]));
                queue.add(parent.left);
            }
            i++;

            if (i < arr.length && !arr[i].equals("-1")) {
                parent.right = new Node(Integer.parseInt(arr[i]));
                queue.add(parent.right);
            }
            i++;
        }
    }

    public void topview() {
        verticalTraversalTop(this.root);
    }

    private void verticalTraversalTop(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        vertical(root, 0, map);
        for (int i : map.keySet()) {
            System.out.print(map.get(i) + " ");
        }
        System.out.println();
    }

    public void vertical(Node root, int curr, TreeMap<Integer, Integer> map) {
        if (root == null) return;

        if (!map.containsKey(curr)) {
            map.put(curr, root.data);
        }

        vertical(root.left, curr - 1, map);
        vertical(root.right, curr + 1, map);
    }

    public void display() {
        display_tree(root);
    }

    private void display_tree(Node root) {
        if (root == null) return;

        String str = (root.left != null ? root.left.data : "END") + " <= " + root.data + " => " +
                     (root.right != null ? root.right.data : "END");

        System.out.println(str);

        display_tree(root.left);
        display_tree(root.right);
    }
}
