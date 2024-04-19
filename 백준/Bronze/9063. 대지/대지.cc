#include <iostream>
#include <vector>
#include <limits>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int N;
    cin >> N;
    int minX = numeric_limits<int>::max();
    int maxX = numeric_limits<int>::min();
    int minY = numeric_limits<int>::max();
    int maxY = numeric_limits<int>::min();

    for (int i = 0; i < N; i++) {
        int x, y;
        cin >> x >> y;
        if (x < minX) minX = x;
        if (x > maxX) maxX = x;
        if (y < minY) minY = y;
        if (y > maxY) maxY = y;
    }

    // 넓이 계산
    int width = maxX - minX;
    int height = maxY - minY;
    int area = width * height;

    cout << area << "\n";

    return 0;
}
