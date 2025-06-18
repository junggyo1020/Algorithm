import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    private static int N, answer;
    private static int[] arr, result;
    private static boolean[] visited;


    private static int calMax(int[] result) {
        int sum = 0;
        for (int i = 0; i < N-1; i++) {
            sum += Math.abs(result[i] - result[i+1]);
        }
        return sum;
    }
    private static void dfs(int depth) {
        //2-1. 종료조건: N개를 다 뽑은 경우
        if (depth == N) {
            //3. 최대값인지 확인 후 갱신하기
            answer = Math.max(answer, calMax(result));
            return;
        }
        //2-2. 순열 & 백트래킹
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //2. N개의 순열을 재귀로 호출
        dfs(0);

        System.out.println(answer);
    }
}