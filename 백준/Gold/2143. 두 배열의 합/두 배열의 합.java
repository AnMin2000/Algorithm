import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // A 배열의 부분 배열 합을 해시맵에 저장
        Map<Long, Integer> mapA = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                mapA.put(sum, mapA.getOrDefault(sum, 0) + 1);
            }
        }

        // B 배열의 부분 배열 합과 T - 부분 합의 경우의 수 계산
        long count = 0;
        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                count += mapA.getOrDefault(T - sum, 0); // T - sum을 만족하는 경우의 수 더하기
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}
