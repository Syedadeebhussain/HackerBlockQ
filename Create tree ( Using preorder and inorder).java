import java.util.*;

public class Main {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        Main m = new Main();
        int n = scn.nextInt(); // read size once
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = scn.nextInt();
        }
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            in[i] = scn.nextInt();
        }

        BinaryTree bt = m.new BinaryTree(pre, in);
        bt.display();
    }

    private class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
        }

        private Node root;

        public BinaryTree(int[] pre, int[] in) {
            this.root = this.construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
        }

        private int find(int[] arr, int si, int ei, int item) {
            for (int i = si; i <= ei; i++) {
                if (arr[i] == item) return i;
            }
            return -1;
        }

        private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {
            if (ilo > ihi || plo > phi) {
                return null;
            }

            Node nn = new Node();
            nn.data = pre[plo];

            int idx = find(in, ilo, ihi, pre[plo]);
            int count = idx - ilo;

            nn.left = construct(pre, plo + 1, plo + count, in, ilo, idx - 1);
            nn.right = construct(pre, plo + count + 1, phi, in, idx + 1, ihi);

            return nn;
        }

        public void display() {
            display(this.root);
        }

        private void display(Node node) {
           if (root == null) return ;

            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                    Node r = q.remove();
                    // st.add(r.data);
					System.out.print(r.data+" ");

                    if (r.left != null) {
						q.add(r.left);
					}
                    if (r.right != null) {
						q.add(r.right);
					}
        }
    }
}}
