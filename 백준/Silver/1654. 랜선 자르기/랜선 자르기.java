import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {

	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] arr = new long[N];
		
		long start = 0;
		long end = 0;

		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
			end = Math.max(end, arr[i]);
		}
		Arrays.sort(arr);
		long mid = 0;
		long result = 0;
		while(start <= end) {
			mid = (start + end) / 2;
			if(mid == 0) {
				result = 1;
				break;
			}
			long sum = 0;
			for(int i = 0; i < N; i++) {
				sum += arr[i] / mid;
			}
			if(sum >= M) {
				result = mid;
				start = mid + 1;
			}
			else if(sum < M) {
				end = mid - 1;
			}

		}
		System.out.println(result);
		
	}

 
}