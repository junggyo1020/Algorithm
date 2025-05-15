import java.util.HashMap;
import java.util.Scanner;

class Main {

    static long n, p, q;
    static HashMap<Long, Long> hM;

    private static long dp(long num) {
        if(num == 0) return 1;
        if(hM.containsKey(num)) return hM.get(num);
        long value = dp(num/p) + dp(num/q);
        hM.put(num, value);
        return value;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        p = sc.nextLong();
        q = sc.nextLong();

        /*
         * n값이 매우 크므로 배열 형식으로 저장 할 수 없음
         * -> 해시맵을 이용해 필요한 값만 저장하는 방식 사용!
         */
        hM = new HashMap<>();
        System.out.println(dp(n));
    }
}