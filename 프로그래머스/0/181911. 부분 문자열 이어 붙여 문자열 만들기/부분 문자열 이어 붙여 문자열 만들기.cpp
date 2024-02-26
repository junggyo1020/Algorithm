#include <bits/stdc++.h>

using namespace std;

string solution(vector<string> my_strings, vector<vector<int>> parts) {
    string answer = "";
    for(int i=0;i<parts.size();i++){
        int s = parts[i][0], e = parts[i][1];
        answer += my_strings[i].substr(s,e-s+1);
    }
    return answer;
}