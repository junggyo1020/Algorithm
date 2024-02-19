#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> num_list, int n) {
    vector<int> answer;
    int i = 1;
    for(auto c:num_list){
        if(i>=n) answer.push_back(c);
        i++;
    }
    return answer;
}