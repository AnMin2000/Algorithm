import java.io.*;
import java.util.StringTokenizer;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] human = new int[n][2];
        
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            human[i][0] = Integer.parseInt(st.nextToken());
            human[i][1] = Integer.parseInt(st.nextToken());
        }
        
        
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < n; j++){
        	int count = 1;
            for(int i = 0; i < n; i++){
                if(i == j) continue;
                
                if(human[j][0] < human[i][0] && human[j][1] < human[i][1]) count++;
            }
            sb.append(count+" ");
        }
        
        System.out.println(sb.toString());
        
       
        
    }
}