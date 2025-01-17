import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[3];
            for(int i = 0; i < 3; i++) arr[i] = Integer.parseInt(st.nextToken());
            
            if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;

            Arrays.sort(arr); 
            
            if(arr[0] + arr[1] <= arr[2]) sb.append("Invalid").append("\n");
            else if(arr[0] == arr[1] && arr[1] == arr[2]) sb.append("Equilateral").append("\n");
            else if(arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2]) sb.append("Isosceles").append("\n");
            else sb.append("Scalene").append("\n");
        }
        System.out.println(sb.toString());
        
    }
}