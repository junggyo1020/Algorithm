import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    static int N, M;
    static Map<String, Integer> hM;
    static Map<Integer, String> hM2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        hM = new HashMap<>();
        hM2 = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String tmp = br.readLine();
            hM.put(tmp, i);
            hM2.put(i, tmp);
        }
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (isStr(str)) {
                sb.append(hM.get(str)).append('\n');
            } else {
                sb.append(hM2.get(Integer.parseInt(str))).append('\n');
            }
        }
        System.out.println(sb);
    }

    private static boolean isStr(String str) {
        for (char c : str.toCharArray()) {
            if(Character.isDigit(c)) return false;
        }
        return true;
    }
}