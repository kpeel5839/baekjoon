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
    return o1[0] > o2[0];
  }
};

void solve() {
  int n; cin >> n;
  vll arr;
  priority_queue<vl, vll, comp> q; // {senitory, startTime, duringTime}

  for (int i = 0; i < n; i++) {
    int a, t; cin >> a >> t;
    arr.push_back({i, a, t});
  }
  
  sort(arr.begin(), arr.end(), [](vl& o1, vl& o2) {
    return o1[1] < o2[1];
  }); // {startTime, duringTime}
  
  ll nowTime = arr[0][1];
  ll answer = 0;
  int index = 0;

  while (true) {
    while (index != arr.size() && (q.size() == 0 || arr[index][1] <= nowTime)) {
      nowTime = max(nowTime, arr[index][1]);
      q.push({arr[index][0], arr[index][1], arr[index][2]}); index++;
    }
    
    vl value = q.top(); q.pop();
    answer = max(answer, nowTime - value[1]);
    nowTime += value[2];
    
    if (index == arr.size() && q.size() == 0) {
      break;
    }
  }
  
  cout << answer;
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	// freopen("input.txt", "r", stdin);
  solve();
	return 0;
}