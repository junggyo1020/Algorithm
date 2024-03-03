#include <string>
#include <vector>

using namespace std;

vector<string> solution(vector<string> str_list) {
    bool is_left = false;
    int idx=-1;
    
    // 'l'또는'r' 중 먼저 오는 값 찾아 인덱스 값 저장하기
    for(int i=0;i<str_list.size();i++){
        if(str_list[i]=="l"){
            is_left = true;
            idx = i;
            break;
        }
        if(str_list[i]=="r"){
            is_left = false;
            idx = i;
            break;
        }
    }
    
    //l이나 r이 없을 경우 빈 리스트 리턴
    if(idx==-1) return{ };
    
    // 저장된 인덱스 값으로 조건에 맞게 리스트 저장하기
    if(is_left){
        return vector<string>(str_list.begin(),str_list.begin()+idx);
    } else {
        return vector<string>(str_list.begin()+idx+1,str_list.end());
    }
}