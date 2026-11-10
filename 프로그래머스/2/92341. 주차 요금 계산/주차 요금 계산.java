import java.util.*;

class Solution {
    static StringTokenizer st;
    
    public int[] solution(int[] fees, String[] records) {
		HashMap<String, String> parkingSpace = new HashMap<>(); //주차장(차량번호, 시각)
		TreeMap<String, Integer> timeForCar = new TreeMap<>(); //차량별 주차시간

		for(int i = 0; i < records.length; i++) {
			st = new StringTokenizer(records[i]);

			String time = st.nextToken();
			String carNum = st.nextToken();
			String op = st.nextToken();

			//입차
			if(op.equals("IN")) {
				//주차장 목록에 추가
				parkingSpace.put(carNum, time);
			}
			//출차
			else {
				//입차 정보 확인
				String in = parkingSpace.get(carNum);

				//주차시간 계산
				int diff = calDiff(time, in);

				//차량별 누적 주차시간 계산
				timeForCar.put(carNum, timeForCar.getOrDefault(carNum, 0) + diff);

				//계산 완료된 차량 제거
				parkingSpace.remove(carNum);
			}
		}

		//주차장에 남아있는 차량
		for(Map.Entry<String, String> car : parkingSpace.entrySet())  {
			//입차차량 정보
			String inNum = car.getKey();
			String inTime = car.getValue();

			int diff2 = calDiff("23:59", inTime);

			//차량별 누적 주차시간 계산
			timeForCar.put(inNum, timeForCar.getOrDefault(inNum, 0) + diff2);
		}

		//요금 정산
		int[] answer = new int[timeForCar.size()];
		int cnt = 0;
		for(Integer x : timeForCar.values()) {
			int sum = 0;

			if(x <= fees[0]) sum += fees[1];
			else {
				int num = x - fees[0];
				sum += (fees[1] + (num + fees[2] - 1)/fees[2] * fees[3]); //올림 공식
			}

			answer[cnt++] = sum;
		}

        return answer;
    }
	private static int calDiff(String out, String in) {
		int hOut = Integer.parseInt(out.substring(0, 2));
		int hIn = Integer.parseInt(in.substring(0, 2));
		int mOut = Integer.parseInt(out.substring(3));
		int mIn = Integer.parseInt(in.substring(3));

		return (hOut-hIn)*60 + (mOut-mIn);
	}
}

