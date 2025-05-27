import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = new BigInteger(sc.next());

        BigInteger lt = BigInteger.ZERO;
        BigInteger rt = new BigInteger("1000000000000000000"); //10^18 -> 2^60
        BigInteger answer = rt;

        while (lt.compareTo(rt) <= 0) {
            BigInteger mid = lt.add(rt).divide(BigInteger.TWO);
            if (mid.multiply(mid).compareTo(n) >= 0) {
                answer = mid;
                rt = mid.subtract(BigInteger.ONE);
            } else {
                lt = mid.add(BigInteger.ONE);
            }
        }

        System.out.println(answer);
    }
}
