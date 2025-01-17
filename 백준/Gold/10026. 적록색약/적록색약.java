import java.io.*;
import java.util.*;

class Main{
	static int[][] xy = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static int n;
	static char[][] arr;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		visit = new boolean[n][n];
		
		for(int i = 0; i < n; i++) arr[i] = br.readLine().toCharArray();
		
		int ctn1 = 0;
		for(int j = 0; j < n; j++) {
			for(int i = 0; i < n; i++) {
				if(!visit[j][i]) {
					bfs1(j, i);
					ctn1++;
				}
			}
		}
		visit = new boolean[n][n];
		
		int ctn2 = 0;
		for(int j = 0; j < n; j++) {
			for(int i = 0; i < n; i++) {
				if(!visit[j][i]) {
					bfs2(j, i);
					ctn2++;
				}
			}
		}
		
		System.out.println(ctn1 + " " + ctn2);
	}
	
	static void bfs1(int yy, int xx) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {yy, xx});
		visit[yy][xx] = true;
		while(!queue.isEmpty()) {
			int[] arr2 = queue.poll();
			int y = arr2[0];
			int x = arr2[1];
			
			for(int i = 0; i < 4; i++) {
				int ny = y + xy[i][0];
				int nx = x + xy[i][1];
				
				if(ny >= 0 && nx >= 0 && nx < n && ny < n && !visit[ny][nx] && arr[ny][nx] == arr[yy][xx]) {
					visit[ny][nx] = true;
					queue.offer(new int[] {ny, nx});
				}
			}
		}
	}
	static void bfs2(int yy, int xx) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {yy, xx});
		visit[yy][xx] = true;
		while(!queue.isEmpty()) {
			int[] arr2 = queue.poll();
			int y = arr2[0];
			int x = arr2[1];
			
			for(int i = 0; i < 4; i++) {
				int ny = y + xy[i][0];
				int nx = x + xy[i][1];
				
				if(ny >= 0 && nx >= 0 && nx < n && ny < n && !visit[ny][nx]) {
					if((arr[yy][xx] == 'R' || arr[yy][xx] == 'G') && (arr[ny][nx] == 'R' || arr[ny][nx] == 'G')) {
						visit[ny][nx] = true;
						queue.offer(new int[] {ny, nx});
					}
					else if(arr[yy][xx] == arr[ny][nx]) {
						visit[ny][nx] = true;
						queue.offer(new int[] {ny, nx});
					}
				}
			}
		}
	}
}