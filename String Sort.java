import java.util.*;
public class Main {
    public static void main(String args[]) {
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	String [] arr=new String[n];
	for(int i=0;i<n;i++){
		arr[i]=sc.next();
	}
	PriorityQueue<String> pq=new PriorityQueue<>(
	(a,b)->a.startsWith(b) || b.startsWith(a)?b.length()-a.length():a.compareTo(b)
	);
	for(int i=0;i<n;i++){
		pq.add(arr[i]);
	}
	while(!pq.isEmpty()){
		System.out.println(pq.poll());
	}

    }
}