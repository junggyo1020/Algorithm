#include <string>
#include <vector>

using namespace std;

vector<int> solution(int start, int end_num) {
    vector<int> answer;
    for(int i=start;i>=end_num;i--){
        answer.emplace_back(i);
    }
    return answer;
}