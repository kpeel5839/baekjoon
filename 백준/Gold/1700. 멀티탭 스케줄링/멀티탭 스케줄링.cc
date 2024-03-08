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

int N,K;
vi copyArr;
void solve() {
  cin>>N>>K;
  copyArr=vi(K);
  for(int i=0;i<K;i++){
    cin>>copyArr[i];
  }
  vi arr={copyArr[0]};
  for(int i=1;i<copyArr.size();i++){
    if(copyArr[i-1]!=copyArr[i]){
      arr.push_back(copyArr[i]);
    }
  }
  K=arr.size();
  set<int>s;
  int answer=0;
  for(int i=0;i<K;i++){
    if(s.find(arr[i])!=s.end()){
      continue;
    }
    if(s.size()!=N){
      s.insert(arr[i]);
      continue;
    }
    set<int>copySet(s);
    int last=0;
    for(int j=i+1;j<K;j++){
      if(copySet.find(arr[j])!=copySet.end()){
        copySet.erase(arr[j]);
        last=arr[j];
      }
    }
    if(copySet.size()!=0){
      s.erase(*copySet.begin());
      answer++;
    }else{
      s.erase(last);
      answer++;
    }
    s.insert(arr[i]);
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