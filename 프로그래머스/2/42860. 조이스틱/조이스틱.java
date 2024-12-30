import java.util.*;
class Solution {
    public int solution(String name) {
        // A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
        // 0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
        // 0  25 24 23 22 21 20 19 18 17 16 15 14 13 12 11 10 9  8  7  6  5  4  3  2  1
        
        int sum = 0;
        
        for(int i = 0; i < name.length(); i++){
            char ch = name.charAt(i);
            
            if(ch != 'A'){
                int answer1 = ch - 65;
                int answer2 = 26 - answer1;
                
                sum += Math.min(answer1, answer2);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < name.length(); i++){
            if(name.charAt(i) != 'A') list.add(i);
        }
        
        int len = list.size();
        int min = Integer.MAX_VALUE;
        
        if(len == 0) return 0; // A아닌 알파벳이 0개 일 때
        else if(len == 1) return Math.min(list.get(0), name.length() - list.get(0)) + sum; // A아닌 알파벳이 1개 일 때
        else{
            min = Math.min(list.get(len - 1), name.length() - list.get(0));
            System.out.print("일자 : " + min+" ");
            System.out.println();
            for(int i = 0; i < len - 1; i++){
                int tmp = list.get(i) * 2 + name.length() - list.get(i + 1);
                min = Math.min(min, tmp);
                System.out.print("앞뒤 : " + tmp+" ");
            }
             System.out.println();
            for(int i = len - 1; i > 0; i--){
                int tmp = (name.length() - list.get(i)) * 2 +  list.get(i - 1);
                min = Math.min(min, tmp);
                System.out.print("뒤앞 : " + tmp +" ");
            }
            
        }
            
        
       
        return min + sum;
    }
}