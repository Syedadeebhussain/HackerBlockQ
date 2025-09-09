import java.util.*;
public class Main {
    public static void main(String args[]) {
	   Scanner sc=new Scanner(System.in);
       int first = sc.nextInt(); 
	  while(first-->0){
        int n = sc.nextInt();       
        Set<Integer> st=new HashSet<>();   
        for (int i = 0; i < n; i++) {
            st.add(sc.nextInt()); 
        }
       int n1=sc.nextInt();
	    for(int i=0;i<n1;i++){
		   int a =sc.nextInt();
		   if(st.contains(a)){
			   System.out.println("Yes");
		   }
		   else{
			   System.out.println("No"); 
		   }
	   }
	  }  
              
    }
}