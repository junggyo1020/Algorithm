#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> num_list, int n) {
    vector<int> answer;
    //num_list에서 n번째 원소 이후의 원소 저장
    for(int i=n;i<num_list.size();i++){
        answer.emplace_back(num_list[i]);
    }
    //num_list에서 n이전까지의 원소 추가
    for(int i=0;i<n;i++){
        answer.emplace_back(num_list[i]);
    }
    return answer;
}