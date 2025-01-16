import java.util.*; 
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); // 사람 수
        int m = Integer.parseInt(st.nextToken()); // 파티 수
        
        // 진실을 아는 사람 집합
        Set<Integer> truthSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        while (truthCount-- > 0) {
            truthSet.add(Integer.parseInt(st.nextToken()));
        }

        // 파티 정보 저장
        List<Integer>[] partyList = new ArrayList[m + 1];
        for (int i = 1; i <= m; i++) {
            partyList[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            for (int j = 0; j < partySize; j++) {
                partyList[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        // 진실을 아는 사람 확장 반복
        boolean updated = true;
        while (updated) {
            updated = false;
            for (int i = 1; i <= m; i++) {
                for (int person : partyList[i]) {
                    if (truthSet.contains(person)) {
                        for (int participant : partyList[i]) {
                            if (!truthSet.contains(participant)) {
                                truthSet.add(participant);
                                updated = true; // 새로운 사람이 추가되면 계속 탐색
                            }
                        }
                        break; // 한 번 진실을 확장하면 해당 파티는 종료
                    }
                }
            }
        }

        // 거짓말할 수 있는 파티 개수 계산
        int result = 0;
        for (int i = 1; i <= m; i++) {
            boolean canLie = true;
            for (int person : partyList[i]) {
                if (truthSet.contains(person)) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) result++;
        }

        System.out.println(result);
    }
}
