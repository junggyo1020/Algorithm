#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    vector<int> answer;
    int i;
    for(auto c:queries){
        int s = c[0], e = c[1], k = c[2];
        for(int i=s;i<=e;i++){
            if(i%k==0) arr[i]++;
        }
    }
    return arr;
}