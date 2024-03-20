#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main() {
    int N, M;
    cin >> N >> M;
    
    vector<int> indegree(N+1, 0); // 각 과목에 대한 진입 차수
    vector<vector<int>> graph(N+1); // 선수 과목 그래프
    vector<int> semester(N+1, 0); // 각 과목을 이수하는데 필요한 최소 학기 수
    
    for (int i = 0; i < M; i++) {
        int A, B;
        cin >> A >> B;
        graph[A].push_back(B);
        indegree[B]++;
    }
    
    queue<int> q;
    // 진입 차수가 0인 노드(선수 과목이 없는 과목)를 큐에 삽입
    for (int i = 1; i <= N; i++) {
        if (indegree[i] == 0) {
            q.push(i);
            semester[i] = 1; // 선수 과목이 없으므로 1학기에 이수 가능
        }
    }
    
    // 위상 정렬
    while (!q.empty()) {
        int now = q.front();
        q.pop();
        
        for (int i = 0; i < graph[now].size(); i++) {
            int next = graph[now][i];
            indegree[next]--;
            
            if (indegree[next] == 0) {
                q.push(next);
                semester[next] = semester[now] + 1; // 다음 과목은 현재 과목의 다음 학기에 이수 가능
            }
        }
    }
    
    // 결과 출력
    for (int i = 1; i <= N; i++) {
        cout << semester[i] << ' ';
    }
    
    return 0;
}
