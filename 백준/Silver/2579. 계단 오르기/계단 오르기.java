import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1]; // 계단 점수
        int[] dp = new int[n + 1]; // 최대 점수

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) { // 계단이 하나인 경우
            System.out.println(arr[1]);
            return;
        }

        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
        }

        System.out.println(dp[n]);
    }
}
