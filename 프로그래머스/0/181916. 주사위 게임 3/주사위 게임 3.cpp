#include<bits/stdc++.h>

using namespace std;

int solution(int a, int b, int c, int d) {
    vector<int> v = {a,b,c,d};
    sort(v.begin(),v.end()); //1111 1112 1222 1122 1123 1223 1233 1234
    if(v[0]==v[3]) return 1111 * v[0]; //1111
    else if(v[0]==v[2]) return pow(10*v[0]+v[3],2); //1112
    else if(v[1]==v[3]) return pow(10*v[1]+v[0],2); //1222
    else if(v[0]==v[1])
    {
        if(v[2]==v[3]) return (v[0]+v[2])*abs(v[0]-v[2]); //1122
        else return v[2]*v[3]; //1123
    }
    else if(v[1]==v[2])
    {
        return v[0]*v[3]; //1223
    }
    else if(v[2]==v[3])
    {
        return v[0]*v[1]; // 1233
    }
    else //1234
    {
        int min = INT_MAX;
        for(int i=0;i<4;i++){
            if(v[i]<min) min = v[i];
        }
        return min;
    }
    
}