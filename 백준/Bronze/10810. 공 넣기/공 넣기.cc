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
#include <cstdio>
#include <cmath> 
#include <set>
#include <map>

using namespace std;
typedef long long ll;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef vector<bool> vb;
typedef vector<vector<int> > vii;
typedef vector<vector<ll> > vll;
typedef vector<vector<vector<int> > > viii;
typedef vector<vector<vector<ll> > > vlll;
const ll INF = 1e18;
const int inf = 2e9;
const int SIZE = 1 << 18;
const int MOD = 1e9 + 7;

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	// freopen("input.txt", "r", stdin);

  int n, m; cin >> n >> m;
  vi ball(n + 1, 0);
  for (int i = 0; i < m; i++) {
    int s, d, number; cin >> s >> d >> number;
    for (int j = s; j <= d; j++) {
      ball[j] = number;
    }
  }

  for (int i = 1; i <= n; i++) {
    cout << ball[i] << " ";
  }
	return 0;
}