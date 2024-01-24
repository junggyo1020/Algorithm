#include<iostream>
#include<algorithm>

using namespace std;

int n,t[1001],p[1001],dp[1001]; //남은 날짜, 시간, 수익, 최대수익

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n; //남은 날짜

    for(int i=0;i<n;i++){
        cin >> t[i] >> p[i]; //n일 동안의 시간(t), 수익(p) 입력
    }

    for(int i=n-1;i>=0;i--){
        int end = i+t[i]; //상담이 끝나는 날짜
        if(end<=n){
            dp[i] = max(dp[end]+p[i], dp[i+1]);
        } else {
            dp[i] = dp[i+1];
        }
    }

    cout << dp[0];
}