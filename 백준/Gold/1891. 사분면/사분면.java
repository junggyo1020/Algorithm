import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        String s = sc.next();
        long dx = sc.nextLong();
        long dy = sc.nextLong();

        long size = 1L << d;
        long x = 0, y = 0;

        //좌표 이동
        for (int i = 0; i < d; i++) {
            long half = size >> (i + 1);
            char c = s.charAt(i);

            if (c == '1') {
                x += half;
            } else if (c == '3') {
                y += half;
            } else if (c == '4') {
                x += half;
                y += half;
            }
        }

        x += dx;
        y -= dy;

        //유효성 검사
        if (x < 0 || y < 0 || x >= size || y >= size) {
            System.out.println(-1);
            return;
        }

        //정해진 부분 만큼 이동한 값 구하기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < d; i++) {
            long newSize = size >> (i + 1);
            char c;
            if (x >= newSize && y < newSize) {
                c = '1';
                x -= newSize;
            } else if (x < newSize && y < newSize) {
                c = '2';
            } else if (x < newSize && y >= newSize) {
                c = '3';
                y -= newSize;
            } else {
                c = '4';
                x -= newSize;
                y -= newSize;
            }
            sb.append(c);
        }
        System.out.println(sb);
    }
}