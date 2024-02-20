#include <bits/stdc++.h>
#include <string>
#include <vector>

using namespace std;

int solution(string myString, string pat) {
    string answer = "";
    string request = "";
    for(auto c:myString){
        answer.push_back(tolower(c));
    }
    for(auto t:pat){
        request.push_back(tolower(t));
    }
    cout << answer << endl << request;
    return (answer.find(request) != string::npos) ? 1:0;
}