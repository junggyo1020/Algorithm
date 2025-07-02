import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static int n, k;
    static long m;
    static PriorityQueue<Integer> valid_beer; //유효한 맥주의 선호도 저장

    static class Beer implements Comparable<Beer> {
        int v;
        long c; //v: 선호도, c: 도수레벨

        Beer(int v, long c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Beer o) {
            if(this.c == o.c) return o.v - this.v;
            return (int)(this.c - o.c);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //축제가 열리는 기간
        m = Long.parseLong(st.nextToken()); //채워야하는 선호도의 합
        k = Integer.parseInt(st.nextToken()); //마실 수 있는 맥주의 종류
        ArrayList<Beer> beers = new ArrayList<>(); //맥주 정보 저장
        PriorityQueue<Integer> pQ = new PriorityQueue<>(); //맥주 선호도 저장
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            beers.add(new Beer(v,c));
        }

        //맥주 정렬하기
        Collections.sort(beers);

        //간레벨 최솟값 찾기
        long answer = -1;
        long sum = 0;
        for (Beer beer : beers) {
            pQ.offer(beer.v);
            sum += beer.v;
            if(!pQ.isEmpty() && pQ.size() > n){
                int num = pQ.poll();
                sum -= num;
            }
            if (pQ.size() == n) {
                if (sum >= m) {
                    answer = beer.c;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}