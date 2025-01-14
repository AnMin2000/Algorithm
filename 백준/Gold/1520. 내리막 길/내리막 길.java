import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[][] dp;
	static int[][] arr;
	static int[][] xy = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dp = new int[N][M];
		arr = new int[N][M];
		
		for(int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				arr[j][i] = Integer.parseInt(st.nextToken());
				dp[j][i]--;
			}
		}
		
		System.out.println(dfs(0,0));
	}
	static int dfs(int y, int x) {
		
		if(y == N - 1 && x == M - 1) return 1;
		
		if(dp[y][x] != -1) return dp[y][x];
		
		dp[y][x] = 0;
		for(int i = 0; i < 4; i++) {
			int ny = y + xy[i][0];
			int nx = x + xy[i][1];
			
			if(nx < M && nx >= 0 && ny < N && ny >= 0 && arr[y][x] > arr[ny][nx]) {
				dp[y][x] += dfs(ny, nx);
			}
		}
		return dp[y][x];
	}


}