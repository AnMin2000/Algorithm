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
        
        int current = 0;
        while(list.size() != 0){
            current = (current + M - 1) % list.size();  // M번째 사람 계산
            sb.append(list.remove(current));          // M번째 사람 제거 및 출력
            if (!list.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb.toString());
    }
}