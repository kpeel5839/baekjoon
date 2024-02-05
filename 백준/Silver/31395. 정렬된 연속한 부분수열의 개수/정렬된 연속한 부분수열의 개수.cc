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
	// freopen("b.input.txt", "r", stdin);
  
  int n; cin >> n;
  vi v(n + 1, 0);
  
  for (int i = 1; i <= n; i++) {
    cin >> v[i];
  }
  
  int count = 0;
  ll answer = 0;
  for (int i = 1; i <= n; i++) {
    if (v[i] <= v[i - 1]) {
      count = 0;
    }

    answer = answer + count + 1;
    count++;
  }

  cout << answer;
	return 0;
}