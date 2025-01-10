import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int devot = (int) ((long) y * 100 / x);
        
        int start = 0;
        int end = 1000000000;
        
        int result = -1;
        while(start <= end) {
        	int mid = (start + end) / 2;
        
        	int tmp = (int) ((long) (y + mid) * 100 / (x + mid));
        	//System.out.println("start : " + start + " end : " + end + " mid : " + mid + " num : "+ tmp);
        	if(tmp != devot) {
        		result = mid;
        		end = mid - 1;
        		
        	}
        	else {
        		start = mid + 1;
        		
        	}
        	
        	
        }
        
        System.out.println(result);

    }

}
