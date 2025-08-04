import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> crain = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			crain.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(crain, Collections.reverseOrder());
		
		int m = Integer.parseInt(br.readLine());
		List<Integer> box = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(box, Collections.reverseOrder());
		
		if(box.get(0) > crain.get(0)) {
			System.out.println(-1);
			return;
		}
		
		int time = 0;
		while(!box.isEmpty()) {
			int boxIdx = 0;
			for(int i = 0; i < crain.size();) {
				if(boxIdx == box.size()) break;
				
				if(crain.get(i) >= box.get(boxIdx)) {
					box.remove(boxIdx);
					i++;
				} else {
					boxIdx++;
				}
			}
			time++;
		}
		
		System.out.println(time);
	}
}
