#include <bits/stdc++.h>
#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int sum = 0;
    if(n&1){
        for(int i=n;i>=0;i-=2){
            sum += i;
        }
    } else {
        for(int i=n;i>=0;i-=2){
            sum += pow(i,2);
        }
    }
    return sum;
}