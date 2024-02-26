#include <string>
#include <vector>

using namespace std;

string solution(string my_string, vector<int> index_list) {
    string answer = "";
    for(auto c:index_list){
        answer += my_string[c];
    }
    return answer;
}