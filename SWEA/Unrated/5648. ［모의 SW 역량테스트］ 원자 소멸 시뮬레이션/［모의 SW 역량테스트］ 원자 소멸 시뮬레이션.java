import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    static class Atom {
        int x, y;
        int dir;
        int energy;
        boolean isDead;

        public Atom(int x, int y, int dir, int energy) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.energy = energy;
            this.isDead = false;
        }
    }

    static class Collision implements Comparable<Collision> {
        double time;
        int atom1Index, atom2Index;

        public Collision(double time, int atom1Index, int atom2Index) {
            this.time = time;
            this.atom1Index = atom1Index;
            this.atom2Index = atom2Index;
        }

        @Override
        public int compareTo(Collision other) {
            return Double.compare(this.time, other.time);
        }
    }

    static int[] dx = {0, 0, -1, 1}; // 상, 하, 좌, 우
    static int[] dy = {1, -1, 0, 0}; // 상, 하, 좌, 우
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            List<Atom> atoms = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                atoms.add(new Atom(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            int totalEnergy = solve(N, atoms);
            System.out.printf("#%d %d\n", t, totalEnergy);
        }
    }

    public static int solve(int N, List<Atom> atoms) {
        PriorityQueue<Collision> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                Atom a1 = atoms.get(i);
                Atom a2 = atoms.get(j);

                double time = -1;

                // 1. 같은 수직선(x축)에서 충돌
                if (a1.x == a2.x) {
                    if ((a1.y > a2.y && a1.dir == 1 && a2.dir == 0) || (a1.y < a2.y && a1.dir == 0 && a2.dir == 1)) {
                        time = (double) Math.abs(a1.y - a2.y) / 2.0;
                    }
                }
                // 2. 같은 수평선(y축)에서 충돌
                else if (a1.y == a2.y) {
                    if ((a1.x > a2.x && a1.dir == 2 && a2.dir == 3) || (a1.x < a2.x && a1.dir == 3 && a2.dir == 2)) {
                        time = (double) Math.abs(a1.x - a2.x) / 2.0;
                    }
                }
                // 3. 교차 충돌 (대각선 충돌)
                else {
                    // 한 원자는 x축으로, 다른 원자는 y축으로 이동
                    if ((a1.dir == 2 || a1.dir == 3) && (a2.dir == 0 || a2.dir == 1)) {
                        // 두 원자가 만나는 지점을 예상하고 시간이 같은지 확인
                        double time1 = (double) Math.abs(a1.x - a2.x);
                        double time2 = (double) Math.abs(a1.y - a2.y);
                        if (Double.compare(time1, time2) == 0) {
                            if ((a1.x < a2.x && a1.dir == 3) || (a1.x > a2.x && a1.dir == 2)) {
                                if ((a2.y < a1.y && a2.dir == 0) || (a2.y > a1.y && a2.dir == 1)) {
                                    time = time1;
                                }
                            }
                        }
                    } else if ((a1.dir == 0 || a1.dir == 1) && (a2.dir == 2 || a2.dir == 3)) {
                        double time1 = (double) Math.abs(a1.x - a2.x);
                        double time2 = (double) Math.abs(a1.y - a2.y);
                        if (Double.compare(time1, time2) == 0) {
                            if ((a1.y < a2.y && a1.dir == 0) || (a1.y > a2.y && a1.dir == 1)) {
                                if ((a2.x < a1.x && a2.dir == 3) || (a2.x > a1.x && a2.dir == 2)) {
                                    time = time1;
                                }
                            }
                        }
                    }
                }

                if (time > 0) {
                    pq.add(new Collision(time, i, j));
                }
            }
        }

        int totalEnergy = 0;
        
        while (!pq.isEmpty()) {
            double currentTime = pq.peek().time;
            
            Set<Integer> currentCollisionIndices = new HashSet<>();
            while (!pq.isEmpty() && Double.compare(pq.peek().time, currentTime) == 0) {
                Collision c = pq.poll();
                if (!atoms.get(c.atom1Index).isDead && !atoms.get(c.atom2Index).isDead) {
                    currentCollisionIndices.add(c.atom1Index);
                    currentCollisionIndices.add(c.atom2Index);
                }
            }
            
            if (!currentCollisionIndices.isEmpty()) {
                for (int index : currentCollisionIndices) {
                    Atom atom = atoms.get(index);
                    totalEnergy += atom.energy;
                    atom.isDead = true;
                }
            }
        }
        return totalEnergy;
    }
}