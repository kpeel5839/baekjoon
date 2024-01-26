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
const int MOD = 1e9 + 7;

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

  string s;
  cin >> s;
  vector<int> v(10, 0);
  
  for (int i = 0; i < s.length(); i++) {
    v[s.at(i) - '0']++;
  }
  
  int maxValue = 0;
  for (int i = 0; i < 10; i++) {
    if (i == 6 || i == 9) {
      continue;
    }

    maxValue = max(maxValue, v[i]);
  }
  
  maxValue = max(maxValue, static_cast<int>(ceil((v[6] + v[9]) / 2.0)));

  cout << maxValue << endl;
  
	return 0;
}
