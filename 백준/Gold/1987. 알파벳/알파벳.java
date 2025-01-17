import java.util.*;
import java.io.*;

class Main{
	static int n, m;
	static int max = 0;
	static char[][]arr;
	static boolean[][] visit;
	static int[][] xy = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static Set<Character> set = new LinkedHashSet<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new char[n][m];
		for(int j = 0; j < n; j++) {
			arr[j] = br.readLine().toCharArray();
		}
		
		visit = new boolean[n][m];
		set.add(arr[0][0]);
		dfs(0, 0);
		
		System.out.println(max);
	}
	static void dfs(int y, int x) {
		max = Math.max(max, set.size());
		visit[y][x] = true;
		
		for(int i = 0; i < 4; i++) {
			int ny = y + xy[i][0];
			int nx = x + xy[i][1];
			
			if(nx >= 0 && ny >= 0 && nx < m && ny < n && !visit[ny][nx] && !set.contains(arr[ny][nx])) {
				set.add(arr[ny][nx]);
				dfs(ny, nx);
				visit[ny][nx] = false;
				set.remove(arr[ny][nx]);
			}
		}
	}
}