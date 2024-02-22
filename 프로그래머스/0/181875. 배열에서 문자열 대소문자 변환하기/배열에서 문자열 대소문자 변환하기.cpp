#include <bits/stdc++.h>

using namespace std;

vector<string> solution(vector<string> strArr) {
    vector<string> answer;
    string s;
    for(int i=0;i<strArr.size();i++){
        if(i&1){
            s = "";
            for(auto c:strArr[i]){
                s += toupper(c);
            }
            answer.push_back(s);
        } else {
            s = "";
            for(auto t:strArr[i]){
                s += tolower(t);
            }
            answer.push_back(s);
        }
    }
    return answer;
}