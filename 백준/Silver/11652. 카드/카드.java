import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Map<Long, Integer> map = new HashMap<>();
        
        int max = 0;
        for(int i = 0; i < n; i++) {
            long tmp = Long.parseLong(br.readLine());
            int num = map.getOrDefault(tmp, 0) + 1;
            max = Math.max(num, max);
            map.put(tmp, num);
        }
        List<Long> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        
        for(long a : list){
            if(map.get(a) == max) {
                System.out.println(a);
                break;
            }
        }

    }
}