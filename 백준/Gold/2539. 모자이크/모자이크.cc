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

int H,W,P;
vi arr;

bool isPossible(int m){
  int start=0;
  int count=0;
  for(int i=0;i<arr.size();i++){
    if(arr[i]<start){
      continue;
    }
    start=arr[i]+m;
    count++;
  }
  return count<=P;
}

void solve() {
  cin>>H>>W>>P;
  int N;cin>>N;
  int l=0;
  int r=H;
  for(int i=0;i<N;i++){
    int h,w;cin>>h>>w;arr.push_back(w);
    l=max(l,h);
  }
  sort(arr.begin(),arr.end());
  int answer=0;
  while(l<=r){
    int m=(l+r)/2;
    if(isPossible(m)){
      r=m-1;
      answer=m;
    }else{
      l=m+1;
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