import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] original;
    static int[] compressed;
    static HashMap<Integer, Integer> hM;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        original = new int[N];
        compressed = new int[N];
        hM = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            original[i] = Integer.parseInt(st.nextToken());
        } // 2 4 -10 4 -9

        int[] sortedArray = Arrays.stream(original).distinct().sorted().toArray(); // -10 -9 2 4

        for(int i = 0; i < sortedArray.length; i++) {
            hM.put(sortedArray[i], i);
        }

        for(int i = 0; i < N; i++) {
            compressed[i] = hM.get(original[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int x : compressed) {
            sb.append(x).append(" ");
        }
        sb.append("\n");

        System.out.println(sb);
    }
}
