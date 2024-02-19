#include <string>
#include <vector>

using namespace std;

int solution(vector<int> num_list, int n) {
    int answer = 0;
    for(auto c : num_list){
        if(c==n){
            return 1;
        }
    }
    return 0;
}