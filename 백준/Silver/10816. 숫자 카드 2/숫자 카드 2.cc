#include<iostream>
#include<unordered_map>
#include<vector>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0),cin.tie(0),cout.tie(0);
    int n,m,temp;
    cin >> n;
    unordered_map<int,int> cardCount;
    for(int i=0;i<n;i++){
        cin >> temp;
        cardCount[temp]++;
    }
    cin >> m;
    vector<int> results;
    for(int i=0;i<m;i++){
        cin >> temp;
        results.push_back(cardCount[temp]);
    }
    for(int count : results){
        cout << count << " ";
    } 
    cout << "\n";
    return 0;
}