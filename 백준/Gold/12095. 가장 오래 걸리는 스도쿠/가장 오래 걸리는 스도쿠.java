public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append("0 ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}