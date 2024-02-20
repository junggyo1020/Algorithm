#include <bits/stdc++.h>
#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, int k) {
    vector<int> answer;
    for(auto c:arr){
        (k&1) ? answer.push_back(c*k) : answer.push_back(c+k);
    }
    return answer;
}