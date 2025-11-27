import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long[] arr;
    static long bestSum = 3_000_000_001L;
    static long[] answer = new long[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 0; i < N-2; i++) {
            solve(i); //i번째 요소를 첫번째로 선택
        }

        Arrays.sort(answer);
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }

    private static void solve(int index) {
        int left = index + 1;
        int right = N - 1;

        while(left < right) {
            long sum = arr[index] + arr[left] + arr[right];
            long absSum = Math.abs(sum);

            if(absSum < bestSum) {
                bestSum = absSum;
                answer[0] = arr[index];
                answer[1] = arr[left];
                answer[2] = arr[right];
            }

            if(sum > 0) {
                right--;
            } else {
                left++;
            }
        }
    }
}
