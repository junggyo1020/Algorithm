#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> intStrs, int k, int s, int l) {
    vector<int> answer;
    for(auto c:intStrs){
        int num = stoi(c.substr(s,l));
        if(num > k){
            answer.push_back(num);
        }
    }
    return answer;
}