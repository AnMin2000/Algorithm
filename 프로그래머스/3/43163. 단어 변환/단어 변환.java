class Solution {
    static int min = Integer.MAX_VALUE;
    static String end;
    static String[] text;
    static boolean[] visit;
    public int solution(String begin, String target, String[] words) {
        end = target;
        text = words;
        visit = new boolean[words.length];
        dfs(begin, 0);

        return min == Integer.MAX_VALUE ? 0 : min;
    }
    static void dfs(String start, int count){
        if(start.equals(end)) {
            min = Math.min(min, count);
            return;
        }
        
        for(int i = 0; i < text.length; i++){
            if(visit[i]) continue;
            int ctn = 0;
            for(int j = 0; j < text[i].length(); j++){
                if(start.length() != text[i].length()) continue;
                if(text[i].charAt(j) != start.charAt(j)) {
                    ctn++;
                    if(ctn > 1) break;
                }
            }
            if(ctn != 1) continue;
            visit[i] = true;
            dfs(text[i], count + 1);
            visit[i] = false;
            
        }
    }
}