import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Main {
    public static TreeNode buildTree(List<Integer> values) {
        if (values.isEmpty() || values.get(0) == -1)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(values.get(0));
        queue.add(root);
        int index = 1;

        while (!queue.isEmpty() && index < values.size()) {
            TreeNode node = queue.poll();

            if (index < values.size() && values.get(index) != -1) {
                node.left = new TreeNode(values.get(index));
                queue.add(node.left);
            }
            index++;

            if (index < values.size() && values.get(index) != -1) {
                node.right = new TreeNode(values.get(index));
                queue.add(node.right);
            }
            index++;
        }

        return root;
    }

    // You need to implement this function to return a list of lists representing 
    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> ll=new ArrayList<>();

        if (root == null) return ll;
        Queue<TreeNode> q=new LinkedList<>();
         q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> st=new ArrayList<>();
           for(int i=0;i<size;i++){
               TreeNode r=q.remove();
            st.add(r.val);
            if(r.left!=null){
                q.add(r.left);
            }
            if(r.right!=null){
                 q.add(r.right);
            }
           }
           ll.add(st);
            }
            return ll;
        }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> values = new ArrayList<>();

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                values.add(scanner.nextInt());
            } else if (scanner.next().equalsIgnoreCase("done")) {
                break;
            }
        }

        TreeNode root = buildTree(values);
        List<List<Integer>> levels = levelOrderTraversal(root);

        for (List<Integer> level : levels) {
            for (int n : level) {
                System.out.print(n + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
