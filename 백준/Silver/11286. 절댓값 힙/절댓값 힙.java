import java.util.*;
import java.io.*;
class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;
				return Math.abs(o1) - Math.abs(o2);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		while(n-->0) {
			int m = Integer.parseInt(br.readLine());
			if(m == 0) {
				if(!pq.isEmpty()) sb.append(pq.poll()).append("\n");
				else sb.append(0).append("\n");
			}
			else pq.offer(m);
		}
		
		System.out.println(sb.toString());
		
	}
}