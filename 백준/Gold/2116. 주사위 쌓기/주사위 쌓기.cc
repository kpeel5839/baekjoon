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

vi mapping={5,3,4,1,2,0};
int N;
vii arr;
int dfs(int idx,int pre){
  if(idx==arr.size()){
    return 0;
  }
  int findIdx=0;
  for(int i=0;i<6;i++){
    if(pre==arr[idx][i]){
      findIdx=i;
      continue;
    }
  }
  int mv=0;
  for(int i=0;i<6;i++){
    if(findIdx==i||mapping[findIdx]==i){
      continue;
    }
    mv=max(mv,arr[idx][i]);
  }
  return mv+dfs(idx+1,arr[idx][mapping[findIdx]]);
}
void solve() {
  cin>>N;
  arr=vii(N, vi(6));
  for(int i=0; i<N; i++){
    for(int j=0; j<6; j++){
      cin>>arr[i][j];
    }
  }
  int answer=0;
  for(int i=0;i<6;i++){
    answer=max(answer,dfs(0,arr[0][i]));
  }
  cout<<answer;
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	//freopen("input.txt", "r", stdin);
  solve();
	return 0;
}