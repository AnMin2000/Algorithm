import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        int start = 0;
        int end = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            start = Math.max(start, arr[i]); // 최소값은 가장 긴 강의의 길이
            end += arr[i]; // 최대값은 모든 강의를 하나의 블루레이에 담는 경우
        }

        int result = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2;

            // 블루레이 개수 계산
            int count = check(n, arr, mid);

            if (count > m) {
                start = mid + 1; // 필요한 블루레이 개수가 많으면 크기를 늘림
            } else {
                result = mid; // 가능한 경우 결과 갱신
                end = mid - 1; // 더 작은 크기 탐색
            }
        }

        System.out.println(result);
    }

    // 주어진 블루레이 크기로 몇 개의 블루레이가 필요한지 계산
    static int check(int n, int[] arr, int mid) {
        int count = 1; // 블루레이 개수
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (sum + arr[i] > mid) {
                count++;
                sum = arr[i]; // 새로운 블루레이 시작
            } else {
                sum += arr[i];
            }
        }

        return count;
    }
}
