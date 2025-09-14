import java.util.*;

class Main { // Changed from Main4 to Main

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        Main m = new Main();
        BinaryTree bt1 = m.new BinaryTree();
        System.out.println(bt1.levelArrayList());
    }

    private class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
        }

        private Node root;
        private int size;

        public BinaryTree() {
            this.root = this.takeInput(null, false);
        }

        public Node takeInput(Node parent, boolean ilc) {
            int cdata = scn.nextInt();
            Node child = new Node();
            child.data = cdata;
            this.size++;

            boolean hlc = scn.nextBoolean();
            if (hlc) {
                child.left = this.takeInput(child, true);
            }

            boolean hrc = scn.nextBoolean();
            if (hrc) {
                child.right = this.takeInput(child, false);
            }

            return child;
        }

        public ArrayList<ArrayList<Integer>> levelArrayList() {
            ArrayList<ArrayList<Integer>> ll = new ArrayList<>();
            if (root == null) return ll;

            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                int levelSize = q.size();
                ArrayList<Integer> st = new ArrayList<>();

                for (int i = 0; i < levelSize; i++) {
                    Node r = q.remove();
                    st.add(r.data);

                    if (r.left != null) {
						q.add(r.left);
					}
                    if (r.right != null) {
						q.add(r.right);
					}
                }
                ll.add(st);
            }
            return ll;
        }
    }
}
