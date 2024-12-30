import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        int[] result = new int[n];
        
        
        Stack<Integer> stack = new Stack<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        result[n - 1] = -1;
        stack.push(arr[n - 1]);

        for(int i = n - 2; i >= 0; i--){

        	result[i] = -1;
            if(arr[i] < arr[i + 1]){
                result[i] = arr[i + 1];
                stack.push(arr[i]);
            }
            else{
                while(!stack.isEmpty()){
                    if(arr[i] < stack.peek()){
                        result[i] = stack.peek();
                        stack.push(arr[i]);
                        break;
                    }
                    stack.pop();
                }
                if(result[i] == -1) stack.push(arr[i]);
            }
        }
        for(int i = 0; i < n; i++) sb.append(result[i] + " ");
        System.out.println(sb.toString());
    }
}