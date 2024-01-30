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
typedef vector<vector<int> > vii;
typedef vector<vector<ll> > vll;
typedef vector<vector<vector<int> > > viii;
typedef vector<vector<vector<ll> > > vlll;
const ll INF = 1e18;
const int inf = 2e9;
const int SIZE = 1 << 18;
const int MOD = 1e9 + 7;

struct comp {
  bool operator()(vi& o1, vi& o2) {
    return o1[1] > o2[1];
  }
};

int dijkstra(vector<int>& non, vector<vector<int> >& graph, int startNode) {
  priority_queue<vi, vector<vi>, comp> q;
  vector<int> visited(non.size(), false);
  q.push({startNode, non[startNode]});
  int answer = 0;
  int visitedCount = 0;
  
  while (q.size() != 0 && visitedCount != non.size()) {
    vi vv = q.top();
    int node = vv[0]; int value = vv[1];
    q.pop();

    if (visited[node]) {
      continue;
    }
    
    visitedCount++;
    visited[node] = true;
    answer += value;

    for (int i = 0; i < non.size(); i++) {
      if (i == node) {
        continue;
      }
      
      if (visited[i]) {
        continue;
      }

      int cost = min(graph[node][i], non[i]);
      q.push({i, cost});
    }
  }

  return answer;
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
//	freopen("input.txt", "r", stdin);

  int n; cin >> n;
  int minNon = inf, minNonIndex = 0;  
  vector<int> non(n, 0);
  for (int i = 0; i < n; i++) {
    cin >> non[i];
    
    if (non[i] < minNon) {
      minNon = non[i];
      minNonIndex = i;
    }
  }
  
  vector<vector<int> > graph(n, vector<int>(n, 0));
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      cin >> graph[i][j];
    }
  }

  cout << dijkstra(non, graph, minNonIndex);
	return 0;
}