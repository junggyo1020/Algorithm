#include <bits/stdc++.h>
using namespace std;

string solution(string my_string, vector<vector<int>> queries) {
    for(auto c:queries){
        int s = c[0], e = c[1];
        reverse(my_string.begin() + s, my_string.begin() + e + 1);
    }
    return my_string;
}