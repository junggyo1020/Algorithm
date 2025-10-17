import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 순열 구현 - 배열
class Main {

    static int N, M; //N개중 M개
    static int[] arr;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        isSelected = new boolean[N+1];
        dfs(0);
    }

    private static void dfs(int cnt) {
        if(cnt == M) {
            for(int x : arr){
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++){
            if(isSelected[i]) continue;
            isSelected[i] = true;
            arr[cnt] = i;
            dfs(cnt+1);
            isSelected[i] = false;
        }
    }
}