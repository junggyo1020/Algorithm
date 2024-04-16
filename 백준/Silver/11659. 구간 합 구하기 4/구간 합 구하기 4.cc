#include<iostream>
#include<vector>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0),cin.tie(0),cout.tie(0);
    int n,m,start,end,num;
    vector<int> data;
    cin >> n >> m;
    for(int i=0;i<n;i++){
        cin >> num;
        data.push_back(num);
    }

    vector<int> prefix(n,0);
    prefix[0] = data[0];

    for(int i=1;i<n;i++){
        prefix[i] = prefix[i-1] + data[i];
    }

    for(int i=0;i<m;i++){
        cin >> start >> end;
        cout << (start ==1 ? prefix[end-1]:prefix[end-1]-prefix[start-2])<< "\n";
    }

    return 0;
}