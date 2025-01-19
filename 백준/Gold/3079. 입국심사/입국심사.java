import java.util.*;
import java.io.*;
class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		long start = 1;
		long end = 0;
		
		long[] arr = new long[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			end = Math.max(end, arr[i]);
		}
		
		end *= m;
		
		long result = 0;
		while(start <= end) {
			long mid = (start + end) / 2;

			long sum = 0;
			for(int i = 0; i < n; i++) {
				sum += mid / arr[i];
				if(sum > m) break;
			}
			
			if(sum >= m) {
				result = mid;
				end = mid - 1;
			}
			else start = mid + 1;
			
			
		}
		
		System.out.println(result);
		
	}


	
}