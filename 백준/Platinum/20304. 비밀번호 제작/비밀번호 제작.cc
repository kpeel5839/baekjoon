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

int N,M;
vb visited;
void solve() {
  cin>>N>>M;
  visited=vb(N+1,false);
  queue<vi>q;
  for(int i=0;i<M;i++){
    int a;cin>>a;q.push({a,0});
    visited[a]=true;
  }
  int answer=0;
  while(q.size()!=0){
    vi p=q.front();q.pop();
    answer=max(answer,p[1]);
    for(int i=0;(1<<i)<=N;i++){
      int value=(1<<i);
      if((p[0]&value)==0){//추가
        if(!visited[p[0]+value]&&p[0]+value<=N){
          visited[p[0]+value]=true;
          q.push({p[0]+value,p[1]+1});
        }
      }else{//삭제
        if(!visited[p[0]-value]){
          visited[p[0]-value]=true;
          q.push({p[0]-value,p[1]+1});
        }
      }
    }
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