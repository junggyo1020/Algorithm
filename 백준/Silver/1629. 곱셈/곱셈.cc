// 1629 곱셈
#include <iostream>

long long f(long long a, long long b,long long c){
    long long p = 0;
    long long res;

    if(b == 0){
        p = 1;
    } 
    else if(b%2 == 0){
        res = f(a, b/2, c);
        p = res*res%c;
    }else{
        res = f(a, b-1, c);
        p = res*a%c;
    }
    return p;
}
int main(){

    long long a, b, c;

    std::cin >> a;
    std::cin >> b;
    std::cin >> c;
    
    std::cout << f(a,b,c);

    
}

