/**
 * 입력 처리: 각 케이스에 대해 의상의 수와 각 의상의 이름 및 종류를 입력받습니다.
 * 종류별 의상 수 계산: 각 종류별 의상의 개수를 세어서 저장.
 * 조합 계산: 각 종류별로 (해당 종류의 의상 수 + 1)을 모두 곱한 후, 아무것도 입지 않는 경우를 뺸다.
 */
#include <bits/stdc++.h>
using namespace std;
int main()
{
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);

    int t; // 테스트 케이스 수
    int n; // 의상의 수

    cin >> t;

    while (t--)
    {
        cin >> n;

        unordered_map<string, int> clothes; // 각 종류별 의상의 개수

        for (int i = 0; i < n; i++)
        {
            string name, type;
            cin >> name >> type;
            clothes[type]++;
        }

        int result = 1; // 경우의 수    
        for (auto &c : clothes)
        {
            result *= (c.second + 1);
        }

        cout << result - 1 << "\n";
    }
    return 0;
}