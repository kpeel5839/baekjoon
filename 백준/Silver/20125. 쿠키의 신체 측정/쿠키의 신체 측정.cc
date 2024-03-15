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

int N;
vcc m;
vi dx={-1,1,0};
vi dy={0,0,1};
bool isOutOfRange(int y,int x){
  return y<0||y>=N||x<0||x>=N;
}
void solve() {
  cin>>N;
  m=vcc(N,vc(N,' '));
  vi point={-1,-1};
  for(int i=0;i<N;i++){
    for(int j=0;j<N;j++){
      cin>>m[i][j];
      if(m[i][j]=='*'&&point[0]==-1){
        point={i+1,j};
      }
    }
  }
  //먼저 심장을 찾고
  //왼쪽,오른쪽,아래를찾고 아래의 길이 + 1, width - 1, 아래의 길이 + 1,widht+1에서
  cout<<point[0]+1<<" "<<point[1]+1<<"\n";
  int stomaLength=0;
  {
    int y=point[0];
    int x=point[1]-1;
    int cnt=0;
    while(!isOutOfRange(y,x)){
      if(m[y][x]!='*'){
        break;
      }
      y+=dy[0];
      x+=dx[0];
      cnt++;
    }
    cout<<cnt<<" ";
  }
  {
    int y=point[0];
    int x=point[1]+1;
    int cnt=0;
    while(!isOutOfRange(y,x)){
      if(m[y][x]!='*'){
        break;
      }
      y+=dy[1];
      x+=dx[1];
      cnt++;
    }
    cout<<cnt<<" ";
  }
  {
    int y=point[0]+1;
    int x=point[1];
    int cnt=0;
    while(!isOutOfRange(y,x)){
      if(m[y][x]!='*'){
        break;
      }
      y+=dy[2];
      x+=dx[2];
      cnt++;
    }
    stomaLength=cnt;
    cout<<cnt<<" ";
  }
  {
    int y=point[0]+stomaLength+1;
    int x=point[1]-1;
    int cnt=0;
    while(!isOutOfRange(y,x)){
      if(m[y][x]!='*'){
        break;
      }
      y+=dy[2];
      x+=dx[2];
      cnt++;
    }
    cout<<cnt<<" ";
  }
  {
    int y=point[0]+stomaLength+1;
    int x=point[1]+1;
    int cnt=0;
    while(!isOutOfRange(y,x)){
      if(m[y][x]!='*'){
        break;
      }
      y+=dy[2];
      x+=dx[2];
      cnt++;
    }
    cout<<cnt<<" ";
  }
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	//freopen("input.txt", "r", stdin);
  solve();
	return 0;
}