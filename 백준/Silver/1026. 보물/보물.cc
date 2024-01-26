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
  
  priority_queue<int, vector<int>, less<int>> a;
  priority_queue<int, vector<int>, greater<int>> b;
  
  int n;
  cin >> n;

  for (int i = 0; i < n; i++) {
    int v;
    cin >> v;
    a.push(v);
  }

  for (int i = 0; i < n; i++) {
    int v;
    cin >> v;
    b.push(v);
  }

  int answer = 0;

  for (int i = 0; i < n; i++) {
    answer += a.top() * b.top();
    a.pop(), b.pop();
  }

  cout << answer;
	return 0;
}