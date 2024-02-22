#include <bits/stdc++.h>

/*

- for(const auto& c:queries): queries의 요소를 복사하지 않고 참조로 접근해요. 데이터를 수정할 수 없어서 안전하며, 큰 데이터에 효율적이에요.
- for(auto c:queries): queries의 각 요소를 복사해서 사용해요. 요소를 수정할 수 있지만, 큰 데이터일 경우 복사로 인한 비효율이 발생해요.
- for(const auto c:queries): #2와 비슷하지만, 복사된 요소를 수정할 수 없어요. 비효율적인 복사는 있지만 데이터는 보호돼요.
- for(auto& c:queries): queries의 요소를 복사하지 않고 참조로 접근해요. 데이터를 수정할 수 있어 유연하지만, 의도치 않은 데이터 변경의 위험이 있어요.
    
*/

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    vector<int> answer;
    for(const auto& c:queries){
        int s = c[0], e = c[1], k = c[2];
        int minVal = INT_MAX;
        bool found = false;
        for(int i=s;i<=e;i++){
            if(arr[i]>k && arr[i]<minVal){
                found = true;
                minVal = arr[i];
            }
        }
        if(found) answer.push_back(minVal);
        else answer.push_back(-1);
    }
    return answer;
}