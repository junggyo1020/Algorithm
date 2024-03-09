#include <string>
#include <vector>

using namespace std;
//조건에 맞게 수열을 변환하는 함수
void change_number(vector<int>& arr){
    for(auto& c:arr){
        if(c>=50 && c%2==0){
            c /= 2;
        }
        else if(c<50 && c%2==1){
            c = c*2 +1;
        }
    }
}
//arr(x) = arr(x+1)인지 확인하는 함수
bool check(const vector<int>& before, const vector<int>& after){
    for(int i=0;i<before.size();i++){
        if(before[i]!=after[i]) return false;
    }
    return true;
}

int solution(vector<int> arr) {
    int x = 0;
    while(1){
        vector<int> before = arr;
        change_number(arr);
        x++;
        
        if(check(before,arr)){
            break;
        }
    }
    
    return x-1;
}