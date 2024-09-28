import java.util.Scanner;

class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (90 <= num) {
            System.out.println('A');
        } else if (80 <= num) {
            System.out.println('B');
        } else if (70 <= num) {
            System.out.println('C');
        } else if (60 <= num) {
            System.out.println('D');
        } else {
            System.out.println('F');
        }
    }
}