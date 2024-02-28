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

int W,H;
int row;
unordered_map<int,int>m;
vcc mat;
vii passed;
vbb visited;
bool isOutOfRange(int index){
  return index<0||W-1<=index;
}
int go(int startIndex){
  int number=startIndex;
  for(int i=0;i<H;i++){
    passed[i][startIndex]=number;
    for(int j=-1;j<=0;j++){
      int newIndex=startIndex+j;
      if(isOutOfRange(newIndex)||mat[i][newIndex]!='-'){
        continue;
      }
      if(j==-1){
        startIndex=newIndex;
      }
      if(j==0){
        startIndex=newIndex+1;
      }
      break;
    }
  }
  return startIndex;
}

void solve() {
  cin>>W>>H;
  mat=vcc(H,vc(W,' '));
  passed=vii(H,vi(W,0));
  string s;cin>>s;
  for(int i=0;i<s.length();i++){
    m[s.at(i)-'A']=i;
  }
  for(int i=0;i<H;i++){
    string ss;cin>>ss;
    for(int j=0;j<W-1;j++){
      mat[i][j]=ss.at(j);
      if(mat[i][j]=='?'){
        row=i;
      }
    }
  }
  for(int i=0;i<W;i++){
    go(i);
  }
  string impossible;
  for(int i=0;i<W-1;i++){
    impossible.append("x");
  }
  for(int i=0;i<W-1;i++){
    if(m[passed[row][i]]!=go(passed[row][i])){
      mat[row][i]='-';
    }
    if(mat[row][i]=='-'&&(m[passed[row][i+1]]!=go(passed[row][i+1])||m[passed[row][i]]!=go(passed[row][i]))){
      cout<<impossible<<"\n";
      return;
    }
  }
  for(int i=0;i<W-1;i++){
    if(mat[row][i]=='?'){
      cout<<'*';
    }else{
      cout<<mat[row][i];
    }
  }
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	//freopen("input.txt", "r", stdin);
  solve();
	return 0;
}