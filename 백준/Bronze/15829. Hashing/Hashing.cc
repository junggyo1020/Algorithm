#include <iostream>
#include <string>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define endl "\n"
using namespace std;

const long long M = 1234567891;
const long long base = 31;

int L;
string s;

void input()
{
    cin >> L >> s;
}

long long doHash()
{
    long long hashValue = 0;
    long long powValue = 1; // 31^0 = 1에서 시작

    for (int i = 0; i < L; i++)
    {
        int idx = s[i] - 'a' + 1; // 고유번호 부여, 'a'는 1
        hashValue = (hashValue + (idx * powValue) % M) % M; // 해시 값 계산

        powValue = (powValue * base) % M; // 다음 거듭제곱 값을 계산
    }

    return hashValue;
}

int main()
{
    fastio;
    input();
    cout << doHash() << endl;
}
