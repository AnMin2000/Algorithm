import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
        char[][] cube = new char[y][x];
        for(int i = 0; i < y; i++)  cube[i] = br.readLine().toCharArray();
        
        int result = 64;
        int ctn = 0;
       for(int k = 0; k <= y - 8; k++){
           for(int l = 0; l <= x - 8; l++){
               ctn = 0;
               for(int j = k; j < k + 8; j++){
                    for(int i = l; i < l + 8; i++){
                        if(cube[j][i] == 'W' && (i + j) % 2 == 0) ctn++;
                        else if(cube[j][i] == 'B' && (i + j) % 2 == 1) ctn++;
                    }
                }
               ctn = Math.min(ctn, 64 - ctn);
               result = Math.min(result, ctn);
            }
       }
        
        
        System.out.println(result);
    }
}