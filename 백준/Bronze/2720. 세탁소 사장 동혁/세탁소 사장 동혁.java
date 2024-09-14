import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] arr = {25, 10, 5, 1};
        int[] arr2 = new int[4];
        for (int i = 0; i < T; i++) {
            int C = Integer.parseInt(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr2[j] = C / arr[j];
                C %= arr[j];
            }
            for(int j : arr2){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}