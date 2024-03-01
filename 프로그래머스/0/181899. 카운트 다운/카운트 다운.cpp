#include <string>
#include <vector>

using namespace std;

vector<int> solution(int start, int end_num) {
    vector<int> answer;
    int cnt = start;
    while(1){
        if(cnt==end_num){
            answer.push_back(cnt); break;   
        }
        answer.push_back(cnt);
        cnt--;
    }
    return answer;
}