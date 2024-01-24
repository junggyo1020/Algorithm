#include<iostream>
#include<queue>

#define endl '\n'
#define MAX 1001

using namespace std;

int n,m;
int days = -1;
bool flag = false;
int tomato[MAX][MAX];
int visited[MAX][MAX];
int dx[] = {1,0,-1,0};
int dy[] = {0,1,0,-1};

queue<pair<int,int>> q;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> m >> n;

    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            cin >> tomato[i][j]; //상자에 담긴 토마토 정보(1or0)
            visited[i][j] = -1; //처음에는 방문 x

            if(tomato[i][j]==1){
                q.push({i,j}); //토마토 있는 경우 큐에 추가
                visited[i][j]++; //방문했으므로 방문표시
            }
        }
    }

    while(!q.empty()){
        int a = q.front().first; //행 정보
        int b = q.front().second; //열 정보

        q.pop();

        for(int i=0;i<4;i++){ //4방향 탐색
            int na = a + dx[i];
            int nb = b + dy[i];
            if(na>=0 && nb>=0 && n>na && m>nb && visited[na][nb]==-1 && tomato[na][nb]==0){
                q.push({na,nb});
                visited[na][nb] = visited[a][b] + 1;
            }
        }
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(days<=visited[i][j]){
                days = visited[i][j];
            }
            if(tomato[i][j]==0 && visited[i][j]==-1){
                days=-1;
                flag=true;
                break;
            }
        }
        if(flag) break;
    }
    cout << days;
}