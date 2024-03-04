#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    for(auto c:queries){
        int s = c[0], e = c[1];
        for(int i=s;i<=e;i++){
            arr[i]++;
        }
    }
    return arr;
}