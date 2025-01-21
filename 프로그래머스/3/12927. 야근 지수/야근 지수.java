import java.util.*;

class Solution {


    public long solution(int n, int[] works) {

        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });

        for(int work: works) {
            pq.offer(work);
        }

        // 우선 순위 큐? 제일 큰 값을 줄여나가면 된다.
        // 최댓값을 추출해서 1을 제거해준다.
        while(n>0) {
            int value = pq.poll();
            pq.offer(value > 0 ? value - 1 : value);

            n--;
        }

        for(int value: pq) {
            if(value == 0) {
                continue;
            }
            answer += Math.pow(value,2);
        }

        return answer;
    }
}