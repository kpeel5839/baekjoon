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
int N,K;
viii arr;
set<vii>s;

void solve() {
  cin>>N;
  arr=viii((N-2)/2);
  for(int i=-1;i<N-1;i++){
    int x,y;cin>>x>>y;
    if(i==-1||i==N-2){
      continue;
    }
    arr[i/2].push_back({y,x});
  }
  cin>>K;
  for(int i=0;i<K;i++){
    int a,b,c,d;cin>>a>>b>>c>>d;
    s.insert({{b,a},{d,c}});
  }
  int answer=0;
  for(int i=0;i<arr.size();i++){
    if(s.find(arr[i])!=s.end()){
      continue;
    }
    int leftMin=inf;
    int rightMin=inf;
    bool meetWall=true;
    for(int j=i-1;0<=j;j--){
      leftMin=min(leftMin,arr[j][0][0]);
      if(s.find(arr[j])!=s.end()){
        meetWall=false;
        break;
      }
    }
    if(meetWall){
      leftMin=0;
    }
    meetWall=true;
    for(int j=i+1;j<arr.size();j++){
      rightMin=min(rightMin,arr[j][0][0]);
      if(s.find(arr[j])!=s.end()){
        meetWall=false;
        break;
      }
    }
    if(meetWall){
      rightMin=0;
    }
    int minimum=max(leftMin,rightMin);
    if(arr[i][0][0]<minimum){
      continue;
    }
    answer+=((arr[i][0][0]-minimum)*(arr[i][1][1]-arr[i][0][1]));
  }
  cout<<answer;
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	//freopen("input.txt", "r", stdin);
  solve();
}