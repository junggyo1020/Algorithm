#include<iostream>
#include<algorithm>

using namespace std;

int dp[501][501] = {0,}; //삼각형의 최대 경로 수의 합
int n;
int maxNum = 0;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;

    for(int i=0;i<n;i++){
        for(int j=0;j<=i;j++){
            cin >> dp[i][j];
        }
    }

    for(int i=0;i<n;i++){
        for(int j=0;j<=i;j++){
            if(j==0){
                dp[i][j] = dp[i][j] + dp[i-1][0];
            } else if(i==j){
                dp[i][j] = dp[i][j] + dp[i-1][j-1];
            } else{
                dp[i][j] = dp[i][j] + max(dp[i-1][j-1], dp[i-1][j]);
            }

            maxNum = max(maxNum, dp[i][j]); //최대 dp값 생성
        }
    }

    cout << maxNum;
}