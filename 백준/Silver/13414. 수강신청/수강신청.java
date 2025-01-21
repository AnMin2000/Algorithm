import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Set<String> set = new LinkedHashSet<>();

        while(m-->0) {
        	String s = br.readLine();
        	if(set.contains(s)) {
        		set.remove(s);
        		set.add(s);
        	}
        	else set.add(s);
        }
        
        List<String> list = new ArrayList<>(set);
        
        StringBuilder sb = new StringBuilder();
        
        if(n >= set.size()) for(int i = 0; i < set.size(); i++) sb.append(list.get(i)).append("\n");
        else for(int i = 0; i < n; i++) sb.append(list.get(i)).append("\n");
        
        
        System.out.println(sb.toString());
    }
}