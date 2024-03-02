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

vpii answer;
vcc arr;
int N;
vi dx={0,1,0,-1};
vi dy={-1,0,1,0};

bool isOutOfRange(int y,int x){
  return y<0||y>=N||x<0||x>=N;
}



bool isOk(int y,int x){
  vbb visited(N,vb(N,false));
  int count=0;
  for(int i=0;i<N;i++){
    for(int j=0;j<N;j++){
      if(arr[i][j]=='.'||visited[i][j]){
        continue;
      }
      if(count==1){
        return false;
      }
      count++;
      queue<vi>q;
      q.push({i,j,-1,-1});
      visited[i][j]=true;
      while(q.size()!=0){
        vi p=q.front();q.pop();
        for(int dir=0;dir<4;dir++){
          int ny=p[0]+dy[dir];
          int nx=p[1]+dx[dir];
          if(isOutOfRange(ny,nx)||arr[ny][nx]=='.'||(ny==p[2]&&nx==p[3])){
            continue;
          }
          if(visited[ny][nx]){
            return false;
          }
          visited[ny][nx]=true;
          q.push({ny,nx,p[0],p[1]});
        }
      }
    }
  }
  return true;
}

void solve() {
  cin>>N;
  arr=vcc(N,vc(N));
  for(int i=0;i<N;i++){
    string s;cin>>s;
    for(int j=0;j<N;j++){
      arr[i][j]=s.at(j);
    }
  }
  for(int i=0;i<N;i++){
    for(int j=0;j<N;j++){
      if(arr[i][j]=='.'){
        continue;
      }
      arr[i][j]='.';
      if(isOk(i,j)){
        answer.push_back({i+1,j+1});
      }
      arr[i][j]='#';
    }
  }
  cout<<answer.size()<<"\n";
  for(auto v:answer){
    cout<<v.y<<" "<<v.x<<"\n";
  }
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	//freopen("input.txt", "r", stdin);
  solve();
	return 0;
}