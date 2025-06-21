import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static String[] arr;
    static int lastNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new String[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = br.readLine();
        }
        if (isNumber(arr[2])) {
            lastNum = Integer.parseInt(arr[2]);
        } else if (isNumber(arr[1])) {
            lastNum = Integer.parseInt(arr[1]) + 1;
        } else if (isNumber(arr[0])) {
            lastNum = Integer.parseInt(arr[0]) + 2;
        } else {
            lastNum = 0;
        }

        int next = lastNum + 1;
        System.out.println(numToStr(next));
    }

    private static boolean isNumber(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    private static String numToStr(int next) {
        if(next % 15 == 0) return "FizzBuzz";
        if(next % 3 == 0) return "Fizz";
        if(next % 5 == 0) return "Buzz";
        return String.valueOf(next);
    }
}