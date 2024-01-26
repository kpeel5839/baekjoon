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

using namespace std;
typedef long long ll;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
const ll INF = 1e18;
const int inf = 2e9;
const int SIZE = 1 << 18;
const int MOD = 1e3;

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

  int a, b, c, n;
  cin >> a >> b >> c >> n;

  vector<ll> add(n + c + 1, 0);
  vector<ll> deadCount(n + c + 1, 0);

  ll bugCount = 1;
  ll nowBornCount = 0;
  add[a]++;
  add[b]--;
  deadCount[c]++;

  for (int i = a; i <= n; i++) {
    nowBornCount = (nowBornCount + add[i]) % INF;
    add[i + a] = (add[i + a] + nowBornCount) % MOD;
    add[i + b] = (add[i + b] - nowBornCount) % MOD;
    deadCount[i + c] = (deadCount[i + c] + nowBornCount) % MOD;
    bugCount += nowBornCount % INF;
    bugCount -= deadCount[i];
  }
  
  cout << (bugCount % MOD);
	return 0;
}