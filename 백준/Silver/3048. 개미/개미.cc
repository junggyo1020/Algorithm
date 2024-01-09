/**
 * 세번째 문제풀이
 * 알고리즘 분류 - 구현
*/
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n1,n2,t;
    cin >> n1 >> n2;
    vector<pair<char, int>> v;
    string s;

    cin >> s;
    for(int i=n1-1;i>=0;i--){
        v.push_back({s[i], 0});
    }

    cin >> s;
    for(int i=0;i<n2;i++){
        v.push_back({s[i], 1});
    }

    cin >> t;
    int cnt = 0;

    while(cnt != t){
        for(int i=0;i<n1+n2-1;i++){
            if(v[i].second == 0 && v[i+1].second == 1){
                swap(v[i],v[i+1]);
                i++;
            }
        }
        cnt++;
    }

    for(int i=0;i<n1+n2;i++){
        cout << v[i].first;
    }
}
