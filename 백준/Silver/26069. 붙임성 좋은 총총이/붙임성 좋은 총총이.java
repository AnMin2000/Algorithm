import java.util.*;
import java.io.*;
class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Set<String> set = new HashSet<>();
		set.add("ChongChong");
		while(n-->0) {
			String[] s = br.readLine().split(" ");
			if(set.contains(s[0]) || set.contains(s[1])) {
				set.add(s[0]);
				set.add(s[1]);
			}
		}
		System.out.println(set.size());
		
	}
}