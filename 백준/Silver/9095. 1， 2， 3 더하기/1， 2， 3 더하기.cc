/**
 * 두번째 문제
 * 알고리즘 분류 : DP
*/
#include<iostream>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    //점화식 d[n] = d[n-1] + d[n-2] + d[n-3]
    int a; // 입력하는 case갯수
    int n; // dp배열에 접근시 사용하는 index
    int dp[1001];

    cin >> a;

    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    //점화식
    for(int i=4;i<11;i++){
        dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
    }

    for(int i=0;i<a;i++){
        cin >> n;
        cout << dp[n] <<'\n';
    }
}