import java.util.*;

public class Main {
    public static void main(String[] args) {
        CreateTreeLevel tree = new CreateTreeLevel();
        tree.display();
    }
}

class Node {
    int val;
    Node left;
    Node right;
}

class CreateTreeLevel {
    private Node root;

    public CreateTreeLevel() {
        createTree();
    }

    private void createTree() {
        Scanner sc = new Scanner(System.in);
        Queue<Node> q = new LinkedList<>();
        int n = sc.nextInt();
        Node nn1 = new Node();
        nn1.val = n;
        root = nn1;
        q.add(nn1);

        while (!q.isEmpty()) {
            Node rv = q.poll();
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            if (c1 != -1) {
                Node nn = new Node();
                nn.val = c1;
                rv.left = nn;
                q.add(nn);
            }
            if (c2 != -1) {
                Node nn = new Node();
                nn.val = c2;
                rv.right = nn;
                q.add(nn);
            }
        }
    }

public void display(){
	displayLeaves(root);
}
private void displayLeaves(Node node) {
        if (node == null) {
            return;
        }
       
        if (node.left == null && node.right == null) {
            System.out.print(node.val + " ");
        }
        displayLeaves(node.left);
        displayLeaves(node.right);
    }
}
