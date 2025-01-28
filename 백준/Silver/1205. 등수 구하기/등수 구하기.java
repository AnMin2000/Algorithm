import java.util.*;
import java.io.*;
class Main{

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int score = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		if(N==0) {
			System.out.println(1);
			return;
		}
		st = new StringTokenizer(br.readLine());
		int rank = 1;
		int ctn = 0;
		while(N-->0) {
			int num = Integer.parseInt(st.nextToken());
			if(score < num) {
				rank++;
			}
			
			if(score <= num) {
				ctn++;
			}
		}
		
		if(ctn >= P) System.out.println(-1);
		else System.out.println(rank);
	}
	

}