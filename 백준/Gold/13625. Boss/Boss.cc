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

int n, m, q;
vi ages;
map<int, int> employeesToVertex;
map<int, int> vertexToEmployees;
vii graph;

int youngestManager(int start) {
  int answer = inf;
  queue<int> q;
  q.push(start);
  vb visited(n + 1, false);
  
  while (q.size() != 0) {
    int p = q.front(); q.pop();

    for (auto next : graph[p]) {
      if (visited[next]) {
        continue;
      }

      visited[next] = true;
      answer = min(answer, ages[vertexToEmployees[next]]);
      q.push(next);
    }
  }
  
  return answer == inf ? -1 : answer;
}

void swap(int a, int b) {
  int aVertex = employeesToVertex[a];
  int bVertex = employeesToVertex[b];

  employeesToVertex[b] = aVertex;
  employeesToVertex[a] = bVertex;
  vertexToEmployees[aVertex] = b;
  vertexToEmployees[bVertex] = a;
}

void solve() {
  cin >> n >> m >> q;
  ages = vi(n + 1, 0);
  graph = vii(n + 1);

  for (int i = 1; i <= n; i++) {
    cin >> ages[i];
    employeesToVertex[i] = i;
    vertexToEmployees[i] = i;
  }

  for (int i = 0; i < m; i++) {
    int to, from; cin >> to >> from;
    graph[from].push_back(to);
  }

  for (int i = 0; i < q; i++) {
    string query; cin >> query;

    if (query == "T") {
      int first, second; cin >> first >> second;
      swap(first, second);
    } else {
      int employees; cin >> employees;
      int result = youngestManager(employeesToVertex[employees]);
      cout << (result == -1 ? "*" : to_string(result)) << "\n";
    }
  }
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	// freopen("input.txt", "r", stdin);
  solve();
	return 0;
}