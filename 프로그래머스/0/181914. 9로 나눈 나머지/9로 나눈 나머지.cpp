#include<bits/stdc++.h>

using namespace std;

int solution(string number) {
    int answer = 0,sum = 0;
    for(auto c:number){
        sum += c-'0';
    }
    answer = sum%9;
    return answer;
}