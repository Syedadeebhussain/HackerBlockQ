import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt(); 
        int N = sc.nextInt(); 

        ListNode[] lists = new ListNode[K];

        
        for (int i = 0; i < K; i++) {
            ListNode dummy = new ListNode();
            ListNode curr = dummy;
            for (int j = 0; j < N; j++) {
                int val = sc.nextInt();
                curr.next = new ListNode(val);
                curr = curr.next;
            }
            lists[i] = dummy.next;
        }

        ListNode merged = mergeKLists(lists);
        printList(merged);
    }

    static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
			@Override
			public int compare(ListNode o1 ,ListNode o2){
				return o1.val-o2.val;
			}
		});
        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            dummy.next = node;
            dummy = dummy.next;

            if (node.next != null) pq.add(node.next);
        }

        return temp.next;
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
