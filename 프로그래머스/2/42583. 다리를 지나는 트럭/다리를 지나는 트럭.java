import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < truck_weights.length; i++) queue.offer(truck_weights[i]);
        
        int len = truck_weights.length;
        int check = truck_weights.length;
        int[] bridge = new int[bridge_length];
        
        int time = 0;
        int wei = 0;
        
        while(check != 0){
            time++;
            if(bridge[bridge_length - 1] > 0) {
                wei -= bridge[bridge_length - 1];
                check--;
            }
            
            for(int i = bridge_length - 1; i >= 1; i--) {
                bridge[i] = bridge[i - 1];
            }
            
            if(!queue.isEmpty() && wei + queue.peek() <= weight){
                bridge[0] = queue.poll();
                wei += bridge[0];
            }
            else bridge[0] = 0;

        }
        return time;
    }
}