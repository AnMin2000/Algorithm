import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < n; j++){
            Map<String, Integer> map = new HashMap<>();
            int m = Integer.parseInt(br.readLine());
            for(int i = 0; i < m; i++){
                String[] tmp = br.readLine().split(" ");
                map.put(tmp[1], map.getOrDefault(tmp[1], 0) + 1);
            }
            List<String> list = new ArrayList<>(map.keySet());
            
            int sum = 1;
            for(String s : list){
                sum *= (map.get(s) + 1);
            }
            sb.append(sum - 1 + "\n");
        }
        System.out.println(sb.toString());
    }
}