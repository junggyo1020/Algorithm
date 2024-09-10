import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int arr[] = new int[4];
        arr[2] = a * (b / 100);
        arr[1] = a * ((b % 100) / 10);
        arr[0] = a * ((b % 100) % 10);
        arr[3] = arr[2] * 100 + arr[1] * 10 + arr[0];

        for (int i : arr) {
            System.out.println(i);
        }


    }
}