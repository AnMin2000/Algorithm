import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Map<String, Integer> map = new HashMap<>();
        
        int max = 0;
        for(int i = 0; i < n; i++) {
            String tmp = br.readLine();
            max = Math.max(max, map.getOrDefault(tmp, 0) + 1);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        
        list.sort((o1, o2) -> map.get(o2) - map.get(o1));
        
        List<String> tmp = new ArrayList<>();
        
        for(String key : list) {
        	if(max == map.get(key)) {
        		max = map.get(key);
        		tmp.add(key);
        	}
        	else break;
        }
        Collections.sort(tmp);
        System.out.println(tmp.get(0));
    }
}