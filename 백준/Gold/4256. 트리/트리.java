import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static StringTokenizer st;
    static int[] pre, in;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());

            //전위 순회 배열 저장
            pre = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                pre[i] = Integer.parseInt(st.nextToken());
            }
            //중위 순회 배열 저장
            in = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                in[i] = Integer.parseInt(st.nextToken());
            }

            traversal(0, 0, n);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void traversal(int rootIdx, int s, int e) {
        if (s >= e) return;
        int rootValue = pre[rootIdx];
        int inRootIdx = 0;
        for(int i = s; i < e; i++) {
            if(in[i] == rootValue) {
                inRootIdx = i;
                break;
            }
        }

        int leftSize = inRootIdx - s;

        //후위 순회: 왼쪽 -> 오른쪽 -> 루트
        // 왼쪽 서브트리
        traversal(rootIdx + 1, s, inRootIdx);
        // 오른쪽 서브트리
        traversal(rootIdx + leftSize + 1, inRootIdx + 1, e);
        // 루트 출력
        sb.append(rootValue).append(" ");
    }
}
