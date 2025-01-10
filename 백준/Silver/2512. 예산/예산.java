import java.util.*;
import java.io.*;
class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		int m = Integer.parseInt(br.readLine());
		
		int start = 0;
		int end = max;
		int mid = 0;
		int result = 0;
		while(start <= end) {
			mid = (start + end) / 2;
			int sum = 0;
			for(int i = 0; i < n; i++) {
				if(arr[i] > mid) {
					sum += mid;
				}
				else sum += arr[i];
			}
			if(sum <= m) {
				result = mid;
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}

		}
		
		System.out.println(result);
	}
}