/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2240                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2240                           #+#        #+#      #+#    */
/*   Solved: 2024/03/31 23:16:30 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int T, W;
    cin >> T >> W;
    vector<vector<int>> dp(T+1, vector<int>(W+1, 0));
    vector<int> drops(T+1);

    for(int t = 1; t <= T; t++) {
        cin >> drops[t];
    }

    for(int t = 1; t <= T; t++) {
        for(int w = 0; w <= W; w++) {
            if(w == 0) { // 위치 변경 없음
                dp[t][w] = dp[t-1][w] + (drops[t] == 1 ? 1 : 0);
            } else {
                int stay = dp[t-1][w] + (drops[t] == (w % 2) + 1 ? 1 : 0);
                int move = dp[t-1][w-1] + (drops[t] == (w % 2) + 1 ? 1 : 0);
                dp[t][w] = max(stay, move);
            }
        }
    }

    int answer = 0;
    for(int w = 0; w <= W; w++) {
        answer = max(answer, dp[T][w]);
    }
    cout << answer << endl;

    return 0;
}
