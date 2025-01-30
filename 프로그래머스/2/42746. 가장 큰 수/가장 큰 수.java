import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) arr[i] = String.valueOf(numbers[i]);
        
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                String one = o1 + o2;
                String two = o2 + o1;
                return one.compareTo(two);
            }
        });
        StringBuilder answer = new StringBuilder();
        for(int i = numbers.length - 1; i >= 0; i--) answer.append(arr[i]);
        if(answer.charAt(0) == '0') return "0";
        return answer.toString();
    }
}