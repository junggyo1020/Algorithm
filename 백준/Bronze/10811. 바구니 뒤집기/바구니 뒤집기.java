import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        //기존 배열 입력받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        for (int k = 0; k < m;k++) {
            String[] indices = br.readLine().split(" ");
            int i = Integer.parseInt(indices[0])-1;
            int j = Integer.parseInt(indices[1])-1;

            //i번째~j번째 바구니의 순서를 역순으로 만들기
           while(i < j){
               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
               i++;
               j--;
           }
        }

        for (int i : arr) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();

    }
}