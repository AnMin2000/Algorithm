import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1; i <= N; i++){
            list.add(i);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        int current = M - 1;
        while(list.size() != 0){
            if(list.size() != 1) sb.append(list.get(current) + ", ");
            else {
            	sb.append(list.get(0) + ">"); 
            	break;
            }
            list.remove(current);
            current += M - 1;
            
            
            while(current >= list.size()) {
            	current -= list.size();
            }
        }
        
        System.out.println(sb.toString());
    }
}