#include<bits/stdc++.h>

using namespace std;

int arr[50];
bool check(int n);

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int n,m;
	cin >> n;
	for (int i = 0; i < n; i++)cin >> arr[i];
	cin >> m;

	for (int i = 0; i < n && 0 < m; i++) {
		int Max = -1, index = -1;
		for (int j = i; j<n && j <= i + m; j++) {
			if (Max < arr[j]) {
				Max = arr[j];
				index = j;
			}
		}
		for (int j = index; j > i; j--) {
			swap(arr[j - 1], arr[j]);
			m--;
		}
	}
	for (int i = 0; i < n; i++)cout << arr[i] << " ";
	return 0;
}