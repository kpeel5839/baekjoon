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
  
  int n; cin >> n;
  vb visited(21, false);

  for (int i = 0; i < n; i++) {
    string operation; int value;
    cin >> operation;

    if (operation == "all") {
      visited = vb(21, true);
      continue;
    }

    if (operation == "empty") {
      visited = vb(21, false);
      continue;
    }

    cin >> value;
    
    if (operation == "add") {
      visited[value] = true;
    } else if (operation == "remove") {
      visited[value] = false;
    } else if (operation == "check") {
      cout << (visited[value] ? 1 : 0) << "\n";
    } else if (operation == "toggle") {
      visited[value] = !visited[value];
    }
  }

	return 0;
}