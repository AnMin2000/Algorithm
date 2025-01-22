import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Map<Integer, Integer> map = new LinkedHashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) map.put(i, Integer.parseInt(st.nextToken()));
        
        List<Integer> list = new ArrayList<>(map.keySet());
       Collections.sort(list, new Comparator<Integer>(){
           @Override
           public int compare(Integer o1, Integer o2){
               return map.get(o1) - map.get(o2);
           }
       });

        int[] result = new int[n];

        int prev = Integer.MIN_VALUE;
        int count = 0;
       for(int key : list){
           int current = map.get(key);
           if(prev == current) result[key] = count - 1;
           else {
               result[key] = count++;
               prev = current;
           }
       }

        StringBuilder sb = new StringBuilder();
       for(int i = 0; i < n; i++) sb.append(result[i]).append(" ");

       System.out.println(sb.toString());
        
        
    }
}