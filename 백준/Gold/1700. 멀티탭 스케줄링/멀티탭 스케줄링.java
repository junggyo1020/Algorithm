import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {

    static int N, K;

    public static void main(String[] args) throws IOException {
        //1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //사용 순서 배열 저장
        int[] schedule = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            schedule[i] = Integer.parseInt(st.nextToken());
        }

        //멀티탭 초기화 => 방문여부만 체크할 것이기에 Set 선택(O(1))
        Set<Integer> multitap = new HashSet<>();
        int unplugCount = 0;

        //스케쥴에 따라 멀티탭에 하나씩 연결
        for (int i = 0; i < K; i++) {
            int cur = schedule[i]; //사용해야할 전자제품 종류

            //case1: 이미 꽃혀있는 전자제품
            if(multitap.contains(cur)) continue;

            //case2: 꽃혀있지 않지만, 콘센트에 빈자리가 있는 경우
            if (multitap.size() < N) {
                //멀티탭에 해당 전자제품 연결
                multitap.add(cur);
                continue;
            }

            //case3: 꽃혀있지 않고, 콘센트에 빈자리도 없는 경우
            //전체를 순회하면서 가장 나중에 사용되는 전자제품 찾기
            int lastUsed = -1;
            int victim = -1;

            unplugCount++; //하나 무조건 뽑기

            for (int x : multitap) {
                int nextUse = -1;
                for (int j = i + 1; j < K; j++) {
                    //만약 해당 전자제품을 찾으면, 값 갱신
                    if (schedule[j] == x) {
                        nextUse = j;
                        break;
                    }
                }

                //앞으로 사용되지 않는 기기
                if (nextUse == -1) {
                    victim = x;
                    break;
                }

                //더 나중에 사용하는 값으로 갱신
                if (nextUse > lastUsed) {
                    lastUsed = nextUse;
                    victim = x;
                }
            }
            //멀티탭에서 해당 번호 빼기
            multitap.remove(victim);
            multitap.add(cur);
        }
        System.out.println(unplugCount);
    }
}