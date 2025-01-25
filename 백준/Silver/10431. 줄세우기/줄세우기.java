import java.util.*;
import java.io.*;
class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[20];
			for(int j = 0; j < 20; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			int ctn = 0;
			for(int j = 19; j >= 0; j--) {
				for(int k = j - 1; k >= 0; k--) {
					if(arr[j] < arr[k]) ctn++;
				}
			}
			sb.append(i).append(" ").append(ctn).append("\n");
			
			
			
		}
		System.out.println(sb.toString());
		
	}

}