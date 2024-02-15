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

void solve() {
  int N;cin>>N;
  if(N==0){
    cout<<-1;
    return;
  }
  int pointer=0;
  int index=0;
  vi arr;
  for(int i=0;i<N;i++){
    int value;cin>>value;arr.push_back(value);
  }
  vi answer(N,0);
  while(pointer!=N){
    while(answer[index]!=0){
      index=(index+1)%N;
    }
    answer[index]=arr[pointer];
    index=(index+arr[pointer++])%N;
  }
  cout<<N<<"\n";
  for(auto v:answer){
    cout<<v<<" ";
  }
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	//freopen("input.txt", "r", stdin);
  solve();
	return 0;
}