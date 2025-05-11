import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[0] = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        while(!deque.isEmpty()){
            int q = deque.poll();
            if(q != 0 && ans[q-1] == -1){
                ans[q-1] = ans[q] + 1;
                deque.offer(q-1);
            }
            if(q + 1 < n && ans[q+1] == -1){
                ans[q+1] = ans[q] + 1;
                deque.offer(q+1);
            }
            if(ans[arr[q] - 1] == -1){
                ans[arr[q] - 1] = ans[q] + 1;
                deque.offer(arr[q] - 1);
            }
        }
        for(int i = 0 ; i < n ; i++) System.out.print(ans[i] + " ");
    }
}
