#include <string>
#include <vector>

using namespace std;

int solution(vector<int> num_list) {
    int answer = 0;
    if(num_list.size()>=11){
        for(auto c : num_list)
            answer += c;
    } else {
        answer = 1;
        for(auto c : num_list){
            answer *= c;
        }
    }
    return answer;
}