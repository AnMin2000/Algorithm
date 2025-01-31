import java.util.*;

class Solution {
    static boolean[] visit;
    static String[][] arr;
    static String[] answer;
    static boolean state = false;
    public String[] solution(String[][] tickets) {
        
        visit = new boolean[tickets.length];
        Arrays.sort(tickets, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2){
                return o1[1].compareTo(o2[1]);
            }
        });
        arr = tickets;
        answer = new String[tickets.length + 1];
        
        Stack<String> stack = new Stack<>();
        stack.push("ICN");

        dfs(stack);
        return answer;
    }
    static void dfs(Stack<String> stack){
       if(stack.size() == arr.length + 1){
           int index = 0;
           for(String s : stack) answer[index++] = s;
           state = true;
       }
        
        for(int i = 0; i < arr.length; i++){
            if(!visit[i] && arr[i][0].equals(stack.peek())){
                
                visit[i] = true;
                stack.push(arr[i][1]);
                dfs(stack);
                if(state) return;
                stack.pop();
                visit[i] = false;
            }
        }
    }
}