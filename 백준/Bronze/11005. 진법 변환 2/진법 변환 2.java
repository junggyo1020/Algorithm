import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        StringBuilder result = new StringBuilder();
        while (N > 0) {
            int remainder = N%B;
            if (remainder < 10) {
                result.append(remainder);
            } else {
                result.append((char)(remainder - 10 + 'A'));
            }
            N /= B;
        }

        System.out.println(result.reverse());
    }
}