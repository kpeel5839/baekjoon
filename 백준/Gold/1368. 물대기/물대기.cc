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

int find(int x, vi& parent) {
  if (parent[x] == x) {
    return x;
  }
  
  parent[x] = find(parent[x], parent);
  return parent[x];
}

void executeUnion(int a, int b, vi& parent) {
  parent[b] = a;
}

struct comp {
  bool operator()(vi& o1, vi& o2) {
    return o1[2] > o2[2];
  }
};

vi makeVector(int a, int b, int c) {
  vi v;
  v.push_back(a);
  v.push_back(b);
  v.push_back(c);
  return v;
}

int bfs(int startNode, vi& non, vii& graph, vi& parent) {
  priority_queue<vi, vii, comp> q; 
  int answer = non[startNode];
  
  for (int i = 0; i < graph[startNode].size(); i++) {
    if (i == startNode) {
      continue;
    }

    q.push(makeVector(startNode, i, min(graph[startNode][i], non[i])));
  }
  
  while (q.size() != 0) {
    vi p = q.top(); q.pop();
    int set1 = find(p[0], parent); int set2 = find(p[1], parent);

    if (set1 == set2) {
      continue;
    }

    executeUnion(set1, set2, parent);
    answer += p[2];

    for (int i = 0; i < non.size(); i++) {
      if (i == p[1]) {
        continue;
      }

      q.push(makeVector(p[1], i, min(graph[p[1]][i], non[i])));
    }
  }
  
  return answer;
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

  int n; cin >> n;
  int minNon = inf;
  int minNonIndex = 0;
  vi non(n, 0);

  for (int i = 0; i < n; i++) {
    cin >> non[i];

    if (non[i] < minNon) {
      minNon = non[i];
      minNonIndex = i; 
    }
  }

  vii graph(n, vi(n, 0));
  
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      cin >> graph[i][j];
    }
  }
  
  vi parent(n, 0);

  for (int i = 1; i < n; i++) {
    parent[i] = i;
  }
  
  cout << bfs(minNonIndex, non, graph, parent);
	return 0;
}