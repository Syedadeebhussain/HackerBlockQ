import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int[] ans = new int[m * n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(int i = 0; i < m; i++){
            pq.add(new Pair(arr[i][0], i, 0));
        }

        int j = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            ans[j++] = p.val;

            if (p.col + 1 < arr[p.row].length){
                pq.add(new Pair(arr[p.row][p.col + 1], p.row, p.col + 1));
            }
        }

        for(int x : ans){
            System.out.print(x + " ");
        }
    }
}

class Pair {
    int val;
    int row;
    int col;
    Pair(int val, int row, int col){
        this.val = val;
        this.row = row;
        this.col = col;
    }
}



 