import java.util.*;
import java.io.*;
class Main{

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		char[][] ch = new char[n][n];
		for(int i = 0; i < n; i++) ch[i] = br.readLine().toCharArray();
		
		int y = 0; int x = 0;
		
		B1:
		for(int j = 0; j < n; j++) {
			int ctn = 0;
			for(int i = 0; i < n; i++) {
				if(ch[j][i] == '*') {
					ctn++;
				}
				else ctn = 0;
				
				if(ctn >= 3) {
					
					for(int k = 0; k < n; k++) {
						if(ch[j - 1][k] == '*' && ch[j + 1][k] == '*') {
							y = j;
							x = k;
							break B1;
						}
					}
					
				}
			}
		}
		
		int left = 0; int right = 0; int mid = 0; int leftLeg = 0; int rightLeg = 0;
		int ly = 0; int lx = 0; int ry = 0; int rx = 0;
		for(int i = x - 1; i >= 0; i--) {
			if(ch[y][i] == '*') left++;
			else break;
		}
		for(int i = x + 1; i < n; i++) {
			if(ch[y][i] == '*') right++;
			else break;
		}
		for(int i = y + 1; i < n; i++) {
			if(ch[i][x] == '*') mid++;
			else {
				ly = i;
				lx = x - 1;
				ry = i;
				rx = x + 1;
				break;
			}
		}
		
		for(int i = ly; i < n; i++) {
			if(ch[i][lx] == '*') leftLeg++;
			else {
				break;
			}
		}
		for(int i = ry; i < n; i++) {
			if(ch[i][rx] == '*') rightLeg++;
			else {
				break;
			}
		}
		
		System.out.println((y+1) + " " + (x+1));
		System.out.println(left + " " + right + " " + mid + " " + leftLeg + " " + rightLeg);
	}
	

}