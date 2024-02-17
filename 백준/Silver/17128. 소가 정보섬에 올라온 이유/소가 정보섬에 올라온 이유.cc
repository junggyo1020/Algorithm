#include <iostream>
#include <vector>

#define endl "\n"

using namespace std;

int n, q; // 소의 수, 욱제가 장난칠 횟수
long long s = 0;

// S값 계산
long long calculateS(const vector<int> &v, int start)
{
    return 1LL * v[start] * v[(start + 1) % n] * v[(start + 2) % n] * v[(start + 3) % n];
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> q;    // 8,5
    vector<int> v(n); // v(8)

    for (int i = 0; i < n; i++)
    {
        cin >> v[i]; // v[0]=-2 v[1]=3 v[2]=5 v[3]=-6 v[4]=10 v[5]=-8 v[6]=7 v[7]=6
    }

    // 일단 변경사항이 없을 경우 S값 저장
    for (int i = 0; i < n; i++)
    {
        s += calculateS(v, i);
    }

    // 욱제가 장난친 소의 번호 저장
    vector<int> c(q); // c(5)
    for (int i = 0; i < q; i++)
    {
        cin >> c[i]; // c[0]=3 c[1]=5 c[2]=2 c[3]=7 c[4]=7
    }

    for (int i = 0; i < q; i++)
    {
        int index = c[i] - 1; // 변경할 인덱스 값 설정

        // 변경할 인덱스가 영향을 주는 곳만 일단 제외하고 계산
        for (int j = -3; j <= 0; j++)
        {
            int start = (index + j + n) % n;
            s -= calculateS(v, start);
        }

        // 영향을 주는 인덱스의 품질점수 변경
        v[index] *= -1;
        // 변경 후 영향을 주는 곳을 적용하여 s값 계산
        for (int j = -3; j <= 0; j++)
        {
            int start = (index + j + n) % n; // index+j가 음수가 될 수 있으므로 모듈로 연산 오류를 처리해줌(+n)
            s += calculateS(v, start);
        }
        // 변경된 최종 s값 출력
        cout << s << endl;
    }
}