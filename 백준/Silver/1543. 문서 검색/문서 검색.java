import java.io.*;
import java.util.*;
class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String t = br.readLine();
		
		if(s.length() < t.length()) {
			System.out.println(0);
			return;
		}
		int start = 0;
		int end = t.length();
		
		int count = 0;
		while(end <= s.length()) {
			if(s.substring(start, end).equals(t)) {
				count++;
				start = end;
				end += t.length();
			}
			else {
				start++;
				end++;
			}
			
		}
		System.out.println(count);
	}
}