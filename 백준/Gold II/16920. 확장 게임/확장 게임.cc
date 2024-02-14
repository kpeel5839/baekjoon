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

int N,M,P;
vi S;
vcc m;
vector<queue<pii>> queues;
vi dx={0,1,0,-1};
vi dy={-1,0,1,0};
bool isOutOfRange(int y,int x){
  return y<0||y>=N||x<0||x>=M;
}

bool isAllEmpty(){
  for(queue<pii> q:queues){
    if(q.size()!=0){
      return false;
    }
  }
  return true;
}

void solve() {
  cin>>N>>M>>P;
  m=vcc(N,vc(M,' '));
  S=vi(P+1,0);
  queues=vector<queue<pii>>(P+1);
  for(int i=0;i<P;i++){
    int value;cin>>value;S[i+1]=min(N*M,value);
  }
  for(int i=0;i<N;i++){
    string s;cin>>s;
    for(int j=0;j<M;j++){
      m[i][j]=s.at(j);
      if(m[i][j]=='.'||m[i][j]=='#'){
        continue;
      }
      queues[m[i][j]-'0'].push({i,j});
    }
  }
  while(!isAllEmpty()){
    for(int i=1;i<=P;i++){
      for(int j=0;j<S[i];j++){
        queue<pii> temp;
        while(queues[i].size()!=0){
          pii p=queues[i].front();queues[i].pop();
          for (int dir=0;dir<4;dir++){
            int ny=p.first+dy[dir];
            int nx=p.second+dx[dir];
            if(isOutOfRange(ny,nx)||m[ny][nx]!='.'){
              continue;
            }
            m[ny][nx]=i+'0';
            temp.push({ny,nx});
          }
        }
        while(temp.size()!=0){
          queues[i].push(temp.front());temp.pop();
        }
        if(queues[i].size()==0){
          break;
        }
      }
    }
  }
  vi answer(P+1,0);
  for(int i=0; i<N;i++){
    for(int j=0;j<M;j++){
      if(m[i][j]=='.'||m[i][j]=='#'){
        continue;
      }
      answer[m[i][j]-'0']++;
    }
  }
  for(int i=1;i<=P;i++){
    cout<<answer[i]<<" ";
  }
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	//freopen("input.txt", "r", stdin);
  solve();
  return 0;
}