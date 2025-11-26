import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] numbers;
    static boolean[] isExisted;
    static int[] scores;
    static final int MAX = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        scores = new int[MAX+1];
        isExisted = new boolean[MAX+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            isExisted[numbers[i]] = true;
        }

        //Naive한 접근 : 모든 조합을 검사하기
//        for(int i = 0; i < N; i++) {
//            for(int j = i+1; j < N; j++) {
//                if(numbers[i] % numbers[j] == 0) {
//                    //j 승리
//                    scores[j]++;
//                    scores[i]--;
//                } else if (numbers[j] % numbers[i] == 0) {
//                    //i 승리
//                    scores[i]++;
//                    scores[j]--;
//                }
//            }
//        }

        //O(NlogN) 접근 : 배수들만 확인
        for(int i : numbers) {
            for(int j = i * 2; j <= MAX; j += i) {
                if(isExisted[j]) {
                    scores[i]++;
                    scores[j]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int x : numbers) {
            sb.append(scores[x]).append(" ");
        }

        System.out.println(sb);

    }
}
