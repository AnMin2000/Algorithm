import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new LinkedHashMap<>();
        
        while(n-->0) {
        	String[] s = br.readLine().split("\\.");

        	map.put(s[1], map.getOrDefault(s[1], 0) + 1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<String>() {
        	@Override
        	public int compare(String o1, String o2) {
        		return o1.compareTo(o2);
        	}
        });
        
        StringBuilder sb = new StringBuilder();
        for(String s : list) sb.append(s).append(" ").append(map.get(s)).append("\n");
        
        System.out.println(sb.toString());
        
    }
}