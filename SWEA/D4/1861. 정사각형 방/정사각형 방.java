import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] room;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int roomNumber, maxMove;
	static int[][] memo;

	static final int[] dy = {-1, 1, 0, 0}; //상하좌우
	static final int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++){
			N = Integer.parseInt(br.readLine()); //N^2의 방
			room = new int[N][N];
			memo = new int[N][N];
			//방 정보 저장
			for(int i = 0; i < N; i++){
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++){
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			/**
			 * 해당 방 중심으로 상하좌우에 1 작은 방이 없다.
			 * => 시작점이 가능한 방
			 * => dfs 시작 가능
			 */
			maxMove = -1;
			roomNumber = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					boolean flag = false; //상하좌우에 1 작은방이 없다.
					for(int k = 0; k < 4; k++){
						int ny = i + dy[k];
						int nx = j + dx[k];
						if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
						if(room[ny][nx] == room[i][j] - 1){
							flag = true;
							break;
						}
					}
					//dfs 시작 가능
					if(!flag) {
						//TODO: dfs 중간에 최대 방 개수 갱신시 초기 위치를 불러오려면 어떻게 해야하지?
						//현재 방에서 시작했을 때의 이동 횟수 계산
						int currentMove = dfs(i, j);
						
						if(currentMove > maxMove){
							maxMove = currentMove;
							roomNumber = room[i][j];
						}

						else if(currentMove == maxMove){
							roomNumber = Math.min(roomNumber, room[i][j]);
						}

					}
				}
			}

			//TODO 결과 저장로직 추가해야함
			sb.append("#").append(t).append(" ").append(roomNumber).append(" ").append(maxMove).append("\n");
		}
		System.out.println(sb);
	}

	//(y, x)에서 출발해 이동할 수 있는 방의 최대 개수
	private static int dfs(int y, int x){
		//이미 계산한 적이 있으면 지정된 값 반환
		if(memo[y][x] != 0){
			return memo[y][x];
		}

		memo[y][x] = 1;

		for(int k = 0; k < 4; k++){
			int ny = y + dy[k];
			int nx = x + dx[k];

			if(ny >= 0 && ny < N && nx >= 0 && nx < N && room[ny][nx] == room[y][x] + 1){
				memo[y][x] += dfs(ny, nx);
				break;
			}
		}

		return memo[y][x];
	}
}
