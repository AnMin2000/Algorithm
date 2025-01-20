import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        if(s / n == 0) return new int[]{-1};
        
        int n1 = s / n;
        int n2 = s % n;
        
        int[] answer = new int[n];
        Arrays.fill(answer, n1);
        
        int i = n - 1;
        while(n2-->0){
            if(i < 0) i = n - 1;
            answer[i--]++;
        }
        return answer;
    }
}