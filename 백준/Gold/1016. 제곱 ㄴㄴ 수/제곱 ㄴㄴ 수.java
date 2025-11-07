import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * max 값이 최대 1조를 넘어가는 매우 큰 값
 * 배열을 그대로 생성하는 것은 무리(1TB)
 * max - min이 100백만으로 매우 작은 특별한 문제
 * 배열을 max-min 크기로 관리하면 효율적으로 관리 가능
 */
public class Main {

    static boolean[] check;
    static long min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        int size = (int)(max-min) + 1;
        check = new boolean[size];

        for(long i = 2; i*i <= max; i++) {
            long square = i*i;
            long startNum = ((min + square - 1)/square)*square; //첫번쨰 제곱수 찾기
            for(long num = startNum; num <= max; num += square) {
                int index = (int)(num-min);

                if(check[index]) {
                    continue;
                }

                check[index] = true;
            }
        }

        int count = 0;
        for(int i = 0; i < size; i++) {
            if(!check[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
