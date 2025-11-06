import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        // "S" 개수
        int cnt_S = 0;
        // "L" 개수
        int cnt_L = 0;

        for(char ch : str.toCharArray()){
            if(ch == 'S') cnt_S++;
            else cnt_L++;
        }
        int cnt_LL = cnt_L / 2;
        
        //사람 수를 넘기는 지 확인
        int result = cnt_LL + cnt_S + 1;
        if(result > str.length()) System.out.println(str.length());
        else System.out.println(result);
    }
}
