import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ('a' <= ch && ch <= 'z') {
                arr[ch - 'a']++;
            } else {
                arr[ch - 'A']++;
            }
        }

        int max = -1;
        int max_idx = -1;
        for (int i = 0; i < 26; i++) {
            if(max < arr[i]){
                max = arr[i];
                max_idx = i;
            }
        }

        int cnt = 0;
        int result = 65;
        boolean flag = false;
        for (int i = 0; i < 26; i++) {
            if(arr[i] == max){
                cnt++;
            }
            if(cnt > 1){
                flag = true;
                break;
            }
        }
        if(flag){
            bw.write("?" + "\n");
        } else {
            result += max_idx;
            bw.write((char)result + "\n");
        }


//        for (int i : arr) {
//            bw.write(i + " ");
//        }
//        bw.write("\n" + max);

        bw.flush();
        bw.close();
    }
}