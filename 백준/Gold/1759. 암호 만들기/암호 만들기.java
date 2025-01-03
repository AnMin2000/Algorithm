import java.util.*;
import java.io.*;
class Main{
    
    static int L, C;
    static String[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        arr = new String[C];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < C; i++) arr[i] = st.nextToken();
        Arrays.sort(arr);
        dfs(0, 0, "");
        
        
        System.out.println(sb.toString());
        
    }
    static void dfs(int start, int count, String text){
        if(count == L){
            int tmp = 0;
            for(int i = 0; i < L; i++){
            	char ch = text.charAt(i);
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') tmp++;
            }
            if(tmp >= 1 && count - tmp >= 2) sb.append(text + "\n");
            return;
        }
        for(int i = start; i < C; i++){
            dfs(i + 1, count + 1, text + String.valueOf(arr[i]));
        }
    }
}