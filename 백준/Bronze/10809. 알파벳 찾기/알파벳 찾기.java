import java.util.*;
import java.io.*;
class Main{

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String n = br.readLine();
		StringBuilder sb = new StringBuilder();
		char ch = 96;
		for(int j = 0; j < 26; j++) {
			ch++;
			for(int i = 0; i < n.length(); i++) {
				if(ch == n.charAt(i)) {
					sb.append(i).append(" ");
					break;
				}
				else if(i == n.length() - 1) sb.append(-1).append(" ");
			}
		}
		
		System.out.println(sb);

	}
	

}