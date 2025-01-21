import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < n; i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        
        List<Integer> key = new ArrayList<>(map.keySet());
        Collections.sort(key, new Comparator<Integer>() {
        	@Override
        	public int compare(Integer o1, Integer o2) {
        		return map.get(o2) - map.get(o1);
        	}
        });
        
        StringBuilder sb = new StringBuilder();
        for(int s : key) {
        	for(int i = 0; i < map.get(s); i++) sb.append(s).append(" ");
        }
        
        System.out.println(sb.toString());
    }
}