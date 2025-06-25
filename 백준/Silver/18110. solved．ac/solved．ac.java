import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int k = (int) Math.round(N * 0.15);
        int sum = 0;
        for (int i = k; i < N - k; i++) {
            sum += arr[i];
        }
        int result = (int)Math.round((double) sum / (N - 2 * k));
        System.out.println(result);
    }
}