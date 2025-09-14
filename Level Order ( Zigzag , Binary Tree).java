import java.util.*;
public class Main {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		BinaryTree bt = m.new BinaryTree();
		bt.levelOrderZZ();
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

			// left
			boolean hlc = scn.nextBoolean();

			if (hlc) {
				child.left = this.takeInput(child, true);
			}

			// right
			boolean hrc = scn.nextBoolean();

			if (hrc) {
				child.right = this.takeInput(child, false);
			}

			// return
			return child;
		}
        int c=1;
		ArrayList<ArrayList<Integer>> ll = new ArrayList<>();
		public void levelOrderZZ() {
			level(root);
			for (List<Integer> level : ll) {
           for (int val : level) {
        System.out.print(val + " ");
    }
}
		}
		public ArrayList<ArrayList<Integer>> level(Node root){  
	     
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
				if(c%2==0){
					Collections.reverse(st);
				}
				c++;
                ll.add(st);
            }
            return ll;
        }
	}

}
