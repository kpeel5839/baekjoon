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

// 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
// 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
// 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
void solve(string s) {
  set<char>ss={'a','e','i','o','u'};
  bool good=true;
  bool vowel=false;
  for(int i=0;i<s.length();i++){
    int n=s.length();
    if(ss.find(s.at(i))!=ss.end()){
      vowel=true;
    }
    if(i<=n-3){
      string sub1;
      int vowelCount=0;
      for(int j=0;j<3;j++){
        if(ss.find(s.at(i+j))!=ss.end()){
          vowelCount++;
        }
      }
      if(vowelCount==0||vowelCount==3){
        good=false;
      }
    }
    if(i<=n-2){
      set<char>sss;
      string sub2;
      for(int j=0;j<2;j++){
        sss.insert(s.at(i+j));
        sub2.push_back(s.at(i+j));
      }
      if(sss.size()==1&&sub2!="ee"&&sub2!="oo"){
        good=false;
      }
    }
  }
  cout<<"<"<<s<<">"<<" is ";
  if(good&&vowel){
    cout<<"acceptable."<<"\n";
  }else{
    cout<<"not acceptable."<<"\n";
  }
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	//freopen("input.txt", "r", stdin);
  while(true){
    string s;cin>>s;
    if(s=="end"){
      return 0;
    }
    solve(s);
  }
	return 0;
}