// 위 아래 15% 제거 <-- 반올림 (총함 30%)
import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long n = Long.parseLong(br.readLine());
        
        long pivot = Math.round(n * 0.15);

        List<Long> list = new ArrayList<>();
        
        for(long i = 0; i < n; i++) list.add(Long.parseLong(br.readLine()));
        
        Collections.sort(list);
        
        double sum = 0;
        for(long i = pivot; i < n - pivot; i++) {
        	sum += list.get((int)i);
        }
        
        double tmp = sum / (n - (pivot * 2));
        long result = Math.round(tmp);
        System.out.println(result);
    }
}