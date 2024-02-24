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

vii cnt;
bool success;

void dfs(int p,int q){
  if(success){
    return;
  }
  if(p==6){
    success=true;
  }else if(q==6){
    dfs(p+1,p+2);
  }else{
    cnt[p][0]--;
    cnt[q][2]--;
    if(0<=cnt[p][0]&&0<=cnt[q][2]){
      dfs(p,q+1);
    }
    cnt[p][0]++;
    cnt[q][2]++;
    cnt[p][1]--;
    cnt[q][1]--;
    if(0<=cnt[p][1]&&0<=cnt[q][1]){
      dfs(p,q+1);
    }
    cnt[p][1]++;
    cnt[q][1]++;
    cnt[p][2]--;
    cnt[q][0]--;
    if(0<=cnt[p][2]&&0<=cnt[q][0]){
      dfs(p,q+1);
    }
    cnt[p][2]++;
    cnt[q][0]++;
    
  }
}

void solve() {
  int n=0;
  while(n++<4){
    cnt=vii(6,vi(3,0));
    success=false;
    bool isNot=false;
    for(int i=0;i<6;i++){
      int sum=0;
      for(int j=0;j<3;j++){
        cin>>cnt[i][j];
        sum+=cnt[i][j];
      }
      if(sum!=5){
        isNot=true;
      }
    }
    if(isNot){
      cout<<0<<" ";
      continue;
    }
    dfs(0,1);
    if(success){
      cout<<1<<" ";
    }else{
      cout<<0<<" ";
    }
  }
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	//freopen("input.txt", "r", stdin);
  solve();
	return 0;
}