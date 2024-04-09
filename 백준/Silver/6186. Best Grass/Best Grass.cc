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

int h,w;
vcc m;
vbb visited;
vi dx={0,1,0,-1};
vi dy={-1,0,1,0};
bool isOutOfRange(int y,int x){
  return y<0||y>=h||x<0||x>=w;
}
void bfs(int y,int x){
  visited[y][x]=true;
  queue<vi>q;
  q.push({y,x});
  while(q.size()!=0){
    vi p=q.front();q.pop();
    for(int i=0;i<4;i++){
      int ny=p[0]+dy[i];
      int nx=p[1]+dx[i];
      if(isOutOfRange(ny,nx)||visited[ny][nx]||m[ny][nx]=='.'){
        continue;
      }
      q.push({ny,nx});
      visited[ny][nx]=true;
    }
  }
}
void solve() {
  cin >> h >> w;
  m=vcc(h,vc(w));
  visited=vbb(h, vb(w,false));
  for(int i=0;i<h;i++){
    string s;cin>>s;
    for(int j=0;j<w;j++){
      m[i][j]=s[j];
    }
  }
  int cnt=0;
  for(int i=0;i<h;i++){
    for(int j=0;j<w;j++){
      if(m[i][j]=='#'&&!visited[i][j]){
        bfs(i,j);
        cnt++;
      }
    }
  }
  cout<<cnt;
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	//freopen("input.txt", "r", stdin);
  solve();
	return 0;
}