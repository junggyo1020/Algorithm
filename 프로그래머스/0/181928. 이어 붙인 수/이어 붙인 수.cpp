#include <string>
#include <vector>

using namespace std;

int solution(vector<int> num_list) {
    int answer = 0;
    string odd_string = "";
    string even_string = "";
    
    for(auto c:num_list){
        if(c&1) odd_string += to_string(c);
        else even_string += to_string(c);
    }
    
    answer = stoi(odd_string) + stoi(even_string);
    return answer;
}