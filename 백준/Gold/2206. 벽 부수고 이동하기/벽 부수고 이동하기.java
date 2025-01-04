import java.util.*;
import java.io.*;

class Main {
    static int y, x;
    static char[][] cube;
    static boolean[][][] visit; // 방문 상태: 벽을 부쉈는지 여부 포함
    static Queue<int[]> queue = new LinkedList<>();
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        visit = new boolean[y][x][2]; // [y][x][벽을 부쉈는지 여부]
        cube = new char[y][x];

        for (int j = 0; j < y; j++) {
            cube[j] = br.readLine().toCharArray();
        }

        // 초기 상태: (0, 0), 이동 횟수 1, 벽을 부수지 않은 상태(0)
        queue.offer(new int[] {0, 0, 1, 0});
        bfs();
        System.out.println(result);
    }

    static void bfs() {
        int[][] xy = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        visit[0][0][0] = true; // 시작점 방문
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int y1 = arr[0];
            int x1 = arr[1];
            int ctn = arr[2];
            int check = arr[3];

            // 도착점에 도달한 경우
            if (y1 == y - 1 && x1 == x - 1) {
                result = ctn;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int y2 = y1 + xy[i][0];
                int x2 = x1 + xy[i][1];

                // 범위 내에 있으면서 방문하지 않은 경우 탐색
                if (y2 >= 0 && x2 >= 0 && y2 < y && x2 < x) {
                    // 벽이 아닌 경우
                    if (cube[y2][x2] == '0' && !visit[y2][x2][check]) {
                        visit[y2][x2][check] = true;
                        queue.offer(new int[] {y2, x2, ctn + 1, check});
                    }
                    // 벽이지만 부순 적이 없는 경우
                    else if (cube[y2][x2] == '1' && check == 0 && !visit[y2][x2][1]) {
                        visit[y2][x2][1] = true;
                        queue.offer(new int[] {y2, x2, ctn + 1, 1});
                    }
                }
            }
        }
    }
}
