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

viii graph;
int N, M, K;
vi H;
vi Y;

void dijkstra(int source, vi& dist) {
  queue<vi> q;
  q.push({source, 0});
  dist[source] = 0;

  while (q.size() != 0) {
    vi p = q.front(); q.pop();
    
    if (dist[p[0]] < p[1]) {
      continue;
    }

    for (vi next : graph[p[0]]) {
      if (next[1] + p[1] < dist[next[0]]) {
        dist[next[0]] = next[1] + p[1];
        q.push({next[0], next[1] + p[1]});
      }
    }
  }
}

void solve() {
  cin >> N >> M >> K;
  graph = viii(N + 1);
  vi originalDist(N + 1, inf);

  for (int i = 0; i < M; i++) {
    int a, b, c; cin >> a >> b >> c;
    graph[a - 1].push_back({b - 1, c});
    graph[b - 1].push_back({a - 1, c});
  }

  for (int i = 0; i < K; i++) {
    int haybales, yummies; cin >> haybales >> yummies;
    H.push_back(haybales - 1);
    Y.push_back(yummies);
  }

  dijkstra(N - 1, originalDist);
  vi dist(N + 1, inf);
  
  for (int i = 0; i < K; i++) {
    graph[N].push_back({H[i], originalDist[H[i]] - Y[i]});
  }

  dijkstra(N, dist);

  for (int i = 0; i < N - 1; i++) {
    cout << (dist[i] <= originalDist[i]) << "\n";
  }
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	// freopen("input.txt", "r", stdin);
  solve();
	return 0;
}