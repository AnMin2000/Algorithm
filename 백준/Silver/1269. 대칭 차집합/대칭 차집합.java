import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Map<Integer, Integer> map = new HashMap<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) map.put(Integer.parseInt(st.nextToken()), 1);
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(map.containsKey(tmp)) map.remove(tmp);
            else map.put(tmp, 1);
        }
        
        System.out.println(map.size());
    }
}