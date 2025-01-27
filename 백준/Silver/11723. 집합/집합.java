import java.util.*;
import java.io.*;
class Main{

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Set<String> set = new LinkedHashSet<>();
		StringBuilder sb = new StringBuilder();
		while(n-->0) {
			String[] arr = br.readLine().split(" ");
			
			if(arr[0].equals("add")) {
				set.add(arr[1]);
			}
			else if(arr[0].equals("remove")) {
				if(set.contains(arr[1])) set.remove(arr[1]);
			}
			else if(arr[0].equals("check")) {
				if(set.contains(arr[1])) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}
			else if(arr[0].equals("toggle")) {
				if(set.contains(arr[1])) set.remove(arr[1]);
				else set.add(arr[1]);
			}
			else if(arr[0].equals("all")) {
				set.clear();
				for(int i = 1; i <= 20; i++) set.add(String.valueOf(i));
			}
			else if(arr[0].equals("empty")) {
				set.clear();
			}
				
		}
		
		System.out.println(sb);
		

	}
	

}