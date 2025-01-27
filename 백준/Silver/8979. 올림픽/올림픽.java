import java.util.*;
import java.io.*;
class Main{

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Map<Integer, int[]> map = new LinkedHashMap<>();
		int gold = 0;
		int silver = 0;
		int bronze = 0;
		
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int team = Integer.parseInt(st.nextToken());
			if(team == k) {
				gold = Integer.parseInt(st.nextToken());
				silver = Integer.parseInt(st.nextToken());
				bronze = Integer.parseInt(st.nextToken());
				continue;
			}
			map.put(team, new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		List<Integer> list = new ArrayList<>(map.keySet());
		
		int rank = 1;
		for(int key : list) {
			int[] arr = map.get(key);
			int g = arr[0];
			int s = arr[1];
			int b = arr[2];
			
			if(g > gold) rank++;
			else if(g == gold && s > silver) rank++;
			else if(g == gold && s == silver && b > bronze) rank++;
		}
		
		System.out.println(rank);
	}
	

}