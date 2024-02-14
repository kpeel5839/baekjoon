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

struct comp {
  bool operator()(vl& o1, vl& o2) {
    if (o1[1] == o2[1]) {
      return o1[2] > o2[2];
    }
    return o1[1] > o2[1];
  }
};

int n, m, f, s, t;
vlll graph;

ll dijkstra() {
  vll dist(2, vl(n, INF));
  priority_queue<vl, vll, comp> q; 
  
  q.push({s, 0, 0});
  dist[0][s] = 0;
  
  while (q.size() != 0) {
    vl p = q.top(); q.pop();
    ll nowCity = p[0];
    ll nowCost = p[1];
    ll nowUseFlight = p[2];

    if (dist[nowUseFlight][nowCity] < nowCost) {
      continue;
    }

    if (nowCity == t) {
      return nowCost;
    }
    
    for (vl next : graph[nowCity]) {
      int countOfUseFlight = nowUseFlight + next[2];
      ll costIfSelectedThisWay = nowCost + next[1];
      ll nextDestination = next[0];

      if (2 <= countOfUseFlight) {
        continue;
      }
      
      if (costIfSelectedThisWay < dist[countOfUseFlight][nextDestination]) {
        dist[countOfUseFlight][nextDestination] = costIfSelectedThisWay;
        q.push({nextDestination, costIfSelectedThisWay, countOfUseFlight});
      }
    }
  }

  return -1;
}

void solve() {
  cin >> n >> m >> f >> s >> t;
  graph = vlll(n);
  
  for (int i = 0; i < m; i++) {
    ll a, b, cost; cin >> a >> b >> cost;
    graph[a].push_back({b, cost, 0});
    graph[b].push_back({a, cost, 0});
  }

  for (int i = 0; i < f; i++) {
    ll a, b; cin >> a >> b;
    graph[a].push_back({b, 0, 1});
  }

  cout << dijkstra();
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	//freopen("input.txt", "r", stdin);
  solve();
	return 0;
}