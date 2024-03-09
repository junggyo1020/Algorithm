#include <string>
#include <vector>

using namespace std;
// 숫자를 변경
int change_number(vector<int>& num_list){
    int cnt = 0;
    for(auto& c:num_list){
        while(1){
            if(c==1) break;
            if(c&1){
                c = (c-1)/2;
                cnt++;
            } else {
                c /= 2;
                cnt++;
            }
        }
    }
    return cnt;
}

int solution(vector<int> num_list) {
    return change_number(num_list);
}