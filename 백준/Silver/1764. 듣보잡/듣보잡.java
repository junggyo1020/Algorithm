import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 첫 줄 입력 받기
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 듣도 못한 사람의 이름을 저장할 HashSet
        HashSet<String> unheardSet = new HashSet<>();

        // 듣도 못한 사람의 이름 입력 처리
        for (int i = 0; i < N; i++) {
            unheardSet.add(sc.next());
        }

        // 보도 못한 사람의 이름을 저장할 HashSet
        HashSet<String> unseenSet = new HashSet<>();

        // 보도 못한 사람의 이름 입력 처리
        for (int i = 0; i < M; i++) {
            unseenSet.add(sc.next());
        }

        // 교집합 구하기
        unheardSet.retainAll(unseenSet);

        // 교집합의 크기 출력
        System.out.println(unheardSet.size());

        // 서전순으로 정렬된 교집합 출력
        unheardSet.stream().sorted().forEach(System.out::println);

        sc.close();
    }
}