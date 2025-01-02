import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Set<Integer> set = new HashSet<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            if(set.contains(Integer.parseInt(st2.nextToken()))){
                sb.append("1 ");
            }
            else sb.append("0 ");
        }
        System.out.println(sb.toString());
    }
}