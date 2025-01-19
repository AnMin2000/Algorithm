import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[n];

		long start = 1;
		long end = 0;
		for(int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			arr[i] = tmp;
			end = Math.max(end, tmp);
		}
		
		long result = 0;
		
		while(start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;
			for(int i = 0; i < n; i++) sum += arr[i] / mid;
			
			if(sum >= m) {
				result = Math.max(result, mid);
				start = mid + 1;
			}
			else end = mid - 1;
			
		}
		
		System.out.println(result);
	}
}