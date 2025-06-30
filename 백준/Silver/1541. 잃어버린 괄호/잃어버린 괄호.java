import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split("-");

        int result = 0;

        for (int i = 0; i < parts.length; i++) {
            int sum = 0;
            String[] numbers = parts[i].split("\\+"); //정규표현식이므로 주의하자!
            for (String num : numbers) {
                sum += Integer.parseInt(num);
            }

            if (i == 0) {
                result += sum;
            } else {
                result -= sum;
            }
        }

        System.out.println(result);
    }
}