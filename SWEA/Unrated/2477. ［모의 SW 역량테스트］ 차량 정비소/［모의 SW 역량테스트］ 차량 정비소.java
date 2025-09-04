import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	// 고객 정보
	static class Customer {
		int id;                 // 고객 번호
		int arrivalTime;        // 도착 시간
		int receptionDeskId;    // 이용한 접수 창구 번호
		int repairDeskId;       // 이용한 정비 창구 번호
		int receptionFinishTime; // 접수 완료 시간

		public Customer(int id, int arrivalTime) {
			this.id = id;
			this.arrivalTime = arrivalTime;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 접수 창구 수
			int M = Integer.parseInt(st.nextToken()); // 정비 창구 수
			int K = Integer.parseInt(st.nextToken()); // 고객 수
			int A = Integer.parseInt(st.nextToken()); // 목표 접수 창구
			int B = Integer.parseInt(st.nextToken()); // 목표 정비 창구

			int[] receptionTimes = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				receptionTimes[i] = Integer.parseInt(st.nextToken());
			}

			int[] repairTimes = new int[M + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				repairTimes[i] = Integer.parseInt(st.nextToken());
			}

			// 모든 고객 정보를 리스트에 저장
			List<Customer> allCustomers = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= K; i++) {
				allCustomers.add(new Customer(i, Integer.parseInt(st.nextToken())));
			}

			Customer[] receptionDesks = new Customer[N + 1];
			int[] receptionFinishTimes = new int[N + 1];

			Customer[] repairDesks = new Customer[M + 1];
			int[] repairFinishTimes = new int[M + 1];

			// 접수 대기열: 고객 번호가 낮은 순서로 자동 정렬
			PriorityQueue<Customer> receptionQueue = new PriorityQueue<>((c1, c2) -> c1.id - c2.id);
			// 정비 대기열: 도착 순서대로 처리
			Queue<Customer> repairQueue = new LinkedList<>();

			int time = 0;
			int finishedCount = 0;
			int customerIndex = 0;

			// 모든 고객이 정비를 마칠 때까지 반복
			while (finishedCount < K) {

				// 1. 정비 창구에서 완료되는 고객 처리
				for (int i = 1; i <= M; i++) {
					if (repairDesks[i] != null && repairFinishTimes[i] == time) {
						repairDesks[i] = null;
						finishedCount++;
					}
				}

				// 2. 접수 창구에서 완료되는 고객 처리 -> 정비 대기열로 이동
				List<Customer> finishedReception = new ArrayList<>();
				for (int i = 1; i <= N; i++) {
					if (receptionDesks[i] != null && receptionFinishTimes[i] == time) {
						Customer customer = receptionDesks[i];
						customer.receptionFinishTime = time;
						finishedReception.add(customer);
						receptionDesks[i] = null;
					}
				}

				// 접수 창구 번호가 작은 순서대로 정렬하여 정비 대기열에 추가
				Collections.sort(finishedReception, (c1, c2) -> c1.receptionDeskId - c2.receptionDeskId);
				for (Customer customer : finishedReception) {
					repairQueue.add(customer);
				}


				// 3. 현재 시간에 도착한 고객을 접수 대기열에 추가
				while (customerIndex < K && allCustomers.get(customerIndex).arrivalTime == time) {
					receptionQueue.add(allCustomers.get(customerIndex));
					customerIndex++;
				}

				// 4. 빈 정비 창구에 고객 배정
				for (int i = 1; i <= M; i++) {
					if (repairDesks[i] == null && !repairQueue.isEmpty()) {
						Customer customer = repairQueue.poll();
						customer.repairDeskId = i;
						repairDesks[i] = customer;
						repairFinishTimes[i] = time + repairTimes[i];
					}
				}

				// 5. 빈 접수 창구에 고객 배정
				for (int i = 1; i <= N; i++) {
					if (receptionDesks[i] == null && !receptionQueue.isEmpty()) {
						Customer customer = receptionQueue.poll();
						customer.receptionDeskId = i;
						receptionDesks[i] = customer;
						receptionFinishTimes[i] = time + receptionTimes[i];
					}
				}

				time++;
			}

			int result = 0;
			for (Customer c : allCustomers) {
				if (c.receptionDeskId == A && c.repairDeskId == B) {
					result += c.id;
				}
			}

			if (result == 0) {
				result = -1;
			}

			System.out.println("#" + t + " " + result);
		}
	}
}