import java.util.*;
import java.io.*;
class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		int sum = 0;
		for(int j = 0; j < n; j++) {
			for(int i = 0; i <= j; i++) {
				sum += arr[i];
			}
		}
		System.out.println(sum);
	}
}