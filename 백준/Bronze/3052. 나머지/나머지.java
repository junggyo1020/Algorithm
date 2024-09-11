import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //0~41까지 나머지를 저장하는 배열
        boolean[] nums = new boolean[42];

        //이를 42로 나눈 나머지를 저장한다.
        for (int i = 0; i < 10; i++) {
            int m = Integer.parseInt(br.readLine()) % 42;
            //나머지에 해당하는 인덱스에 체크표시
            nums[m] = true;
        }

        //서로 다른 값이 몇 개 있는지 출력한다.
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]){
                cnt++;
            }
        }

        bw.write(cnt + "\n");

        bw.flush();
        bw.close();

    }
}