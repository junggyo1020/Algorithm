import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] houses = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(houses);
        int answerIdx = (N-1)/2; //중앙값이 가장 최대(Greedy)
        System.out.println(houses[answerIdx]);
    }
}
