import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 사람수
		int m = Integer.parseInt(st.nextToken()); // 파티수
		
		Set<Integer> set = new LinkedHashSet<>();
		st = new StringTokenizer(br.readLine());
		int tmp = Integer.parseInt(st.nextToken());
		while(tmp-->0) {
			set.add(Integer.parseInt(st.nextToken()));
		}

		List<Integer>[] list = new ArrayList[m + 1];
		for(int i = 1; i <= m; i++) list[i] = new ArrayList<>();
		
		for(int j = 1; j <= m; j++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			for(int i = 0; i < count; i++) {
				list[j].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		boolean update = true;
		while(update) {
			update = false;
			for(int i = 1; i <= m; i++) {
				for(int s : list[i]) {
					if(set.contains(s)) {
						for(int ss : list[i]) {
							if(!set.contains(ss)) {
								set.add(ss);
								update = true;
							}
						}
						break;
					}
				}
			}
		}
		
		
		int ctn = 0;
		for(int i = 1; i <= m; i++) {
			boolean check = true;
			for(int s : list[i]) {
				if(set.contains(s)) {
					check = false;
					break;
				}
			}
			if(check) ctn++;
		}
		System.out.println(ctn);
	}
}