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

void printArray(vcc& arr) {
  for (int i = 0; i < arr.size(); i++) {
    for (int j = 0; j < arr[i].size(); j++) {
      cout << arr[i][j] << "";
    }
    cout << "\n";
  }
}

int h, w;
ll l;
vcc m;
viii visited;
viii directions;
vi dx = {0, 1, 0, -1};
vi dy = {-1, 0, 1, 0};
vc dirToCharacter = {'N', 'E', 'S', 'W'};
map<char, int> characterToDir = {{'N', 0}, {'E', 1}, {'S', 2}, {'W', 3}};
vi initialPosition;
int dir;

bool isOutOfRange(int y, int x) {
  return y < 0 || y >= h || x < 0 || x >= w;
}

void setDirections() {
  directions = viii(4, vii(h, vi(w, 0)));

  for (int i = 0; i < h; i++) {
    for (int j = 0; j < w; j++) {
      for (int c = 0; c < 4; c++) {
        for (int add = 0; add < 4; add++) {
          int nDir = (c + add) % 4;
          int ny = i + dy[nDir];
          int nx = j + dx[nDir];
          
          if (isOutOfRange(ny, nx) || m[ny][nx] == '#') {
            continue;
          }
          
          directions[c][i][j] = nDir;
          break;
        }
      }
    }
  }
}

void bfs() {
  setDirections();
  int y = initialPosition[0];
  int x = initialPosition[1];
  ll moveCount = 0;

  while (true) {
    dir = directions[dir][y][x];
    y += dy[dir];
    x += dx[dir];
    moveCount++;
    ll loopCount = moveCount - visited[dir][y][x];
    
    if (moveCount == l || (visited[dir][y][x] != 0 && (l - moveCount) % loopCount == 0ll)) {
      cout << (y + 1) << " " << (x + 1) << " " << dirToCharacter[dir] << "\n";
      return;
    }

    visited[dir][y][x] = moveCount;
  }
}

void solve() {
  m = vcc(h, vc(w, ' '));
  visited = viii(4, vii(h, vi(w, 0)));
  
  for (int i = 0; i < h; i++) {
    string s; cin >> s;
    for (int j = 0; j < w; j++) {
      m[i][j] = s.at(j);
      
      if (m[i][j] != '#' && m[i][j] != '.') {
        initialPosition = {i, j};
        dir = characterToDir[m[i][j]];
        m[i][j] = '.';
      }
    }
  }

  bfs();
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	// freopen("input.txt", "r", stdin);
  while (true) {
    cin >> h >> w >> l;
    if (h == 0) {
      break;
    }
    solve();
  }
	return 0;
}