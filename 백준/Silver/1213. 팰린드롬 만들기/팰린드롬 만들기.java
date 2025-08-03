import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        
        //1. 알파벳 개수 카운트
        int[] cnt = new int[26];
        for (char c : str.toCharArray()) {
            cnt[c - 'A']++;
        }

        //2. 팰린드롬 생성 가능성 확인
        int addCount = 0;
        char centerChar = ' ';
        for(int i = 0; i < 26; i++){
            if(cnt[i] % 2 != 0){
                addCount++;
                centerChar = (char)('A' + i);
            }
        }
        
        //2-2. 불가능한 경우
        if (addCount > 1 || (str.length() % 2 == 0 && addCount > 0)) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        
        //3. 팰린드롬 생성
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < cnt[i] / 2; j++){
                sb.append((char)('A'+i));
            }
        }

        String firstStr = sb.toString(); //절반 저장
        String secondStr = sb.reverse().toString();
            
        if(addCount == 1){
            System.out.println(firstStr + centerChar + secondStr);
        } else {
            System.out.println(firstStr + secondStr);
        }
    }
}
