import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		//플러그 사용 순서 & 횟수 저장
		int[] schedule = new int[k]; // 플러그 사용 순서 저장
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < k; i++) {
			schedule[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> multitap = new ArrayList<>(); // 멀티탭 사용현황
		int unplugCnt = 0; //플러그 뽑은 횟수
		for(int i = 0; i < k; i++) {
			int curDevice = schedule[i];
			
            //case1: 이미 해당 플러그가 꽃혀있는 경우
			if(multitap.contains(curDevice)) {
				//바로 넘어간다
				continue;
            }
            
			//case2: 플러그 여유가 있는 경우
			if(multitap.size() < n) {
				//바로 꽃는다
				multitap.add(curDevice);
				continue;
			}
				
			//case3: 플러그 여유가 없는 경우
			int unplugDevice = -1; //뽑을 콘센트
			int farthestIdx = -1; //가장 나중에 사용되는 콘센트
				
			//가장 나중에 사용되는 콘센트를 찾는다
			for(int cur : multitap) {
				int nextIdx = Integer.MAX_VALUE;
				for(int j = i+1; j < k; j++) {
					if(schedule[j] == cur) {
						nextIdx = j;
						break;
					}
				}
				
				//아예 사용되지 않는다면, 바로 그 기기를 뽑는다
				if(nextIdx == Integer.MAX_VALUE) {
					unplugDevice = cur;
					break;
				}
				
                //나중에 사용하는 기기 인덱스 갱신
				if(nextIdx > farthestIdx) {
					farthestIdx = nextIdx;
					unplugDevice = cur;
				}
			}
			
			multitap.remove(Integer.valueOf(unplugDevice));
			multitap.add(curDevice);
			unplugCnt++;
		}
		System.out.println(unplugCnt);
	}
}
