import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    private static int N, M;
    private static int[] arr, result;

    private static void dfs(int depth, int start) {
        // 3-1. 종료조건
        if (depth == M) {
            for (int x : result) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }
        // 3-2. 재귀
        for (int i = start; i < N; i++) {
            result[depth] = arr[i];
            dfs(depth + 1, i + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        // 1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 2. 정렬하기
        Arrays.sort(arr);
        // 3. 재귀 / 백트래킹
        dfs(0, 0);
    }
}