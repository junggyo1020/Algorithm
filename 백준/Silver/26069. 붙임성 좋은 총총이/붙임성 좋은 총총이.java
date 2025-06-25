import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    static int N;
    static String prev1, prev2;
    static Map<String, Boolean> hM;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        hM = new HashMap<>();
        hM.put("ChongChong", true);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            
            //총총은 이미 등장했고, 접촉한 사람과 접촉한 경우
            if (hM.getOrDefault(s1, false) || hM.getOrDefault(s2, false)) {
                hM.put(s1, true);
                hM.put(s2, true);
            }
        }
        System.out.println(hM.size());
    }
}