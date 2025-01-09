import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for(int j = 0; j < 3; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 3; i++) {
				String tmp = st.nextToken();
				sb.append(tmp);
			}
		}
		
		bfs(sb.toString());
	}
	static void bfs(String line) {
		Queue<String> queue = new LinkedList<>();
		Map<String, Integer> map = new HashMap<>();
		
		queue.offer(line);
		map.put(line, 0);
		
		
		int[][] xy = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
		while(!queue.isEmpty()) {
			String current = queue.poll();
			int index = current.indexOf("0");
			int y = index / 3;
			int x = index % 3;
			for(int i = 0; i < 4; i++) {
				int ny = y + xy[i][0];
				int nx = x + xy[i][1];
				int move = ny * 3 + nx;
				if(ny >= 0 && nx >= 0 && ny < 3 && nx <3) {
					StringBuilder sb = new StringBuilder(current);
					char ch = sb.charAt(move);
					sb.setCharAt(move, '0');
					sb.setCharAt(index, ch);
					
					if(!map.containsKey(sb.toString())) {
						map.put(sb.toString(), map.get(current) + 1);
						queue.offer(sb.toString());
					}
				}
			}
		}
			System.out.println(map.getOrDefault("123456780", -1));
	}
}