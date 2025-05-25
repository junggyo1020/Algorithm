import java.util.Scanner;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        TreeMap<Integer, Integer> tM = new TreeMap<>();

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int lt = 0, answer = 0;

        for (int rt = 0; rt < n; rt++) {
            tM.put(arr[rt], tM.getOrDefault(arr[rt], 0) + 1);

            while (tM.lastKey() - tM.firstKey() > 2) {
                tM.put(arr[lt], tM.get(arr[lt]) - 1);
                if(tM.get(arr[lt]) == 0) tM.remove(arr[lt]);
                lt++;
            }

            answer = Math.max(answer, rt - lt + 1);
        }

        System.out.println(answer);
    }
}