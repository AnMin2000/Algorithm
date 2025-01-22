import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] sortedArr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sortedArr[i] = arr[i];
        }

        // 배열 정렬
        Arrays.sort(sortedArr);

        // 좌표 압축 결과 저장
        Map<Integer, Integer> compressed = new HashMap<>();
        int count = 0;
        for (int num : sortedArr) {
            if (!compressed.containsKey(num)) {
                compressed.put(num, count++);
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(compressed.get(num)).append(" ");
        }

        System.out.println(sb.toString());
    }
}
