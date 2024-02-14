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

int N,M;
vb isNotStanding;
vii dp;
int dfs(int index, int jump){
  if(index==N){
    return 0;
  }
  if(dp[jump][index]!=inf){
    return dp[jump][index];
  }
  for(int i=-1;i<=1;i++){
    int newJump=jump+i;
    if(newJump<=0||N<index+newJump||isNotStanding[index+newJump]){
      continue;
    }
    dp[jump][index]=min(dp[jump][index],dfs(index+newJump,newJump)+1);
  }
  return dp[jump][index];
}

void solve() {
  cin>>N>>M;
  isNotStanding=vb(N+1,false);
  dp=vii(200,vi(N+1,inf));
  for(int i=0; i<M; i++) {
    int index;cin>>index;isNotStanding[index]=true;
  }
  if(isNotStanding[2]){
    cout<<-1;
    return;
  }
  int result=dfs(2,1);
  cout<<(result==inf?-1:result+1);
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	//freopen("input.txt", "r", stdin);
  solve();
	return 0;
}