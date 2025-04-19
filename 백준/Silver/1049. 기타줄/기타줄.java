import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 6줄 패키지, 1개 또는 그 이상의 줄을 낱개로 구매 가능
 * 구매할 기타줄 개수 N개, M개의 브랜드, 패키지 가격, 낱개 가격
 *
 *
 */
class Main {

    static class Guitar implements Comparable<Guitar> {

        int p_cost, i_cost;

        Guitar(int p_cost, int i_cost) {
            this.p_cost = p_cost;
            this.i_cost = i_cost;
        }

        @Override
        public int compareTo(Guitar o) {
            if (this.p_cost == o.p_cost) {
                return this.i_cost - o.i_cost;
            }
            return this.p_cost - o.p_cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Guitar> arr = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new Guitar(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(arr);
        /**
         * 돈의 개수 최소로 만들기
         * 비교) 패키지로만 구매, 낱개로만 구매, 패키지&낱개 혼합 구매
         */
        int min_p_cost = Integer.MAX_VALUE;
        int min_i_cost = Integer.MAX_VALUE;
        for (Guitar o : arr) {
            min_p_cost = Math.min(min_p_cost, o.p_cost);
            min_i_cost = Math.min(min_i_cost, o.i_cost);
        }
        int answer = Math.min(n/6 * min_p_cost + n%6 * min_i_cost, Math.min(n * min_i_cost, (n+5)/6 * min_p_cost));
        System.out.println(answer);
    }
}