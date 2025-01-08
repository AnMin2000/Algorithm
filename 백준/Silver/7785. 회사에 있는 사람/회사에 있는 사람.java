import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String[] tmp = br.readLine().split(" ");
            if(map.containsKey(tmp[0])) map.remove(tmp[0]);
            else map.put(tmp[0], tmp[1]);
        }
        
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(String s : list) sb.append(s+"\n");
        
        System.out.println(sb.toString());
    }
}