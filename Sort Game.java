import java.util.*;
public class Main {
    public static void main(String args[]) {
        // Your Code Here
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		int n=sc.nextInt();
		Map<String,Integer> map=new HashMap<>();
		for(int i=0;i<n;i++){
			String a=sc.next();
			map.put(a,sc.nextInt());
		}
		PriorityQueue<String>pq=new PriorityQueue<>(
			(a,b)->map.get(a).equals(map.get(b))?a.compareTo(b):map.get(b)-map.get(a)
		);
		for(String i:map.keySet()){
			if(map.get(i)>=x){
				pq.add(i);
			}
		}
		while(!pq.isEmpty()){
			String rv=pq.poll();
			System.out.println(rv+" "+map.get(rv));
		}
    }
}
