import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][3];
		int[][] min = new int[n][3];
		int[][] max = new int[n][3];

		for(int j = 0; j < n; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 3; i++) {
				arr[j][i] = Integer.parseInt(st.nextToken());
				if(j == 0) max[j][i] = min[j][i] = arr[j][i];
				else min[j][i] = Integer.MAX_VALUE;
			}
		}
		
		for(int j = 0; j < n - 1; j++) {
			for(int i = 0; i < 3; i++) {
				if(i == 0) {
					min[j + 1][i] = Math.min(min[j + 1][i], arr[j + 1][i] + min[j][i]);
					min[j + 1][i + 1] = Math.min(min[j + 1][i + 1], arr[j + 1][i + 1] + min[j][i]);
					
					max[j + 1][i] = Math.max(max[j + 1][i], arr[j + 1][i] + max[j][i]);
					max[j + 1][i + 1] = Math.max(max[j + 1][i + 1], arr[j + 1][i + 1] + max[j][i]);
				}
				else if(i == 1) {
					min[j + 1][i - 1] = Math.min(min[j + 1][i - 1], arr[j + 1][i - 1] + min[j][i]);
					min[j + 1][i] = Math.min(min[j + 1][i], arr[j + 1][i] + min[j][i]);
					min[j + 1][i + 1] = Math.min(min[j + 1][i + 1], arr[j + 1][i + 1] + min[j][i]);
					
					max[j + 1][i - 1] = Math.max(max[j + 1][i - 1], arr[j + 1][i - 1] + max[j][i]);
					max[j + 1][i] = Math.max(max[j + 1][i], arr[j + 1][i] + max[j][i]);
					max[j + 1][i + 1] = Math.max(max[j + 1][i + 1], arr[j + 1][i + 1] + max[j][i]);
				}
				else {
					min[j + 1][i - 1] = Math.min(min[j + 1][i - 1], arr[j + 1][i - 1] + min[j][i]);
					min[j + 1][i] = Math.min(min[j + 1][i], arr[j + 1][i] + min[j][i]);
					
					max[j + 1][i - 1] = Math.max(max[j + 1][i - 1], arr[j + 1][i - 1] + max[j][i]);
					max[j + 1][i] = Math.max(max[j + 1][i], arr[j + 1][i] + max[j][i]);
				}
			}
		}
		
		System.out.print(Math.max(max[n - 1][0], Math.max(max[n - 1][1], max[n - 1][2])) + " ");
		System.out.println(Math.min(min[n - 1][0], Math.min(min[n - 1][1], min[n - 1][2])));
	}
}