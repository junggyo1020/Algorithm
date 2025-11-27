import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int T, N, M;
    static int[] A, B;
    static ArrayList<Long> sumA, sumB;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        //부분합 구성하기
        sumA = new ArrayList<>();
        sumB = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            long sum = 0;
            for(int j = i; j < N; j++) {
                sum += A[j];
                sumA.add(sum);
            }
        }

        for(int i = 0; i < M; i++) {
            long sum = 0;
            for(int j = i; j < M; j++) {
                sum += B[j];
                sumB.add(sum);
            }
        }

        //정렬
        Collections.sort(sumA);
        Collections.sort(sumB);

        System.out.println(solve(sumA, sumB));
    }

    private static long solve(ArrayList<Long> listA, ArrayList<Long> listB) {
        int pa = 0;
        int pb = listB.size() - 1;
        long count = 0;

        while(pa < listA.size() && pb >= 0) {
            long valA = listA.get(pa);
            long valB = listB.get(pb);
            long sum = valA + valB;

            if(sum == T) {
                long countA = 0;
                long countB = 0;
                while(pa < listA.size() && listA.get(pa) == valA) {
                    countA++;
                    pa++;
                }

                while(pb >= 0 && listB.get(pb) == valB) {
                    countB++;
                    pb--;
                }

                count += countA * countB;
            }
            else if(sum < T) {
                pa++;
            }
            else {
                pb--;
            }
        }
        return count;
    }
}
