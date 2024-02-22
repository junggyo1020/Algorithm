#include <string>
#include <vector>

using namespace std;

vector<int> solution(int l, int r) {
    vector<int> answer;
    string s = "";
    for(int i=l;i<=r;i++){ 
        s = to_string(i);
        if(s.find_first_not_of("05")==string::npos){ //0하고 5로만 이루어져 있는지!
            answer.push_back(i);
        }
    }
    if(answer.empty()) answer.push_back(-1);
    return answer;
}