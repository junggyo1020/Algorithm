#include<iostream>
#include<queue>
#include<map>

using namespace std;

int ladder, snake, from, to;
int gameboard[101] = {0,}; //1-100까지 있는 보드판 0으로 초기화
bool visited[101]; //bfs 방문여부

int game(int start, int x){
    queue<pair<int,int>> q; // 현재위치, 주사위 던진 횟수 저장
    q.push({start,x});

    while(!q.empty()){
        int a = q.front().first;
        int b = q.front().second;
        q.pop();

        for(int i=1;i<=6;i++){ // 1부터 6까지 주사위 눈 선택해서 굴림
            int na = a + i; // 현재위치를 업데이트
            
            if(na>=100){
                return b+1;
            } // 100이상이 나온 경우 주사위 굴린횟수 증가후 push

            while(gameboard[na]!=0){
                na = gameboard[na]; // 현재위치 저장
            }

            if(visited[na]) continue; // 이미 방문한 경우 패스
            visited[na] = true;
            q.push({na,b+1}); 
        }
    }
     return -1; // 게임이 끝나지 않은 경우에 대한 기본값 반환
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> ladder >> snake;
    
    for(int i=0;i<ladder;i++){
        cin >> from >> to;
        gameboard[from] = to;
    }
    
    for(int i=0;i<snake;i++){
        cin >> from >> to;
        gameboard[from] = to;
    }

    cout << game(1,0);

    return 0;
}