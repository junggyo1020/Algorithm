import java.util.Scanner;

class Main {

    static int[] required = new int[4];
    static int[] current = new int[4];
    static int answer, count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int p = sc.nextInt();
        String str = sc.next();

        char[] arr = str.toCharArray();
        for (int i = 0; i < 4; i++) {
            required[i] = sc.nextInt();
            if(required[i] == 0) count++;
        }

        for (int i = 0; i < p; i++) {
            add(arr[i]);
        }

        answer = (count == 4) ? 1 : 0;

        for (int i = p; i < s; i++) {
            add(arr[i]);
            remove(arr[i-p]);
            if(count == 4) answer++;
        }

        System.out.println(answer);
    }

    static void add(char c) {
        int idx = getIndex(c);
        current[idx]++;
        if(current[idx] == required[idx]) count++;
    }

    static void remove(char c) {
        int idx = getIndex(c);
        if(current[idx] == required[idx]) count--;
        current[idx]--;
    }

    static int getIndex(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
            default:
                return -1;
        }
    }
}