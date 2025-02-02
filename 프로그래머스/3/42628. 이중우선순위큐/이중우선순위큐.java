import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        // 최소값 큐
        PriorityQueue<Integer> minQue = new PriorityQueue<>();
        // 최대값 큐
        PriorityQueue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder());
        // 연산 반복 
        for(String o : operations){
            // 삽입
            if(o.startsWith("I")){
                // 숫자를 뽑아서 최소값 큐, 최대값 큐에 넣는다 
                int num = Integer.parseInt(o.split(" ")[1]);
                maxQue.offer(num);
                minQue.offer(num);
            
            // 삭제
            }else{
                // 비어있지 않으면, 최소값 삭제 
                if(o.equals("D -1") && !minQue.isEmpty() ){ 
                    int num = minQue.poll();
                    maxQue.remove(num);
                }
                // 비어있지 않으면, 최대값 삭제
                else if(o.equals("D 1") && !maxQue.isEmpty()){ 
                    int num = maxQue.poll();
                    minQue.remove(num);
                }
            }
        }
        
        // 큐 사이즈가 0이면
        if(minQue.size()==0){
            return new int[]{0,0};
        // 큐 사이즈가 1이면
        }else if(minQue.size()==1){
            int num = minQue.poll();
            return new int[]{num,num};
        // 큐 사이즈가 2이상
        }else{
            int max = maxQue.poll();
            int min = minQue.poll();
            return new int[]{max,min};
        }
    }
}