#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    while (true) {
        string str;
        int n;
        
        // 입력 받기
        cin >> str >> n;
        
        // EOF 처리
        if (cin.eof()) {
            break;
        }

        // 문자열을 벡터에 저장
        vector<char> v(str.begin(), str.end());
        
        // 초기 인덱스 설정
        int index = 1;
        bool valid = false;

        // 순열을 사전 순으로 정렬
        sort(v.begin(), v.end());

        // 순열을 생성하고 해당 위치의 순열 찾기
        do {
            if (index == n) {
                cout << str << ' ' << n << " = ";
                for (int i = 0; i < v.size(); i++) {
                    cout << v[i];
                }
                cout << '\n';
                valid = true;
                break;
            }
            index++;
        } while (next_permutation(v.begin(), v.end()));

        // 순열이 없는 경우 출력
        if (!valid) {
            cout << str << ' ' << n << " = No permutation" << '\n';
        }
    }
    return 0;
}
