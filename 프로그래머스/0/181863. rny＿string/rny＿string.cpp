#include <bits/stdc++.h>
#include <string>
#include <vector>
#include <regex>
 //단일 문자열과 문자열의 입력 추가 방식 차이 구분
using namespace std;

string solution(string rny_string) {
    string answer = "";
    answer = regex_replace(rny_string,regex("m"),"rn");
    // for(auto& c:rny_string){
    //     if( c=='m' ) answer += "rn";
    //     else answer.push_back(c);
    // }
    return answer;
}