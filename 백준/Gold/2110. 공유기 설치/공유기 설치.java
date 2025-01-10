import java.util.*;
import java.io.*;
class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int start = 1;
		int end = arr[n - 1] - arr[0];
		int result = 0;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(check(arr, n, m, mid)) {
				result = mid;
				start = mid + 1;
			}
			else end = mid - 1;
			
		}
		
		System.out.println(result);
		
	}
	static boolean check(int[] arr, int n, int m, int mid) {
		int count = 1;
		int last = arr[0];
		for(int i = 1; i < n; i++) {
			if(arr[i] - last >= mid) {
				count++;
				last = arr[i];
			}
		}
		return count >= m;
	}
}