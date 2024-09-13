import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = new String[5];

        for (int i = 0; i < 5; i++) {
            line[i] = br.readLine();
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < line[j].length()) {
                    result.append(line[j].charAt(i));
                }
            }
        }

        System.out.println(result);
    }
}