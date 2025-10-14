import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int L, C;
    static char[] chars;
    static char[] code;
    static StringBuilder sb = new StringBuilder();
    static final Set<Character> vowelsSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        chars = new char[C];
        code = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(chars);

        dfs(0, 0);

        System.out.print(sb);
    }

    static void dfs(int start, int depth) {
        if (depth == L) {
            if (isValid()) {
                for (char c : code) {
                    sb.append(c);
                }
                sb.append('\n');
            }
            return;
        }

        for (int i = start; i < C; i++) {
            code[depth] = chars[i];
            dfs(i + 1, depth + 1);
        }
    }

    static boolean isValid() {
        int vowels = 0;
        int consonants = 0;

        for (char c : code) {
            if (vowelsSet.contains(c)) {
                vowels++;
            } else {
                consonants++;
            }
        }

        return vowels >= 1 && consonants >= 2;
    }
}