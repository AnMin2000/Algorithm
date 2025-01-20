class Solution {
    static boolean[] visit;
    static int len;
    static int max = 0;
    static int[][] arr;
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        visit = new boolean[len];
        arr = dungeons;
        dfs(0, k);
        
        return max;
    }
    static void dfs(int count, int current){
        max = Math.max(max, count);
        for(int i = 0; i < len; i++){
            if(current >= arr[i][0] && !visit[i]){
                visit[i] = true;
                dfs(count + 1, current - arr[i][1]);
                visit[i] = false;
            }
        }
    }
}