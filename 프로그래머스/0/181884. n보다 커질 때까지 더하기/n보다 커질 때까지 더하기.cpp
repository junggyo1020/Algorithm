#include <string>
#include <vector>

using namespace std;

int solution(vector<int> numbers, int n) {
    int answer = 0;
    for(auto c:numbers){
        if(answer>n) break;
        answer += c;
    }
    return answer;
}