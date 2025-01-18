import java.io.*;
import java.util.*;

class Main{
	static int n, m;
	static int[][] arr;
	static boolean[][] visit;
	static boolean[][] ck;
	static int[][] xy = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		for(int j = 0; j < n; j++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < m; i++) {
				arr[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		int i = 0;
		
		while(true) {
			visit = new boolean[n][m];
			int tmp = check();
			if(tmp >= 2) {
				System.out.println(i);
				return;
			}
			else if(tmp == 0) break;
			loop();
			i++;
		}
		System.out.println(0);
	}
	static int check() {
		
		int count = 0;
		for(int j = 0; j < n; j++) {
			for(int i = 0; i < m; i++) {
				if(!visit[j][i] && arr[j][i] > 0) {
					bfs(j, i); // 빙하 개수 체크
					count++;
				}
			}
		}
		return count;
	}
	static void bfs(int y, int x) {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{y, x});
		visit[y][x] = true;
		
		while(!queue.isEmpty()) {
			int[] box = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int ny = box[0] + xy[i][0];
				int nx = box[1] + xy[i][1];
				
				if(ny >= 0 && nx >= 0 && ny < n && nx < m && arr[ny][nx] > 0 && !visit[ny][nx]) {
					visit[ny][nx] = true;
					queue.offer(new int[] {ny, nx});
				}
			}
		}
	}
	
	static void loop() {
		ck = new boolean[n][m];
		for(int j = 0; j < n; j++) {
			for(int i = 0; i < m; i++) {
				if(arr[j][i] > 0) {
					ck[j][i] = true;
					bomb(j, i);
				}
			}
		}
	}
	static void bomb(int y, int x) {
		for(int i = 0; i < 4; i++) {
			int ny = y + xy[i][0];
			int nx = x + xy[i][1];
			
			if(ny >= 0 && nx >= 0 && ny < n && nx < m && arr[ny][nx] == 0 && !ck[ny][nx]) {
				arr[y][x]--;
			}
		}
		if(arr[y][x] < 0) arr[y][x] = 0;
		return;
		
	}

}