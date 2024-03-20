#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    int n, m;
    cin >> n >> m;

    unordered_map<string, int> nameToNum;
    vector<string> numToName(n + 1);

    for (int i = 1; i <= n; i++) {
        string name;
        cin >> name;
        nameToNum[name] = i;
        numToName[i] = name;
    }

    for (int i = 0; i < m; i++) {
        string query;
        cin >> query;

        if (isdigit(query[0])) { // 숫자 쿼리 처리
            int num = stoi(query);
            cout << numToName[num] << '\n';
        } else { // 이름 쿼리 처리
            cout << nameToNum[query] << '\n';
        }
    }

    return 0;
}
