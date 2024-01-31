#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

/**
 * 너비 우선 탐색 (Bfs) 알고리즘 구현
 *
 * @details
 * 함수를 큐를 사용하여 너비 우선순위로 탐색
 * 거리 변수를 유지하여 현재 노드에서 방문한 노드까지의 거리를 추적
 *
 * @note
 * - 그래프는 'graph'로 표현되며 연결리스트로 구현
 * - 'visited' 배열은 방문한 노드를 표시하는데 사용
 * - 'num'은 최대거리에 있는 노드의 번호를 저장
 * - 'ansDist'는 헛간까지의 거리 저장
 * - 'ansCnt'는 같은 거리를 가지는 헛간의 개수 저장
*/
int N, M; // N:헛간의 개수
int num = 1; //숨어야 하는 헛간의 번호
int ansDist = 0; //헛간까지의 거리
int ansCnt = 0;
vector<int> graph[50001]; //bfs
vector<bool> visited(50001); //bfs visited


void bfs(){
    queue<pair<int, int>> q;
    q.push({1, 0}); // 노드 1에서 거리 0으로부터 BFS 시작.

    while(!q.empty()){
        int cur = q.front().first; // 현재 헛간 번호.
        int dist = q.front().second; // 시작 헛간으로부터의 거리.
        visited[cur] = true; // 현재 헛간을 방문했음을 표시.
        q.pop();

        // 현재 거리를 기반으로 변수 수정.
        if(dist > ansDist) {
            ansDist = dist;
            num = cur;
            ansCnt = 1;
        }
        else if(dist == ansDist){
            num = min(num, cur);
            ansCnt++;
        }

        // 현재 헛간의 주변 탐색.
        for(int i = 0; i < graph[cur].size(); i++){
            int next = graph[cur][i];
            if(!visited[next]){
                visited[next] = true; // 다음 헛간을 방문했음을 표시.
                q.push({next, dist+1});
            }
        }
    }
}

int main() {
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    cin >> N >> M;

    for(int i = 0; i < M; i++){
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
        graph[b].push_back(a);
    }

    bfs();

    cout << num << " " << ansDist << " " << ansCnt << '\n';

	return 0;
}