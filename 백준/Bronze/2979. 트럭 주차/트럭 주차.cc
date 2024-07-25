#include <bits/stdc++.h>
using namespace std;

int main()
{
    int a, b, c, m, n;
    int result = 0;
    cin >> a >> b >> c;
    int price[101] = {0};
    for (int i = 0; i < 3; i++)
    {
        cin >> m >> n;
        for (int j = m; j < n; j++)
        {
            price[j]++;
        }
    }
    for (int i = 0; i < 101; i++)
    {
        if (price[i] == 1)
        {
            result += a;
        }
        else if (price[i] == 2)
        {
            result += (b * 2);
        }
        else if (price[i] == 3)
        {
            result += (c * 3);
        }
    }
    cout << result << "\n";
    return 0;
}