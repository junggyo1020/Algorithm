#include <bits/stdc++.h>
#include <string>
#include <vector>

using namespace std;

int solution(string myString, string pat) {
    transform(myString.begin(),myString.end(),myString.begin(),::toupper);
    transform(pat.begin(),pat.end(),pat.begin(),::toupper);
    cout << myString << endl << pat;
    return (myString.find(pat) != string::npos) ? 1:0;
}