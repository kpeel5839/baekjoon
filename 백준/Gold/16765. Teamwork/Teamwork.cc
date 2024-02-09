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
typedef vector<vector<vector<vector<int> > > > viiii;
typedef vector<vector<vector<ll> > > vlll;
typedef vector<vector<vector<vector<ll> > > > vllll;
typedef vector<bool> vb;
typedef vector<vector<bool> > vbb;
typedef vector<vector<vector<bool> > > vbbb;
typedef vector<vector<vector<vector<bool> > > > vbbbb;
typedef vector<char> vc;
typedef vector<vector<char> > vcc;
typedef vector<vector<vector<char> > > vccc;
typedef vector<vector<vector<vector<char> > > > vcccc;
const ll INF = 1e18;
const int inf = 2e9;
const int size = 1 << 18;
const int mod = 1e9 + 7;

void printarray(vii& arr) {
  for (int i = 0; i < arr.size(); i++) {
    for (int j = 0; j < arr[i].size(); j++) {
      cout << arr[i][j] << "";
    }
    cout << "\n";
  }
}

int n, k;
vi arr;
vii maxOfelements;
vii dp;

int dfs(int index, int kk) {
  if (index == n) {
    return 0;
  }
  
  if (dp[kk][index] != -1) { 
    return dp[kk][index];
  }
  
  if (kk == k) {
    return dp[kk][index] = dfs(index + 1, 1) + maxOfelements[index - kk + 1][kk] * kk;
  }
  return dp[kk][index] = max(dfs(index + 1, kk + 1), dfs(index + 1, 1) + maxOfelements[index - kk + 1][kk] * kk);
}

void setMaxOfElements() {
  maxOfelements = vii(n, vi(k + 1, 0));
  
  for (int i = 0; i < n; i++) {
    int maxValue = 0;
    for (int j = i; j < i + k; j++) {
      maxValue = max(maxValue, arr[j]);
      maxOfelements[i][j - i + 1] = maxValue;
    }
  }
}

void solve() {
  cin >> n >> k;
  dp = vii(k + 1, vi(n, -1));
  
  for (int i = 0; i < n; i++) {
    int v; cin >> v; arr.push_back(v);
  }
  
  setMaxOfElements();
  cout << dfs(0, 1);
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	// freopen("input.txt", "r", stdin);
  solve();
	return 0;
}