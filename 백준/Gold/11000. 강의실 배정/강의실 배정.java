import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static class Class implements Comparable<Class> {
        int s, e;

        Class(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Class o) {
            if(o.e == this.e) return this.s - o.s;
            return this.e - o.e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] lectures = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lectures, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        for (int[] lecture : lectures) {
            int startTime = lecture[0];
            int endTime = lecture[1];

            if (!pQ.isEmpty() && pQ.peek() <= startTime) {
                pQ.poll();
            }
            
            pQ.offer(endTime);
        }

        System.out.println(pQ.size());
    }
}