import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        //1. 입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //사람의 수
        int[] times = new int[n]; //사람이 돈을 인출하는 데 걸리는 시간
        int[] nSum = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        //2. 오름차순 정렬
        Arrays.sort(times);

        //3. 누적합 배열 구하기
        nSum[0] = times[0];
        for (int i = 1; i < n; i++) {
            nSum[i] = nSum[i-1] + times[i];
        }

        //4. 배열합 구하기
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += nSum[i];
        }

        //5. 결과 출력
        System.out.println(answer);
    }
}