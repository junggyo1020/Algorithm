/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2877                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2877                           #+#        #+#      #+#    */
/*   Solved: 2024/03/08 16:12:08 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <vector>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define endl "\n"

using namespace std;

vector<int> binaryVec;

void convertToBinary(int number);

int main() {
	int inputNumber;
	cin >> inputNumber;

	convertToBinary(inputNumber + 1);

	for (int index = 1; index < binaryVec.size(); index++) {
		if (binaryVec[index] == 0)
			printf("4");
		else
			printf("7");
	}
}

void convertToBinary(int number) {
    fastio;
    vector<int> tempVec;

    while (number >= 1) {
		tempVec.push_back(number % 2);
		number /= 2;
	}

	for (int i = tempVec.size() - 1; i >= 0; i--) {
		binaryVec.push_back(tempVec[i]);
	}
}

