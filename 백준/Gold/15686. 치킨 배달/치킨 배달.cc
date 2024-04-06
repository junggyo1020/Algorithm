/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 15686                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/15686                          #+#        #+#      #+#    */
/*   Solved: 2024/04/06 23:29:50 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <climits>
#include <vector>
#include <algorithm>
using namespace std;

int N, M;
vector<pair<int, int>> chickens, houses;

int calculateDistance(vector<pair<int, int>> &selectedChickens)
{
    int totalDistance = 0;
    for (auto &house : houses)
    {
        int distance = INT_MAX;
        for (auto &chicken : selectedChickens)
        {
            distance = min(distance, abs(house.first - chicken.first) + abs(house.second - chicken.second));
        }
        totalDistance += distance;
    }
    return totalDistance;
}

int main()
{
    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            int temp;
            cin >> temp;
            if (temp == 1)
                houses.push_back({i, j});
            else if (temp == 2)
                chickens.push_back({i, j});
        }
    }

    vector<int> combination(chickens.size(), 1);
    fill(combination.begin(), combination.begin() + chickens.size() - M, 0);
    int minDistance = INT_MAX;

    do
    {
        vector<pair<int, int>> selectedChickens;
        for (int i = 0; i < combination.size(); i++)
        {
            if (combination[i] == 1)
            {
                selectedChickens.push_back(chickens[i]);
            }
        }
        minDistance = min(minDistance, calculateDistance(selectedChickens));
    } while (next_permutation(combination.begin(), combination.end()));

    cout << minDistance << endl;
    return 0;
}
