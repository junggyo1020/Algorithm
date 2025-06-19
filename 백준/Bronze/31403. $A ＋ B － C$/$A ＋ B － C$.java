import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        String sA = String.valueOf(a);
        String sB = String.valueOf(b);
        String sC = String.valueOf(c);

        System.out.println(a + b - c);
        System.out.println(Integer.parseInt(sA + sB) - Integer.parseInt(sC));
    }
}