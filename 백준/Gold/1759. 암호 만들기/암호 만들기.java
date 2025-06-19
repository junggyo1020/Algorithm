import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    private static int L, C;
    private static char[] alpha, result;

    private static boolean check() {
        int mChar = 0, jChar = 0;
        //4-1. 자음 모음 개수 체크
        for (char x : result) {
            if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') mChar++;
            else jChar++;
        }
        return mChar >= 1 && jChar >= 2;
    }
    private static void dfs(int depth, int start) {
        //3-1. 종료조건
        if (depth == L) {
            //4. 조건 맞는지 검증
            if (check()) {
                //5. 맞으면 출력
                StringBuilder sb = new StringBuilder();
                for (char x : result) {
                    sb.append(x);
                }
                System.out.println(sb);
            }
            return;
        }
        //3-2. 조합 & 백트래킹
        for (int i = start; i < C; i++) {
            result[depth] = alpha[i];
            dfs(depth + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        //1. 입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alpha = new char[C];
        result = new char[L];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alpha[i] = st.nextToken().charAt(0);
        }

        //2. 오름차순 정렬하기
        Arrays.sort(alpha);

        //3. 조합: C개 중 L개 뽑기
        dfs(0, 0);
    }
}