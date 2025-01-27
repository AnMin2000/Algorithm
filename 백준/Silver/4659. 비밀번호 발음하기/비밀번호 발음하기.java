import java.util.*;
import java.io.*;
class Main{

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String t = br.readLine();
			if(t.equals("end")) break;
			char[] ch = t.toCharArray();
			
			int one = 0;
			int m = 0; int z = 0;
			char temp = ' '; int check = 0;
			
			for(int i = 0; i < ch.length; i++) {
				char text = ch[i];
				
				if(text == 'a' || text == 'e' || text == 'i' || text == 'o' || text == 'u') {
					one++;
				}
				
				if(text == 'a' || text == 'e' || text == 'i' || text == 'o' || text == 'u') {
					z = 0;
					m++;
					if(m >= 3) {
						sb.append("<").append(t).append("> is not acceptable.").append("\n");
						break;
					}
				}
				else {
					m = 0;
					z++;
					if(z >= 3) {
						sb.append("<").append(t).append("> is not acceptable.").append("\n");
						break;
					}
				}
				
				if(temp == text) {
					check++;
					if(check == 2 && !(temp == 'e' || temp == 'o')) {
						sb.append("<").append(t).append("> is not acceptable.").append("\n");
						break;
					}
				}
				else check = 1;
				temp = text;
				
				if(i == ch.length - 1 && one > 0) sb.append("<").append(t).append("> is acceptable.").append("\n");
				else if(i == ch.length - 1 && one == 0) sb.append("<").append(t).append("> is not acceptable.").append("\n");
			}
		}
		System.out.println(sb);
	}
	

}