/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 4811                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/4811                           #+#        #+#      #+#    */
/*   Solved: 2024/04/12 23:35:02 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
using namespace std;

const int MAX_N = 30;
long long catalan[MAX_N + 1];

void precomputeCatalan() {
    catalan[0] = catalan[1] = 1;
    for (int i = 2; i <= MAX_N; i++) {
        catalan[i] = 0;
        for (int j = 0; j < i; j++) {
            catalan[i] += catalan[j] * catalan[i - j - 1];
        }
    }
}

int main() {
    precomputeCatalan();
    
    int N;
    while (cin >> N && N != 0) {
        cout << catalan[N] << endl;
    }
    
    return 0;
}
