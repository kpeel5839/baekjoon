#include <algorithm>
#include <cmath>
#include <cstdio>
#include <deque>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <sstream>
#include <stack>
#include <string.h>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <utility>
#include <vector>

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
  template <> struct hash<std::vector<int>> {
    size_t operator()(const std::vector<int> &v) const {
      size_t hash_value = 0;
      for (int i : v) {
        hash_value ^= std::hash<int>()(i);
      }
      return hash_value;
    }
  };
}

const ll MOD=1e7;
vl fact = {1};
ll pow_mod(ll x, ll p) {
  if (p == 0) {
    return 1;
  }
  if (p % 2 == 0) {
    ll y = pow_mod(x, p / 2);
    return (y * y) % MOD;
  }
  return (x * pow_mod(x, p - 1)) % MOD;
}
ll inv(ll x) {
  return pow_mod(x, MOD - 2);
}
ll cnk(ll n, ll k) {
  ll res = fact[n];
  res = (res * inv(fact[k])) % MOD;
  res = (res * inv(fact[n - k])) % MOD;
  return res;
}

string s;
bool isGood(string ss,string sss){
  int n=ss.size();
  int idx=0;
  for(int i=0;i<n;i++){
    if(idx==sss.size()){
      break;
    }
    if(ss[i]==sss[idx]){
      idx++;
    }
  }
  return idx==sss.size();
}
void solve() {
  cin>>s;
  int n = s.size();
  vl dp(n+1,INF);
  dp[0]=0;
  for(int i=1;i<=n;i++){
    for(int j=i;max(i-20,1)<=j;j--){
      for(ll c=dp[j-1]+1;c<=dp[j-1]+10;c++){
        if(isGood(to_string(c),s.substr(j-1,i-j+1))){
          dp[i]=min(dp[i],c);
          break;
        }
      }
    }
  }
  cout<<dp[n]<<"\n";
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	//freopen("input.txt", "r", stdin);
  solve();
	return 0;
}