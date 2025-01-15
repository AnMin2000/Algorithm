import java.io.*;
import java.util.*;

class Main{
	
	static int n, m;
	static int[] arr;
	static Set<String> set = new LinkedHashSet<>();
	static boolean[] visit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n];
		Arrays.sort(arr);
		
		dfs(0, "");
		
		List<String> list = new ArrayList<>(set);
		
		StringBuilder sb = new StringBuilder();
		for(String s : list) sb.append(s + "\n");
		
		System.out.println(sb.toString());
	}
	static void dfs(int count, String text) {
		
		if(count == m) {
			set.add(text);
			return;
		}
		for(int i = 0; i < n; i++) {
			//System.out.println(line[count]);
			if(!visit[i]) {
				visit[i] = true;
				dfs(count + 1, text + String.valueOf(arr[i]) + " ");
				visit[i] = false;
			}
		
		}
	}
}