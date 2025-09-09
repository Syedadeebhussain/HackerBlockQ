import java.util.*;
public class Main {
    public static void main (String args[]) {
    Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	int [] arr=new int [n];
	int k=sc.nextInt();
	for(int i=0;i<n;i++){
		arr[i]=sc.nextInt();
	}
	PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->a-b);
	for(int i=0;i<k;i++){
		pq.add(arr[i]);
	}
	for(int i=k;i<arr.length;i++){
		if(pq.peek()<arr[i]){
		int r=pq.poll();
			pq.add(arr[i]);
		}
	}
	System.out.println(pq.poll());
    }
}