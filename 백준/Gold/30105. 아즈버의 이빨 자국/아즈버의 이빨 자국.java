import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] locations;
    static Set<Integer> locationSet;

    public static void main(String[] args) throws IOException {
        //1. 입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        locations = new int[N];
        locationSet = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int loc = Integer.parseInt(st.nextToken());
            locations[i] = loc;
            locationSet.add(loc);
        }

        List<Integer> answer = new ArrayList<>();
        Set<Integer> checkedK = new HashSet<>();
        
        //2. 모든 쌍에서 나올 수 있는 거리 + 유효성 검증
        for (int i = 1; i < N; i++) {
            int k = locations[i] - locations[0];
            if (checkedK.contains(k)) continue;

            if (isValid(k)) {
                answer.add(k);
            }
            checkedK.add(k);
        }
        
        //3. 정렬
        Collections.sort(answer);
        
        //4. 출력부
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append('\n');
        for (int x : answer) {
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }

    private static boolean isValid(int k) {
        for (int loc : locationSet) {
            if (!locationSet.contains(loc - k) && !locationSet.contains(loc + k)) {
                return false;
            }
        }
        return true;
    }
}