import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n, c;
    static HashMap<Integer, Integer> map = new LinkedHashMap<>(); // 순서를 보존하기 위해 LinkedHashMap 선택

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(input2[i]);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a, b) -> {
            return b.getValue() - a.getValue(); // 내림차순 정렬
        });

        // 결과 출력
        for(Map.Entry<Integer, Integer> entry : list){
            int num = entry.getKey();
            int freq = entry.getValue();
            for (int i = 0; i < freq; i++) {
                System.out.print(num + " ");
            }
        }
    }
}