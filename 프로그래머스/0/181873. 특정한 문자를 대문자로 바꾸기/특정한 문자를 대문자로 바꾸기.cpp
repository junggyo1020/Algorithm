#include <string>
#include <vector>

using namespace std;

string solution(string my_string, string alp) {
    for(auto& c:my_string){
        for(int i=0;i<alp.length();i++){
            if(c==alp[i]){
                c = toupper(c);
            }
        }
    }
    return my_string;
}