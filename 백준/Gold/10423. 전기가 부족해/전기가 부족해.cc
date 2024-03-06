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

struct comp{
  bool operator()(vl& a,vl& b){
    return a[1]>b[1];
  }
};

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
vlll graph;
int N,M,K;
void solve() {
  cin>>N>>M>>K;
  graph=vlll(N+1);
  vb visited(N+1);
  priority_queue<vl,vll,comp>q;
  vi electro;
  for(int i=0;i<K;i++){
    int a;cin>>a;
    electro.push_back(a);
    visited[a]=true;
  }
  for(int i=0;i<M;i++){
    int a,b,c;cin>>a>>b>>c;
    graph[a].push_back({b,c});
    graph[b].push_back({a,c});
  }
  for(auto v:electro){
    for(auto vv:graph[v]){
      q.push({vv[0],vv[1]});
    }
  }
  int answer=0;
  while(q.size()!=0){
    vl p=q.top();q.pop();
    if(visited[p[0]]){
      continue;
    }
    visited[p[0]]=true;
    answer+=p[1];
    for(auto v:graph[p[0]]){
      if(visited[v[0]]){
        continue;
      }
      q.push({v[0],v[1]});
    }
  }
  cout<<answer<<"\n";
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	//freopen("input.txt", "r", stdin);
  solve();
	return 0;
}