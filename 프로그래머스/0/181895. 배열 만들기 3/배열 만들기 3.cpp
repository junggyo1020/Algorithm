#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> intervals) {
    vector<int> answer;
    for(auto c:intervals){
        for(int i=c[0];i<=c[1];i++){
            answer.emplace_back(arr[i]);
        }
    }
    return answer;
}