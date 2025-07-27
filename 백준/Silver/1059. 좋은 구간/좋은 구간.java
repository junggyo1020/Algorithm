import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        int[] s = new int[l];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < l; i++){
            s[i] = Integer.parseInt(st.nextToken());
        }
        int n = Integer.parseInt(br.readLine());

        Arrays.sort(s);

        for(int num : s){
            if(num == n){
                System.out.println(0);
                return;
            }
        }

        int s_small = 0;
        int s_big = 1001;

        for(int num : s){
            if (num < n) {
                s_small = num;
            } else {
                s_big = num;
                break;
            }
        }

        int left = n - s_small;
        int right = s_big - n;

        int ans = left * right - 1;
        System.out.println(ans);
    }
}
