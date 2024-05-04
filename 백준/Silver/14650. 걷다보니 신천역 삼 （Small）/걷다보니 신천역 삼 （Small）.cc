#include <iostream>
#include <vector>
#include <string>

using namespace std;

int count = 0;  // 3의 배수인 숫자의 개수를 세는 변수

// 깊이 우선 탐색을 통해 숫자 조합을 만듦
void dfs(string number, int N) {
    if (number.length() == N) {
        int sum = 0;
        for (char ch : number) {
            sum += (ch - '0');
        }
        if (sum % 3 == 0) {  // 합이 3의 배수인지 확인
            count++;
        }
        return;
    }

    // 다음 자릿수를 추가하며 탐색
    vector<char> digits = {'0', '1', '2'};
    for (char digit : digits) {
        if (number.empty() && digit == '0') continue;  // 첫 자리가 0이 되지 않도록 함
        dfs(number + digit, N);
    }
}

int main() {
    int N;
    cin >> N;

    // 숫자는 0으로 시작할 수 없으므로 1과 2로 시작하는 경우만 첫 호출
    dfs("1", N);
    dfs("2", N);

    cout << count << endl;

    return 0;
}
