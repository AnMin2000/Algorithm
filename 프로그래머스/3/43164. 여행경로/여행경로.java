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
        
        List<String> list = new ArrayList<>();
        list.add("ICN");

        dfs(list);
        return answer;
    }
    static void dfs(List<String> list){
       if(list.size() == arr.length + 1){
           for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
           state = true;
       }
        
        for(int i = 0; i < arr.length; i++){
            if(!visit[i] && arr[i][0].equals(list.get(list.size() - 1))){
                
                visit[i] = true;
                list.add(arr[i][1]);
                dfs(list);
                if(state) return;
                list.remove(list.size() - 1);
                visit[i] = false;
            }
        }
    }
}