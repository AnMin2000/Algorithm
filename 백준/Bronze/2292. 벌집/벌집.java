import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        br.close();

        int room = 1; //찾을 방 최소 루트
        int findroom = 2; //최소 루트(기본값) => 1을 따로 뺐으니 최소 루트(기준값)가 2이다.

        if(n == 1) {
            System.out.print(room);
        }else{
            while(findroom <= n) { //찾을 방번호가 더 클 경우에 반복문 계속
                findroom = findroom + (6 * room);
                room++;
                
            }
            System.out.print(room);
        }

    }
}