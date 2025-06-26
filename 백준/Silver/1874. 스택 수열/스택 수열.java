import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        int num = 1;
        boolean isPossible = true;
        for (int i = 0; i < n; i++) {
            int target = arr[i];

            while (num <= target) {
                st.push(num++);
                sb.append("+\n");
            }

            if (target == st.peek()) {
                sb.append("-\n");
                st.pop();
            } else {
                isPossible = false;
                break;
            }
        }

        System.out.println(isPossible ? sb : "NO");

    }
}