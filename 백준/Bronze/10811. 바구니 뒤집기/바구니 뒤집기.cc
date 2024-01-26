#include <algorithm>
#include <sstream>
#include <iostream>
#include <string>
#include <vector>
#include <utility>
#include <unordered_set>
#include <unordered_map>
#include <queue>
#include <stack>
#include <deque>
#include <string.h>

using namespace std;
typedef long long ll;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
const ll INF = 1e18;
const int inf = 2e9;
const int SIZE = 1 << 18;
const int MOD = 1e9 + 7;

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	
	int n, m;
	cin >> n >> m;
	vector<int> arr;
	
	for (int i = 0; i < n; i++) {
		arr.push_back(i + 1);
	}
	
	for (int i = 0; i < m; i++) {
		int a, b; 
		cin >> a >> b;
		vector<int> v;

		for (int j = b; a <= j; j--) {
			v.push_back(arr[j - 1]);
		}
		
		for (int i = a; i <= b; i++) {
			arr[i - 1] = v[i - a];
		}
	}

	for (auto v : arr) {
		cout << v << " ";
	}
	
	return 0;
}
