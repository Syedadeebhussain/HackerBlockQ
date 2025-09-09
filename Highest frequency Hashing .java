import java.util.*;
public class Main {
    public static void main (String args[]) {
	Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
	int [] arr=new int[n];
	for(int i=0;i<n;i++){
		arr[i]=sc.nextInt();
	}
    Map<Integer,Integer> map=new HashMap<>();
	for(int i=0;i<n;i++){
		if(map.containsKey(arr[i])){
			map.put(arr[i],map.get(arr[i])+1);
		}
		else{
			map.put(arr[i],1);
		}
	}
	PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
    pq.addAll(map.keySet());
	System.out.println(pq.peek());
    }
}