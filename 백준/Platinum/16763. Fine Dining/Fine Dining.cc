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
typedef vector<vi> vii;
typedef vector<vii> viii;
typedef vector<viii> viiii;
typedef vector<ll> vl;
typedef vector<vl> vll;
typedef vector<vll> vlll;
typedef vector<vlll> vllll;
typedef vector<char> vc;
typedef vector<vc> vcc;
typedef vector<vcc> vccc;
typedef vector<vccc> vcccc;
typedef vector<bool> vb;
typedef vector<vb> vbb;
typedef vector<vbb> vbbb;
typedef vector<vbbb> vbbbb;
const ll INF = 1e18;
const int inf = 2e9;
const int size = 1 << 18;
const int mod = 1e9 + 7;

int n, m, h;
vlll graph;
vl haybales;
vl minimumCosts;
vll visited;
vi answer;

void getMinimumCosts() {
  minimumCosts = vl(n + 1, INF);
  queue<vl> q;
  q.push({n, 0});
  minimumCosts[n] = 0;
  
  while (q.size() != 0) {
    vl p = q.front(); q.pop();

    if (minimumCosts[p[0]] < p[1]) {
      continue;
    }
    
    for (vl next : graph[p[0]]) { // {index, cost}
      if (next[1] + p[1] < minimumCosts[next[0]]) {
        minimumCosts[next[0]] = next[1] + p[1];
        q.push({next[0], next[1] + p[1]});
      }
    }
  }
}

void getAnswer() {
  if (haybales[n] != 0) {
    answer = vi(n + 1, 1);
    return;
  }

  answer = vi(n + 1, 0);
  visited = vll(2, vl(n + 1, INF));
  queue<vl> q; 
  q.push({n, 0, 0});
  visited[0][n] = 0;
  
  while (q.size() != 0) {
    vl p = q.front(); q.pop();
    
    if (visited[p[2] != 0][p[0]] < p[1] - p[2] - 1) {
      continue;
    }

    for (vl next : graph[p[0]]) {
      ll nextHaybales = max(p[2], haybales[next[0]]);
      
      if (next[1] + p[1] - nextHaybales < visited[nextHaybales != 0][next[0]]) {
        visited[nextHaybales != 0][next[0]] = next[1] + p[1] - nextHaybales;
        q.push({next[0], next[1] + p[1], nextHaybales});
      }

      if (nextHaybales != 0 && (next[1] + p[1] - nextHaybales) <= minimumCosts[next[0]]) {
        answer[next[0]] = 1;
      }
    }
  }
}

void solve() {
  cin >> n >> m >> h;
  graph = vlll(n + 1);
  haybales = vl(n + 1, 0);
  
  for (int i = 0; i < m; i++) {
    int a, b, c; cin >> a >> b >> c;
    graph[a].push_back({b, c});
    graph[b].push_back({a, c});
  }

  for (int i = 0; i < h; i++) {
    int index; ll yummies; cin >> index >> yummies;
    haybales[index] = max(haybales[index], yummies);
  }

  getMinimumCosts();
  getAnswer();
  for (int i = 1; i < n; i++) {
    cout << answer[i] << "\n";
  }
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	// freopen("input.txt", "r", stdin);
  solve();
	return 0;
}