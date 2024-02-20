#include <bits/stdc++.h>
#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int sum = 0;
    while(n>0){
        sum += (n&1) ? n:pow(n,2);
        n-=2;
    }
    return sum;
}