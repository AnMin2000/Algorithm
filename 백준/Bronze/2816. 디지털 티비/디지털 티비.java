import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        List<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++) list.add(br.readLine());
        
        int kbs1 = list.indexOf("KBS1");
        int kbs2 = list.indexOf("KBS2");

        StringBuilder sb = new StringBuilder();
        if(kbs1 < kbs2) {
        	for(int i = 0; i < kbs1; i++) sb.append("1");
        	for(int i = 0; i < kbs1; i++) sb.append("4");
        	for(int i = 0; i < kbs2; i++) sb.append("1");
        	for(int i = 0; i < kbs2 - 1; i++) sb.append("4");
        }
        else {
        	for(int i = 0; i < kbs2; i++) sb.append("1");
        	for(int i = 0; i < kbs2; i++) sb.append("4");
        	for(int i = 0; i < kbs1; i++) sb.append("1");
        	for(int i = 0; i < kbs1; i++) sb.append("4");
        }
        System.out.println(sb.toString());
    }
}