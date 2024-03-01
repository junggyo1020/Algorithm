#include <string>
#include <vector>

using namespace std;

vector<int> solution(string my_string) {
    vector<int> answer(52,0);
    for(auto ch:my_string){
        if('a' <= ch && ch <= 'z'){
            answer[26 + ch - 'a']++;
        }
        if('A' <= ch && ch <= 'Z'){
            answer[ch - 'A']++;
        }
    }
    return answer;
}