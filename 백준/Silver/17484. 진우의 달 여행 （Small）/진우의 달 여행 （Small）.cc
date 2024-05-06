#include <iostream>
#include <vector>
#include <algorithm>
#include <limits.h>

using namespace std;

int numRows, numCols;
vector<vector<int>> fuelCostMatrix;

int dp[7][7][4][1000];
int directionOffsets[] = { -1, 0, 1 };

int findMinimumFuel(int row, int col, int lastDirection, int currentFuel)
{
    int minFuel = INT_MAX;

    if (row == numRows)
    {
        return currentFuel;
    }

    if (dp[row][col][lastDirection][currentFuel] != -1)
    {
        return dp[row][col][lastDirection][currentFuel];
    }

    for (int i = 0; i < 3; i++)
    {
        int newCol = col + directionOffsets[i];
        if (newCol >= 0 && newCol < numCols && i != lastDirection)
        {
            minFuel = min(minFuel, findMinimumFuel(row + 1, newCol, i, currentFuel + fuelCostMatrix[row][col]));
        }
    }

    dp[row][col][lastDirection][currentFuel] = minFuel;

    return dp[row][col][lastDirection][currentFuel];
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);

    cin >> numRows >> numCols;

    for (int i = 0; i < numRows; i++)
    {
        int inputCost;
        vector<int> rowCosts;
        for (int j = 0; j < numCols; j++)
        {
            cin >> inputCost;
            rowCosts.push_back(inputCost);
        }
        fuelCostMatrix.push_back(rowCosts);
    }

    fill(&dp[0][0][0][0], &dp[0][0][0][0] + 7 * 7 * 4 * 1000, -1);

    int result = INT_MAX;
    for (int i = 0; i < numCols; i++)
    {
        result = min(result, findMinimumFuel(0, i, 3, 0));
    }

    cout << result;

    return 0;
}
