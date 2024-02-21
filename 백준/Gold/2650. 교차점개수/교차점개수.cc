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

vi mulMap={-1,0,2,3,1};
vi addMap={0,1,-1,-1,1};
int mul=1e4;
int N;
vii points;

void solve() {
  cin>>N;
  for(int i=0;i<N/2;i++){
    for(int j=0;j<2;j++){
      int t,p;cin>>t>>p;
      points.push_back({mulMap[t]*mul+addMap[t]*p,i});
    }
  }
  sort(points.begin(),points.end(),[](vi&o1,vi&o2){
    return o1[0]<o2[0];
  });
  vi nums;
  for(auto v:points){
    nums.push_back(v[1]);
  }
  int answer1=0;
  int answer2=0;
  for(int i=1;i<N/2;i++){
    bool search=false;
    set<int>s;
    set<int>ss;
    for(int j=0;j<nums.size();j++){
      if(search&&nums[j]<i){
        if(s.find(nums[j])!=s.end()){
          s.erase(nums[j]);
        }else{
          s.insert(nums[j]);
        }
      }
      if(search&&nums[j]!=i){
        if(ss.find(nums[j])!=ss.end()){
          ss.erase(nums[j]);
        }else{
          ss.insert(nums[j]);
        }
      }
      if(nums[j]==i){
        search=!search;
      }
    }
    int intersectCount=s.size();
    answer1+=intersectCount;
    answer2=max(answer2,static_cast<int>(ss.size()));
  }
  cout<<answer1<<"\n"<<answer2;
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	//freopen("input.txt", "r", stdin);
  solve();
	return 0;
}