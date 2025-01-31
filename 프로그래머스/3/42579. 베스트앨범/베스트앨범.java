import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new LinkedHashMap<>();
        Map<String, Map<Integer, Integer>> play = new LinkedHashMap<>();
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            Map<Integer, Integer> tmp = new LinkedHashMap<>();
            if(play.containsKey(genres[i])){
                tmp = play.get(genres[i]);
                tmp.put(i, plays[i]);
            }
            else {
                tmp.put(i, plays[i]);
            }
            play.put(genres[i], tmp);
        }
        
        List<String> playKey = new ArrayList<>(play.keySet());
        
        
        List<String> genreKey = new ArrayList<>(map.keySet());
        Collections.sort(genreKey, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return map.get(o2) - map.get(o1);
            }
        });
        
        List<Integer> result = new ArrayList<>();
        for(String s : genreKey){
            Map<Integer, Integer> tmp = play.get(s);
            List<Integer> t = new ArrayList<>(tmp.keySet());
            Collections.sort(t, new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2){
                    if(tmp.get(o1) == tmp.get(o2)) return o1 - o2;
                    return tmp.get(o2) - tmp.get(o1);
                }
            });
            if(t.size() > 1) {
                result.add(t.get(0)); result.add(t.get(1));
            }
            else result.add(t.get(0));
        }
        int[] answer = new int[result.size()];
        int index = 0;
        for(int a : result) answer[index++] = a;
        return answer;
    }
}