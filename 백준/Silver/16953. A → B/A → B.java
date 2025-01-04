import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        
        int count = 1;
        
        while (B != A) {
            if (B < A) { // A로 만들 수 없는 경우
                count = -1;
                break;
            }
            
            if (B % 2 == 0) { // B가 2로 나누어 떨어지면 2로 나누기
                B /= 2;
            } else if (B % 10 == 1) { // 끝자리가 1이면 1 제거
                B /= 10;
            } else { // 위 조건에 해당하지 않으면 불가능
                count = -1;
                break;
            }
            
            count++;
        }
        
        System.out.println(B == A ? count : -1);
    }
}
