#include <iostream>
#include <vector>
#include <algorithm>

/**
 * 불만도를 최소로 하는방법?
 * -> 정렬해주면 된다!(예상등수와 매칭하는 방식)
*/
using namespace std;

int N;
vector<int> v;
long long result = 0;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N; //전체 인원 수

    for(int i=0;i<N;i++) {
        int grade; //예상 등수
        cin >> grade;
        v.push_back(grade);
    }

    sort(v.begin(),v.end()); //오름차순 정렬

    for(int i=0;i<N;i++){
        result+=abs((i+1)-v[i]); //불만도
    }

    cout << result;
}
