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
vii arr;
void solve() {
  cin>>N;
  arr=vii(N,vi(2,0));
  for(int i=0;i<N;i++){
    cin>>arr[i][0]>>arr[i][1];
  }
  sort(arr.begin(),arr.end(),[](vi&o1,vi&o2){
    return o1[0]<o2[0];
  });
  stack<int>st;
  int answer=0;
  for(int i=0;i<N;i++){
    while(st.size()!=0&&st.top()>arr[i][1]){
      answer++;
      st.pop();
    }
    if(arr[i][1]!=0&&(st.size()==0||st.top()!=arr[i][1])){
      st.push(arr[i][1]);
    }
  }
  while(st.size()!=0){
    answer++;
    st.pop();
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