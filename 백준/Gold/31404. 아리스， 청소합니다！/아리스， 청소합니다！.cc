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
const ll INF = 1e18;
const int inf = 2e9;
const int SIZE = 1 << 18;
const int MOD = 1e9 + 7;

int h;
int w;

void printArray(vii& array) {
  for (int i = 0; i < array.size(); i++) {
    for (int j = 0; j < array[i].size(); j++) {
      cout << array[i][j] << "";
    }
    cout << "\n";
  }
}

int rotateDir(int originalDir, int rotate) {
  return (originalDir + rotate) % 4;
}

bool isOutOfRange(int y, int x) {
  return y < 0 || y >= h || x < 0 || x >= w;
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	// freopen("c.input.txt", "r", stdin);

  vi dx = {0, 1, 0, -1};
  vi dy = {-1, 0, 1, 0};
  cin >> h >> w;
  int y, x, dir; cin >> y >> x >> dir;
  
  vii A(h, vi(w, 0));
  vii B(h, vi(w, 0));

  for (int i = 0; i < h; i++) {
    string s; cin >> s;
    for (int j = 0; j < w; j++) {
      A[i][j] = s.at(j) - '0';
    }
  }

  for (int i = 0; i < h; i++) {
    string s; cin >> s;
    for (int j = 0; j < w; j++) {
      B[i][j] = s.at(j) - '0';
    }
  }
  
  int moveTime = 0;
  int zeroTime = 0;
  viii visited(4, vii(h, vi(w, 0)));
  vii isA(h, vi(w, 1));
  
  while (true) {
    if (isOutOfRange(y, x) || h * w <= visited[dir][y][x]) {
      break;
    }
    
    visited[dir][y][x]++;
    moveTime++;

    if (isA[y][x]) {
      zeroTime = 0;
      dir = rotateDir(dir, A[y][x]);
      isA[y][x] = 0;
    } else {
      zeroTime++;
      dir = rotateDir(dir, B[y][x]);
    }

    y += dy[dir];
    x += dx[dir];
  }
  
  cout << (moveTime - zeroTime) << "\n";
	return 0;
}