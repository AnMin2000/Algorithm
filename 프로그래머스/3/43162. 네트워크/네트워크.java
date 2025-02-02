import java.util.*;
class Solution {
    static int ctn = 0;
    static int[][] arr;
    static boolean[] visit;
    static int len;
    public int solution(int n, int[][] computers) {
        ctn = n;
        arr = computers;
        visit = new boolean[arr.length];
        len = arr.length;
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                dfs(i);
            }
        }

        return ctn;
    }
    static void dfs(int start){
        visit[start] = true;
       
        for(int i = 0; i < arr.length; i++){
            if(!visit[i] && (arr[start][i] == 1 || arr[i][start] == 1) && start != i){
                 ctn--;
                dfs(i);
            }
        }
    }
}