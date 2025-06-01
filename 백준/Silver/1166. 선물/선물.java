    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    class Main {

        static int N, L, W, H;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            double lt = 0, rt = Math.min(Math.min(L, W), H);
            double mid = 0;
            for (int i = 0; i < 40; i++) { // log(10^9) < log(2^30) = 30 -> 40번 이내에 정밀도 1e-9
                mid = (lt + rt) / 2;
                if (is_promising(mid)) {
                    lt = mid;
                } else {
                    rt = mid;
                }
            }
            System.out.printf("%.10f\n", mid);
        }

        private static boolean is_promising(double mid) {
            return (long)(L/mid) * (long)(W/mid) * (long)(H/mid) >= N;
        }
    }