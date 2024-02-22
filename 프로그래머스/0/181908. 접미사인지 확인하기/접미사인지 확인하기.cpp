#include <bits/stdc++.h>
using namespace std;

int solution(string my_string, string is_suffix) {
    /*
    접미사 특정 인덱스부터 시작하는 문자열인지 어떻게 알까?
    */
    auto idx = my_string.rfind(is_suffix);
    if(idx != string::npos && idx == my_string.length()-is_suffix.length()) 
        return 1;
    else 
        return 0;
}