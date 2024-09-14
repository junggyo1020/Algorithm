import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());  // 입력된 X번째
        
        int diagonal = 1;  // 대각선 번호
        int sum = 0;       // 1 + 2 + 3 + ... 값
        
        // X가 속한 대각선 찾기
        while (sum + diagonal < X) {
            sum += diagonal;
            diagonal++;
        }
        
        int positionInDiagonal = X - sum;  // 해당 대각선 내에서 X번째
        
        int numerator, denominator;
        // 대각선 번호가 홀수인 경우
        if (diagonal % 2 == 1) {
            numerator = diagonal - (positionInDiagonal - 1);
            denominator = positionInDiagonal;
        } 
        // 대각선 번호가 짝수인 경우
        else {
            numerator = positionInDiagonal;
            denominator = diagonal - (positionInDiagonal - 1);
        }
        
        System.out.println(numerator + "/" + denominator);
    }
}
