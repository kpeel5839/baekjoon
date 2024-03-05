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
vll arr;
pll src;
pll des;

void solve() {
  cin>>N;
  arr=vll(2,vl(N,0));
  for(int i=0;i<2;i++){
    for(int j=0;j<N;j++){
      cin>>arr[i][j];
    }
  }
  int srcX,srcY,desX,desY;cin>>srcX>>srcY>>desX>>desY;
  src={srcY-1,srcX-1};
  des={desY-1,desX-1};
  pll tmp;
  if(des.x<src.x){
    tmp=src;
    src=des;
    des=tmp;
  }
  vl maxElements;
  vl totalElements;
  for(int i=0;i<N;i++){
    maxElements.push_back(max(arr[0][i],arr[1][i]));
    totalElements.push_back(arr[0][i]+arr[1][i]);
  }
  if(src.x==des.x){
    ll leftSum=0;
    ll leftMax=-inf;
    for(int i=src.x-1;0<=i;i--){
      leftMax=max(leftMax,max(leftSum+maxElements[i],leftSum+totalElements[i]));
      leftSum+=totalElements[i];
    }
    ll rightSum=0;
    ll rightMax=-inf;
    for(int i=des.x+1;i<N;i++){
      rightMax=max(rightMax,max(rightSum+maxElements[i],rightSum+totalElements[i]));
      rightSum+=totalElements[i];
    }
    cout<<max(totalElements[src.x],totalElements[src.x]+max(leftMax,rightMax))<<"\n";
  }else{
    maxElements[src.x]=arr[src.y][src.x];
    totalElements[src.x]=arr[0][src.x]+arr[1][src.x];
    maxElements[des.x]=arr[des.y][des.x];
    totalElements[des.x]=arr[0][des.x]+arr[1][des.x];
    ll leftSum=0;
    ll leftMax=arr[src.y][src.x];
    for(int i=src.x;0<=i;i--){
      leftMax=max(leftMax,max(leftSum+maxElements[i],leftSum+totalElements[i]));
      leftSum+=totalElements[i];
    }
    ll middleSum=0;
    for(int i=src.x+1;i<=des.x-1;i++){//중간
      middleSum+=max(maxElements[i],totalElements[i]);
    }
    ll rightSum=0;
    ll rightMax=arr[des.y][des.x];
    for(int i=des.x;i<N;i++){
      rightMax=max(rightMax,max(rightSum+maxElements[i],rightSum+totalElements[i]));
      rightSum+=totalElements[i];
    }
    cout<<(leftMax+rightMax+middleSum)<<"\n";
  }
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	//freopen("input.txt", "r", stdin);
  int T; cin >> T;
  while (T-- > 0) {
    solve();
  }
	return 0;
}