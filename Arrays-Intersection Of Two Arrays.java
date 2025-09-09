import java.util.*;
public class Main {
    public static void main(String args[]) {
        // Your Code Here
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int [] arr=new int [n];
		int [] arr1=new int [n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++){
			arr1[i]=sc.nextInt();
		}
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<n;i++){
			if(map.containsKey(arr[i])){
				map.put(arr[i],map.get(arr[i])+1);
			}
			else{
				map.put(arr[i],1);
			}
		}
		List<Integer> ll=new ArrayList<>();
		for(int i=0;i<n;i++){
			if(map.containsKey(arr1[i]) && map.get(arr1[i])>0){
				ll.add(arr1[i]);
				map.put(arr1[i],map.get(arr[i])-1);
			}
		}
		Collections.sort(ll);
		System.out.println(ll);


    }
}
