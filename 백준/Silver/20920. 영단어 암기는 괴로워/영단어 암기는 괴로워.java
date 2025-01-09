import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Map<String, Integer> map = new HashMap<>();
        
        while(n-->0) {
        	String tmp = br.readLine();
        	if(tmp.length() < m) continue;
        	map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        
        List<String> key = new ArrayList<>(map.keySet());
        
        Collections.sort(key, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
            	if(o1.length() == o2.length() && map.get(o1) == map.get(o2)) return o1.compareTo(o2); 
            	else if(map.get(o1) == map.get(o2)) return o2.length() - o1.length();
            	else return map.get(o2) - map.get(o1);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(String s : key) sb.append(s + "\n");
        
        System.out.println(sb.toString());
    }
}