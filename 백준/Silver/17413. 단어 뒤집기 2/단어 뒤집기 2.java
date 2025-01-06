import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," <>", true);
		

		StringBuilder sb = new StringBuilder();
		
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			if(s.equals("<")) {
				while(!(s.equals(">"))) {
					sb.append(s);
					s = st.nextToken();
				}
				sb.append(s);
			}
			else {
				for(int i=s.length()-1; i>=0; i--) {
					sb.append(s.charAt(i));
				}
			}
		}		
		System.out.println(sb.toString());
	}

}