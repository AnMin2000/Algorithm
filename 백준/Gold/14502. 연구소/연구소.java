import java.util.*;
import java.io.*;

class Main{
	
	static int N, M;
	static int[][] xy = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static int max = 0;
	static int[][] arr;
	static int[][] tmp;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //세로
		M = Integer.parseInt(st.nextToken()); //가로
		
		arr = new int[N][M];
		tmp = new int[N][M];
		visit = new boolean[N][M];
		
		for(int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				tmp[j][i] = arr[j][i] = Integer.parseInt(st.nextToken());
			}
		}

		for(int k = 0; k < N * M - 2; k++) {
			int y1 = k / M;
			int x1 = k % M;
			if(arr[y1][x1] != 0) continue;
			for(int j = k + 1; j < N * M - 1; j++) {
				int y2 = j / M;
				int x2 = j % M;
				if(arr[y2][x2] != 0) continue;
				for(int i = j + 1; i < N * M; i++) {
					int y3 = i / M;
					int x3 = i % M;
					if(arr[y3][x3] != 0) continue;

					arr[y1][x1] = arr[y2][x2] = arr[y3][x3] = 1;
					loop();
					check();
					reset();
				}
			}
		}

		
		System.out.println(max);
	}
	static void reset() {
		for(int j = 0; j < N; j++) {
			for(int i = 0; i < M; i++) {
				arr[j][i] = tmp[j][i];
			}
		}
		visit = new boolean[N][M];
	}
	static void check() {
		int sum = 0;
		
		for(int j = 0; j < N; j++) {
			for(int i = 0; i < M; i++) {
				if(arr[j][i] == 0) sum++;
			}
		}
		max = Math.max(max, sum);
	}
	static void loop() {
		for(int j = 0; j < N; j++) {
			for(int i = 0; i < M; i++) {
				if(arr[j][i] == 2 && !visit[j][i]) virus(j, i);
			}
		}
	}
	static void virus(int y, int x) {
		arr[y][x] = 2;
		visit[y][x] = true;
		for(int i = 0; i < 4; i++) {
			int ny = y + xy[i][0];
			int nx = x + xy[i][1];
			
			if(nx >= 0 && ny >= 0 && nx < M && ny < N && arr[ny][nx] == 0) {
				virus(ny, nx);
			}
		}
	}
}