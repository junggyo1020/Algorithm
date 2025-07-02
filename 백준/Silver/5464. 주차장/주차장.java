import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int n, m;
    static PriorityQueue<Integer> available_space;
    static Queue<Integer> waiting_queue;
    static int[] status, cost, weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        status = new int[m+1];
        cost = new int[n+1];
        weight = new int[m+1];
        available_space = new PriorityQueue<>();
        waiting_queue = new LinkedList<>();

        //비어있는 주차칸 저장(번호 낮은 순으로 주차하므로 우선순위 큐 사용)
        for (int i = 1; i <= n; i++) {
            available_space.offer(i);
        }

        //주차공간 별 단위무게당 요금정보 저장
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }

        //차량 종류 별 차량의 무게 정보 저장
        for (int i = 1; i <= m; i++) {
            weight[i] = Integer.parseInt(br.readLine());
        }

        //주차 정보 입력
        int answer = 0; //총 수입
        for (int i = 0; i < 2 * m; i++) {
            int car_number = Integer.parseInt(br.readLine());
            if (car_number > 0) {
                if (!available_space.isEmpty()) {
                    //비어있는 주차칸이 있는 경우 번호 낮은 순으로 주차
                    int space = available_space.poll(); //주차한 공간 번호
                    status[car_number] = space; //차량정보와 해당 차량이 주차한 공간 저장
                    answer += weight[car_number] * cost[space];
                } else {
                    //비어있는 주차칸이 없는 경우 대기열에 차량 번호 저장
                    waiting_queue.offer(car_number);
                }
            } else if (car_number < 0) {
                int livingCar = Math.abs(car_number);
                int emptySpace = status[livingCar];
                status[livingCar] = 0;

                if (!waiting_queue.isEmpty()) { //대기중인 차량이 있는 경우
                    int waiting_car = waiting_queue.poll();
                    status[waiting_car] = emptySpace;
                    answer += weight[waiting_car] * cost[emptySpace];
                } else {
                    //해당 차량 주차공간 빠져나감
                    available_space.offer(emptySpace); //주차 공간 사용 가능
                }
            }
        }

        System.out.println(answer);
    }
}