import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int s1 = Integer.parseInt(st.nextToken());
		int s2 = Integer.parseInt(st.nextToken());
		long ctn = 0;
		
		for(int i = 0; i < n; i++) {
			arr[i] -= s1;
			ctn++;
			
			if(arr[i] > 0) {
				if(arr[i] % s2 == 0) ctn += arr[i] / s2;
				else ctn += arr[i] / s2 + 1;
			}
		}
		
		System.out.println(ctn);
	}
}