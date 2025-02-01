import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());
        long ans = 1;

        if (A > C) { //분배법칙 (나머지끼리 연산해도 결과는 같음)
            A = A % C;
        }

        while (true) {
            if (B == 1) { //B가 1이면 반복종료
                break;
            }

            if (B % 2 == 1) { //B가 홀수라면 따로 A를 빼내고 짝수로 변환해야함
                ans = (ans * A) % C; //분배법칙
                B--;
            }
            A = (A * A) % C; //지수를 줄이는 과정, 분배법칙
            B /= 2;
        }

        ans = (ans * A) % C; //분배법칙

        System.out.println(ans);
    }
}