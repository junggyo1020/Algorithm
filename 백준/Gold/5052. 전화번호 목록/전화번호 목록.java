import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Main {

    static int T, N;
    static String[] pNum;
    static StringBuilder result;

    public static void main(String[] args) throws IOException {
        //1. 입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        result = new StringBuilder();
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            pNum = new String[N];
            for (int i = 0; i < N; i++) {
                pNum[i] = br.readLine();
            }

            Arrays.sort(pNum);

            //2. 구현부
            solution();
        }
        System.out.println(result);
    }

    private static void solution() {
        if (isConsistent(pNum)) {
            result.append("YES\n");
        } else {
            result.append("NO\n");
        }
    }

    private static boolean isConsistent(String[] pNum) {
        for (int i = 0; i < pNum.length - 1; i++) {
            if(pNum[i+1].startsWith(pNum[i])) return false;
        }
        return true;
    }
}