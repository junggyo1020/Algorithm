#include <bits/stdc++.h>
using namespace std;
int n, m;

int main(){
	int cnt=0;
	int sum=0;
	int a[15004];
	
	cin >> n;
	cin >> m;
	// 시작 요소 인덱스 
	int ptS=0;
	// 마지막 요소 인덱스  
	int ptE=n-1;
	
	for(int i=0; i<n; i++){
		cin >> a[i];
	}
	
	
	sort(a, a+n); 
	// sum 을 잘못사용. while 에서의 sum은 현재의 sum 을 복사해서 가져가 쓰므로 sum 이 갱신이 안된다 
	// sum = a[ptS]+a[ptE]; 대신 아래에서 if 조건 마다 직접 써주자 	
	// 앞의 포인터가 뒤의 포인터와 만나기 전까지 실행   
	while(ptS<ptE){
		if(a[ptS]+a[ptE]==m){
			cnt++;
			ptS++;
			ptE--;
		}
		if(a[ptS]+a[ptE]<m){
			ptS++;
		}
		if(a[ptS]+a[ptE]>m){
			ptE--;
		}
	}
	
	cout << cnt << "\n";
	
	return 0;
}