import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 골 들어간 횟수
        int total_time = 48 * 60; // 총 시간
        int last_time = 0; // 최근 시간 저장
        int t1_time = 0; // 팀1이 리드한 시간
        int t2_time = 0; // 팀2가 리드한 시간
        int t1_score = 0; // 팀1 점수
        int t2_score = 0; // 팀2 점수

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int team = Integer.parseInt(input[0]);
            String[] input2 = input[1].split(":");
            int cur_time = Integer.parseInt(input2[0]) * 60 + Integer.parseInt(input2[1]); // 현재 시간

            if(t1_score > t2_score){
                t1_time += cur_time - last_time;
            } else if (t2_score > t1_score) {
                t2_time += cur_time - last_time;
            }

            if(team == 1){
                t1_score++;
            } else {
                t2_score++;
            }

            last_time = cur_time;
        }

        if(t1_score > t2_score){
            t1_time += total_time - last_time;
        } else if (t2_score > t1_score) {
            t2_time += total_time - last_time;
        }

        System.out.format("%02d:%02d\n", t1_time / 60, t1_time % 60);
        System.out.format("%02d:%02d\n", t2_time / 60, t2_time % 60);

    }
}
