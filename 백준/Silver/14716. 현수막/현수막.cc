/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 14716                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/14716                          #+#        #+#      #+#    */
/*   Solved: 2024/05/01 15:04:51 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <vector>
#include <deque>
using namespace std;
// 현수막
int main() {
	int n, m, answer = 0;
	int dx[8] = {-1, -1, 0, 1, 1, 1, 0, -1}, dy[8] = {0, 1, 1, 1, 0, -1, -1, -1};
	cin >> n >> m;
	vector<vector<int>> board(n, vector<int>(m)), vis(n, vector<int>(m, 0));
	for (int i=0; i<n; i++) {
		for (int j=0; j<m; j++) {
			cin >> board[i][j];
		}
	}
	for (int i=0; i<n; i++) {
		for (int j=0; j<m; j++) {
			if (board[i][j] && !vis[i][j]) {
				deque<pair<int, int>> dq;
				dq.push_back({i, j});
				vis[i][j] = ++answer;
				while (!dq.empty()) {
					pair<int, int> cur = dq.front();
					dq.pop_front();
					for (int dir=0; dir<8; dir++) {
						int nx = cur.first + dx[dir];
						int ny = cur.second + dy[dir];
						if (nx<0 || ny<0 || nx>=n || ny>=m) continue;
						if (!board[nx][ny] || vis[nx][ny]) continue;
						vis[nx][ny] = answer;
						dq.push_back({nx, ny});
					}
				}
			}
		}
	}
	cout << answer << "\n";
}