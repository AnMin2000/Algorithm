import java.util.*;
class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end - begin + 1)];

        int k = 0;
        for(int i = (int)begin; i <= (int)end; i++){
            if(i == 1) {
                answer[k++] = 0;
                continue;
            }
            int max = 0;
            for(int j = 2; j <= (int)Math.sqrt(i); j++){
                
                if(i % j == 0) {
                    max = Math.max(max, j);
                    
                    if(i / j <= 10000000){
                        answer[k] = i / j;
                        break;
                    }
                    
                }
            }
            if(answer[k] == 0) answer[k] = Math.max(1, max);
            k++;
        }
        return answer;
    }
}