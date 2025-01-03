// 식의 계산 순서 무시함(앞에서 부터)
// 나눗셈은 무조건 정수 나눗셈의 몫으로
// 음수를 양수로 나눌때는 양수 치환후 나누고 다시 음수 치환
// 최대 최소 구하기
import java.util.*;
import java.io.*;
class Main{
    
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n;
    static int[] number;
    static int[] operator;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        number = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)  number[i] = Integer.parseInt(st.nextToken());
        
        
        operator = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) operator[i] = Integer.parseInt(st.nextToken());
        
        dfs(number[0], 1);
        
        System.out.println(max + "\n" + min);
        
    }
    static void dfs(int num, int index){
        if(index == n){
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }
        
        for(int i = 0; i < 4; i++){
            if(operator[i] > 0){
                operator[i]--;
                if(i == 0) dfs(num + number[index], index + 1);
                else if(i == 1) dfs(num - number[index], index + 1);
                else if(i == 2) dfs(num * number[index], index + 1);
                else dfs(num / number[index], index + 1);
                operator[i]++;
            }
        }
    }
}