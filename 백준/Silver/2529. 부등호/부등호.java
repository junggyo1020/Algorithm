import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {



    private static int k;
    private static String minAnswer, maxAnswer;
    private static int[] result;
    private static char[] operator;
    private static boolean[] visited;

    private static boolean isCorrect() {
        for (int i = 0; i < k; i++) {
            if(operator[i] == '>' && result[i] <= result[i + 1]) return false;
            if(operator[i] == '<' && result[i] >= result[i + 1]) return false;
        }
        return true;
    }
    private static void dfs(int depth) {
        //2-1. 종료조건
        if (depth == k + 1) {
            //3. 부등호 관계 만족하는지 검증
            if (isCorrect()) {
                //3-1. 조건 만족 시 최대 & 최소 갱신
                StringBuilder sb = new StringBuilder();
                for (int x : result) {
                    sb.append(x);
                }
                String str = sb.toString();
                // min/max 문자열로 비교 => 9876543210은 int 범위 넘어감!
                if (minAnswer == null || str.compareTo(minAnswer) < 0) minAnswer = str;
                if (maxAnswer == null || str.compareTo(maxAnswer) > 0) maxAnswer = str;
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //1. 입력부 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        result = new int[k+1];
        operator = new char[k];
        visited = new boolean[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            operator[i] = st.nextToken().charAt(0);
        }

        //2. 순열 k+1개 뽑기
        dfs(0);

        //4. 결과 출력
        System.out.println(maxAnswer);
        System.out.println(minAnswer);
    }
}