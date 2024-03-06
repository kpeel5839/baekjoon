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
#define y first
#define x second

typedef long long ll;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
typedef vector<pii> vpii;
typedef vector<pll> vpll;
typedef vector<int> vi;
typedef vector<vi> vii;
typedef vector<vii> viii;
typedef vector<viii> viiii;
typedef vector<ll> vl;
typedef vector<vl> vll;
typedef vector<vll> vlll;
typedef vector<vlll> vllll;
typedef vector<char> vc;
typedef vector<vc> vcc;
typedef vector<vcc> vccc;
typedef vector<vccc> vcccc;
typedef vector<bool> vb;
typedef vector<vb> vbb;
typedef vector<vbb> vbbb;
typedef vector<vbbb> vbbbb;
const ll INF = 1e18;
const int inf = 2e9;
const int size = 1 << 18;
const int mod = 1e9 + 7;

namespace std {
  template<>
  struct hash<std::vector<int>> {
    size_t operator()(const std::vector<int>& v) const {
      size_t hash_value = 0;
      for (int i : v) {
        hash_value ^= std::hash<int>()(i);
      }
      return hash_value;
    }
  };
}
const ll MOD=998244353;
ll N;
vlll dp;
ll dfs(ll now,ll pre,ll idx){
  if(idx==N){
    if(now==7){
      return 1;
    }
    return 0;
  }
  if(dp[now][pre][idx]!=-1){
    return dp[now][pre][idx];
  }
  dp[now][pre][idx]=0;
  for(int i=0;i<7;i++){
    if(i==now){
      dp[now][pre][idx]=(dp[now][pre][idx]+dfs(now+1,i,idx+1))%MOD;
    }else{
      dp[now][pre][idx]=(dp[now][pre][idx]+dfs(now,i,idx+1))%MOD;
    }
  }
  return dp[now][pre][idx];
}
void solve() {
  cin>>N;
  dp=vlll(8,vll(7,vl(N,-1)));
  cout<<dfs(0,0,0);
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	//freopen("input.txt", "r", stdin);
  solve();
	return 0;
}