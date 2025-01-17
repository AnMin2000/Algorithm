import java.util.*;
import java.io.*;
class Main{
	static int n, m;
	static char[][] arr;
	static boolean[][][] visit;

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		visit = new boolean[n][m][2];
		
		for(int j = 0; j < n; j++) {
			arr[j] = br.readLine().toCharArray();
		}

		System.out.println(bfs());
	}
	static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0, 0, 1, 0});
		int[][] xy = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
		visit[0][0][0] = true;
		while(!queue.isEmpty()) {
			int[] ar = queue.poll();
			int y = ar[0];
			int x = ar[1];
			int ctn = ar[2];
			int wall = ar[3];
			
			if(y == n - 1 && x == m - 1) return ctn;
			
			for(int i = 0; i < 4; i++) {
				int ny = y + xy[i][0];
				int nx = x + xy[i][1];
				
				if(ny < 0 || nx < 0 || nx >= m || ny >= n ) continue;
				
				if(arr[ny][nx] - '0' == 0 && !visit[ny][nx][wall]) {
					visit[ny][nx][wall] = true;
					queue.offer(new int[] {ny, nx, ctn + 1, wall});
					//System.out.println("Y : " + ny + " X : " + nx + " Count : " + (ctn + 1) + " Wall : " + wall);
				}
				else if(arr[ny][nx] - '0' == 1 && !visit[ny][nx][1] && wall == 0) {
					visit[ny][nx][1] = true;
					queue.offer(new int[] {ny, nx, ctn + 1, 1});
					//System.out.println("Y : " + ny + " X : " + nx + " Count : " + (ctn + 1) + " Wall : 1");
				}
				
			}
		}
		return -1;
	}
}