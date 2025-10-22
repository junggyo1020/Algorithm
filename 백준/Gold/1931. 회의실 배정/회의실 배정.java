import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, answer;
    static StringTokenizer st;
    static List<Room> rooms;

    static class Room implements Comparable<Room>{
        int start, end;
        Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Room o) {
            if(this.end == o.end) return Integer.compare(this.start, o.start);
            return Integer.compare(this.end, o.end);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rooms = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            rooms.add(new Room(start, end));
        }

        Collections.sort(rooms);

        int lastEnd = 0; //가장 최근에 끝난 회의의 시간
        for(int i = 0; i < rooms.size(); i++) {
            //다음 회의의 시작시간이 지난 회의가 끝난 시간인 경우
            if(rooms.get(i).start >= lastEnd) {
                lastEnd = rooms.get(i).end;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
