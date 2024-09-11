import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //알파벳별 해당 숫자 지정하기
        int[] arr = {2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9};

        String[] ch = br.readLine().split("");
        int time = 0;
        for (int i = 0; i < ch.length; i++) {
            time += (arr[ch[i].charAt(0) - 'A'] + 1);
        }

        bw.write(time + "\n");

        bw.flush();
        bw.close();
    }
}