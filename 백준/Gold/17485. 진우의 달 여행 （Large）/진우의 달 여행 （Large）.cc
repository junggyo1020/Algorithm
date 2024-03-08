/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 17485                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: jungyo1020 <boj.kr/u/jungyo1020>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/17485                          #+#        #+#      #+#    */
/*   Solved: 2024/03/08 16:47:58 by jungyo1020    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
#include <iostream>
#include <vector>
#include <algorithm>
#include <limits.h>
#define fastio ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0)
#define endl "\n"

using namespace std;

int rows, cols;
vector<vector<int>> terrainMap;
vector<vector<vector<int>>> cost;
int minimumCost = INT_MAX;

bool isValidPosition(int row, int col)
{
    return (0 <= row && row < rows) && (0 <= col && col < cols);
}

void findMinimumCost()
{
    for (int row = 1; row < rows; row++)
    {
        for (int col = 0; col < cols; col++)
        {
            if (isValidPosition(row - 1, col + 1))
                cost[row][col][0] = min(cost[row - 1][col + 1][1], cost[row - 1][col + 1][2]) + terrainMap[row][col];

            if (isValidPosition(row - 1, col))
                cost[row][col][1] = min(cost[row - 1][col][0], cost[row - 1][col][2]) + terrainMap[row][col];

            if (isValidPosition(row - 1, col - 1))
                cost[row][col][2] = min(cost[row - 1][col - 1][0], cost[row - 1][col - 1][1]) + terrainMap[row][col];
        }
    }

    for (int col = 0; col < cols; col++)
    {
        for (int k = 0; k < 3; k++)
        {
            minimumCost = min(minimumCost, cost[rows - 1][col][k]);
        }
    }
}

int main()
{
    cin >> rows >> cols;

    terrainMap.assign(rows, vector<int>(cols));
    cost.assign(rows, vector<vector<int>>(cols, vector<int>(3, INT_MAX)));

    for (int row = 0; row < rows; row++)
    {
        for (int col = 0; col < cols; col++)
        {
            cin >> terrainMap[row][col];
            if (row == 0)
            {
                cost[row][col][0] = cost[row][col][1] = cost[row][col][2] = terrainMap[row][col];
            }
        }
    }

    findMinimumCost();
    cout << minimumCost << endl;
}
