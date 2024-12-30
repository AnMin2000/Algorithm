import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        for(int j = 0; j < n; j++){
        	StringBuilder sb = new StringBuilder();
            String text = br.readLine(); // 명령어 문자열
            int num = Integer.parseInt(br.readLine()); // 배열 크기
            String tmp2 = br.readLine(); // 배열 입력 (문자열 형태)
            
            tmp2 = tmp2.substring(1, tmp2.length() - 1);
            
            String[] tmp = tmp2.split(",");
            
            Deque<String> deque = new ArrayDeque<>();
            if(!tmp[0].equals("")) for(int i = 0; i < tmp.length; i++) deque.offerLast(tmp[i]);
            
            boolean state = true;
            boolean check = true;
            
            for(char ch : text.toCharArray()){
                
                if(ch == 'R') {
                    state = !state;
                    continue;
                }
                else{
                    if(deque.size() == 0) {
                    	sb.append("error"); // 이부분일때 아래 작동 안하게 해야함
                        check = false;
                        break;
                    }
                    else{
                        if(state){ // 직진
                            deque.removeFirst();
                        }
                        else{ // 역순
                            deque.removeLast();
                        }
                    }
                }
            }
            if(check) {
            	sb.append("[");
                if(state){
                	while(deque.size() != 0) {
                		sb.append(deque.pollFirst());
                		if(deque.size() != 0) sb.append(",");
                	}
                		
                		
                }
                else{
                	while(deque.size() != 0) {
                		sb.append(deque.pollLast());
                		if(deque.size() != 0) sb.append(",");
                	}
                }
                sb.append("]");
            }	
            System.out.println(sb.toString());
        }
    }
}