import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        //1. 입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        //2. 티셔츠 묶음 개수 구하기
        int tCnt = 0;
        for (int x : arr) {
            if(x % t == 0) tCnt += x/t;
            else tCnt += (x/t + 1);
        }

        //3. 펜 묶음 개수 구하기
        int pCnt = n/p;

        //4. 펜 낱개 개수 구하기
        int pCnt2 = n - p*pCnt;

        //5. 출력부
        System.out.println(tCnt);
        System.out.println(pCnt + " " + pCnt2);
    }
}