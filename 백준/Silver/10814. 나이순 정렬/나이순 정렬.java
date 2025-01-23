import java.util.*;
import java.io.*;

class User{
	int index;
	int age;
	String name;
	public User(int index, int age, String name) {
		this.index = index;
		this.age = age;
		this.name = name;
	}
}
class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<User> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			list.add(new User(i, Integer.parseInt(s[0]), s[1]));
		}
		
		
		Collections.sort(list, new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				if(o1.age == o2.age) return o1.index - o2.index;
				return o1.age - o2.age;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(User user : list) {
			sb.append(user.age).append(" ").append(user.name).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
}