import java.util.*;
class Solution {
    static int[] arr;
    static int count = 0;
    static int len;
    static boolean[] visit;
    public int solution(int[] cards) {
        
        arr = cards;
        List<Integer> list = new ArrayList<>();
        len = cards.length;

        visit = new boolean[len];
        for(int i = 0; i < len; i++){
            if(!visit[i]){
                dfs(i);
                list.add(count);
                count = 0;
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        if(list.size() == 1) return 0;
        return list.get(0) * list.get(1);
    }
    static void dfs(int start){
        count++;
        visit[start] = true;
        if(!visit[arr[start] - 1]){
            dfs(arr[start] - 1);
        }
    }
}