import java.util.*;
import java.io.*;

class Main{
	static String line;
	static int len;
	static boolean state = false;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine();
		len = line.length();
		StringBuilder sb = new StringBuilder(br.readLine());
		dfs(sb);
		
		System.out.println(state == true ? 1 : 0);
	}
	static void dfs(StringBuilder sb) {
		if(sb.length() == len) {
			if(sb.toString().equals(line)) state = true;
			return;
		}
		
		StringBuilder sb2 = sb;
		if(sb.charAt(sb.length() - 1) == 'A') {
			String tmp = sb.substring(0, sb.length() - 1);
			sb = new StringBuilder();
			sb.append(tmp);
			dfs(sb);
		}
		
		if(sb2.charAt(0) == 'B') {
			String tmp = sb2.substring(1, sb2.length());
			sb2 = new StringBuilder();
			sb2.append(tmp);
			sb2.reverse();
			dfs(sb2);
		}
	}

}