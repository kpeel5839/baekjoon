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
typedef vector<pii> vpii;
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

vpii teachers;
vcc m;
vi dx = {0, 1, 0, -1};
vi dy = {-1, 0, 1, 0};
int h;
int w;

void print() {
  for (auto v : teachers) {
    printf("(%d, %d)", v.first, v.second);
  }
}

bool isOutOfRange(int y, int x) {
  return y < 0 || y >= h || x < 0 || x >= w;
}

bool isWatchStudent(pii teacher) {
  for (int i = 0; i < 4; i++) {
    int y = teacher.first + dy[i];
    int x = teacher.second + dx[i];
    while (!isOutOfRange(y, x)) {
      if (m[y][x] == 'O') {
        break;
      }
      
      if (m[y][x] == 'S') {
        return true;
      }
      
      y += dy[i];
      x += dx[i];
    }
  }

  return false;
}

bool isPossibleHide(pii p1, pii p2, pii p3) {
  set<pii> set;
  set.insert(p1); set.insert(p2); set.insert(p3);

  if (set.size() != 3) {
    return false;
  }
  
  for (auto v : teachers) {
    if (isWatchStudent(v)) {
      return false;
    }
  }

  return true;
}

void solve() {
  int n; cin >> n;
  h = n, w = n;
  m = vcc(n, vc(n, ' '));
  
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      cin >> m[i][j];

      if (m[i][j] == 'T') {
        teachers.push_back({i, j});
      }
    }
  }

  for (int y1 = 0; y1 < n; y1++) {
    for  (int x1 = 0; x1 < n; x1++) {
      if (m[y1][x1] != 'X') {
        continue;
      }
      for (int y2 = 0; y2 < n; y2++) {
        for  (int x2 = 0; x2 < n; x2++) {
          if (m[y2][x2] != 'X') {
            continue;
          }
          for (int y3 = 0; y3 < n; y3++) {
            for  (int x3 = 0; x3 < n; x3++) {
              if (m[y3][x3] != 'X') {
                continue;
              }
              
              m[y1][x1] = 'O'; m[y2][x2] = 'O'; m[y3][x3] = 'O';
              
              if (isPossibleHide({y1, x1}, {y2, x2}, {y3, x3})) {
                cout << "YES";
                return;
              }

              m[y1][x1] = 'X'; m[y2][x2] = 'X'; m[y3][x3] = 'X';
            }
          }
        }
      }
    }
  }

  cout << "NO";
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	// freopen("input.txt", "r", stdin);
  // int T; cin >> T;
  // while (T-- > 0) {
  //   solve();
  // }
  solve();
	return 0;
}