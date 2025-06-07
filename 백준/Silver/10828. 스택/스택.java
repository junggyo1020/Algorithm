import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> st = new Stack<>();
        for (int test_case = 0; test_case < n; test_case++) {
            String cmd = sc.next();
            switch(cmd) {
                case "push":
                    int num = sc.nextInt();
                    st.push(num);
                    break;
                case "pop":
                    if (st.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(st.pop());
                    break;
                case "size" :
                    System.out.println(st.size());
                    break;
                case "empty" :
                    if (st.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "top" :
                    if (st.isEmpty()) {
                        System.out.println(-1);
                        break;
                    } else {
                        System.out.println(st.peek());
                        break;
                    }
            }
        }
    }
}