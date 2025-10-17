import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<Integer> numbers;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new ArrayList<>();
        isSelected = new boolean[N+1];

        dfs(0);
    }

    private static void dfs(int cnt) {
        if(cnt == M) {
            StringBuilder sb = new StringBuilder();
            for(int x : numbers) {
                sb.append(x).append(" ");
            }
            System.out.println(sb);
        }

        for(int i = 1; i <= N; i++){
            if(isSelected[i]) continue;
            numbers.add(i);
            isSelected[i] = true;
            dfs(cnt+1);
            isSelected[i] = false;
            numbers.remove(numbers.size() - 1);
        }
    }
}
