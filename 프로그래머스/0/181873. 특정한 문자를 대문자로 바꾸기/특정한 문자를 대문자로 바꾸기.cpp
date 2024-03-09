#include <string>
#include <vector>

using namespace std;

string solution(string my_string, string alp) {
    for(auto& c:my_string){
        for(auto& a:alp){
            if(c==a){
                c = toupper(c);
            }
        }
    }
    return my_string;
}