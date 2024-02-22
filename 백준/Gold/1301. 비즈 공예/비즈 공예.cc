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

int N;
int allCount=0;
ll mul=11;
vi c;
map<vl,ll>dp;
ll dfs(int index,ll value,ll pp,ll p){
  if(index==allCount){
    return 1;
  }
  vl key={value,pp,p};
  if(dp.find(key)!=dp.end()){
    return dp[key];
  }
  dp[key]=0;
  for(int i=0;i<N;i++){
    if(i==pp||i==p||c[i]==0){
      continue;
    }
    c[i]--;
    dp[key]+=dfs(index+1,value+(pow(mul,i)),p,i);
    c[i]++;
  }
  return dp[key];
}

void solve() {
  cin>>N;
  c=vi(N,0);
  for(int i=0;i<N;i++){
    cin>>c[i];
    allCount+=c[i];
  }
  ll answer=0;
  for(int i=0;i<N;i++){
    c[i]--;
    answer+=dfs(1,pow(mul,i),-1,i);
    c[i]++;
  }
  cout<<answer;
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	// freopen("input.txt", "r", stdin);
  solve();
	return 0;
}