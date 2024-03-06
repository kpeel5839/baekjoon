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

int N;
string arr,goal,copyString;
int answer=inf;
void dfs(int idx,int count){
  if(idx==N){
    if(copyString.at(idx-1)==goal.at(idx-1)){
      answer=min(answer,count);
    }
    return;
  }
  if(copyString[idx-1]!=goal[idx-1]){
    copyString[idx-1]=(copyString.at(idx-1)-'0'+1)%2+'0';
    copyString[idx]=(copyString.at(idx)-'0'+1)%2+'0';
    if(idx!=N-1){
      copyString[idx+1]=(copyString.at(idx+1)-'0'+1)%2+'0';
    }
    dfs(idx+1,count+1);
  }else{
    dfs(idx+1,count);
  }
}
void solve() {
  cin>>N>>arr>>goal;
  copyString=string(arr);
  dfs(1,0);
  copyString=string(arr);
  copyString[0]=(copyString.at(0)-'0'+1)%2+'0';
  copyString[1]=(copyString.at(1)-'0'+1)%2+'0';
  dfs(1,1);
  cout<<(answer==inf?-1:answer);
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	//freopen("input.txt", "r", stdin);
  solve();
	return 0;
}