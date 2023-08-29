#include<iostream>
#include<algorithm>
using namespace std;
int N, INF = 999999999;
bool arr[102][102];

void floyd() {
	for (int k = 1; k <= N; k++) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {	
				if (arr[i][k] && arr[k][j]) {
					arr[i][j] = true;
				}
			}
		}
	}
	bool flag = false;

	for (int i = 1; i <= N; i++) {
		if (arr[1][i] && arr[i][i]) flag = true;
	}
	if (flag) cout << "CYCLE";
	else cout << "NO CYCLE";
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;

	for (int i = 1; i <= N - 1; i++) {
		int cnt;
		cin >> cnt;

		for (int c = 0; c < cnt; c++) {
			int to;
			cin >> to;
			arr[i][to] = true;
		}
	}
	floyd();

}