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

		int[] arr = new int[N];
		
		int start = 0;
		int end = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			end = Math.max(end, arr[i]);
		}
		Arrays.sort(arr);
		int result = 0;
		int mid = 0;
		while(start <= end) {
			mid = (start + end) / 2;
			
			long sum = 0;
			for(int i = 0; i < N; i++) {
				int tmp = arr[i] - mid;
				if(arr[i] - mid > 0) sum += tmp;
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