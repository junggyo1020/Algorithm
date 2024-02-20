#include <string>
#include <vector>
#include <numeric>

using namespace std;

string solution(vector<string> arr) {
    string answer = "";
    answer = accumulate(arr.begin(),arr.end(),string(""));
    return answer;
}