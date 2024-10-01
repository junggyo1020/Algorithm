import java.util.*;

public class Main {

    static HashMap<Integer, Integer> map = new LinkedHashMap<>();
    static int n,c;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            map.put(input, map.getOrDefault(input, 0 ) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a,b) -> {
            if(b.getValue().equals(a.getValue())){
                return 0;
            } else {
                return b.getValue() - a.getValue();
            }
        });

        for(Map.Entry<Integer, Integer> entry : list){
            int num = entry.getKey();
            int freq = entry.getValue();
            for (int i = 0; i < freq; i++) {
                System.out.print(num + " ");
            }
        }
    }
}
