import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double sum = 0;
        double cnt = 0;
        for (int i = 0; i < 20; i++) {
            String[] inputs = br.readLine().split(" ");
            //학점
            double score = Double.parseDouble(inputs[1]);

            //과목 평점(문자)
            String input = inputs[2];

            //과목 평점이 P인 경우 제외하고 계산
            if(input.equals("P")) continue;

            //과목 평점 변환
            double grade = 0;
            switch (input) {
                case "A+":
                    grade = 4.5;
                    break;
                case "A0":
                    grade = 4.0;
                    break;
                case "B+":
                    grade = 3.5;
                    break;
                case "B0":
                    grade = 3.0;
                    break;
                case "C+":
                    grade = 2.5;
                    break;
                case "C0":
                    grade = 2.0;
                    break;
                case "D+":
                    grade = 1.5;
                    break;
                case "D0":
                    grade = 1.0;
                    break;
                case "F":
                    grade = 0.0;
                    break;
                
            };

            //전공평점 (학점 * 과목평점)의 합
            sum += (score * grade);

            //학점의 총합
            cnt += score;
        }

        //전공 평점 구하기
        double avg = sum / cnt;
        bw.write(avg + "\n");

        bw.flush();
        bw.close();
    }
}