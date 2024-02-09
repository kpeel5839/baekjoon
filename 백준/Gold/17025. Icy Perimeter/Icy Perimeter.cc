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
const int int_max = 2e9;
const int int_min = -2e9;
const int size = 1 << 18;
const int mod = 1e9 + 7;

int n;
vbb visited;
vcc m;
vi dx = {0, 1, 0, -1};
vi dy = {-1, 0, 1, 0};

void printarray(vcc& arr) {
  for (int i = 0; i < arr.size(); i++) {
    for (int j = 0; j < arr[i].size(); j++) {
      cout << arr[i][j] << "";
    }
    cout << "\n";
  }
}

bool isOutOfRange(int y, int x) {
  return y < 0 || y >= n || x < 0 || x >= n;
}

vi bfs(int y, int x) {
  queue<vi> q;
  q.push({y, x});
  visited[y][x] = true;
  int area = 0;
  int perimeter = 0;

  while (q.size() != 0) {
    vi p = q.front(); q.pop();
    area++;
    
    for (int i = 0; i < 4; i++) {
      int ny = p[0] + dy[i];
      int nx = p[1] + dx[i];
      
      if (isOutOfRange(ny, nx)) {
        perimeter++;
        continue;
      }

      if (visited[ny][nx]) {
        continue;
      }
      
      if (m[ny][nx] != '#') {
        perimeter++;
        continue;
      }
      
      q.push({ny, nx});
      visited[ny][nx] = true;
    }
  }

  return {area, perimeter};
}

void solve() {
  cin >> n;
  m = vcc(n, vc(n, ' '));
  visited = vbb(n, vb(n, false));
  
  for (int i = 0; i < n; i++) {
    string s; cin >> s;
    for (int j = 0; j < n; j++) {
      m[i][j] = s.at(j);
    }
  }

  vi answer = {int_min, int_max};
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (!visited[i][j] && m[i][j] == '#') {
        vi result = bfs(i, j);
        
        if (answer[0] <= result[0]) {
          if (answer[0] == result[0]) {
            if (answer[1] > result[1]) {
              answer[0] = result[0];
              answer[1] = result[1];
            }
            continue;
          }
          answer[0] = result[0];
          answer[1] = result[1];
        }
      }
    }
  }

  cout << answer[0] << " " << answer[1];
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	// freopen("input.txt", "r", stdin);
  solve();
	return 0;
}