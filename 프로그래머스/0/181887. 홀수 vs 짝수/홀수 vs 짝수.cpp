#include <string>
#include <vector>

using namespace std;

int solution(vector<int> num_list) {
    int answer = 0; int odd = 0; int even = 0;
    for(int i=0;i<num_list.size();i++){
        if(i&1){ //홀수
            odd += num_list[i];
        } else { //짝수
            even += num_list[i];
        }
    }
    answer = max(odd,even);
    return answer;
}