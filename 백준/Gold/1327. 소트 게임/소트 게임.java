import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class Main {

    static int N, K;
    static char[] initArr, sortedArr;

    //상태 횟수 구하기
    static class State {
        String value;
        int cnt;

        State(String value, int cnt) {
            this.value = value;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        //1. 입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        initArr = new char[N];
        sortedArr = new char[N];

        //2. initArr과 sortedArr 초기화 하기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            char tmp = st.nextToken().charAt(0);
            initArr[i] = tmp;
            sortedArr[i] = (char)((i + 1) + '0');
        }

        //3. 뒤집기 위해 String 형태로 변환
        String initState = new String(initArr);
        String targetState = new String(sortedArr);

        //4. 최소 연산횟수 구하기
        System.out.println(bfs(initState, targetState, N, K));
    }

    private static int bfs(String start, String target, int n, int k) {
        if(start.equals(target)) return 0;

        Queue<State> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add(new State(start, 0));
        visited.add(start);

        while (!q.isEmpty()) {
            State cur = q.poll();
            String cValue = cur.value;
            int cCnt = cur.cnt;

            for (int i = 0; i <= n - k; i++) {
                String nValue = reverseSubArray(cValue, i, i + k);

                if (!visited.contains(nValue)) {
                    if (nValue.equals(target)) {
                        return cCnt + 1;
                    }
                    visited.add(nValue);
                    q.add(new State(nValue, cCnt + 1));
                }
            }
        }
        return -1;
    }

    private static String reverseSubArray(String s, int start, int end) {
        StringBuilder sb = new StringBuilder(s.substring(start, end));
        sb.reverse();
        return s.substring(0, start) + sb + s.substring(end);
    }
}