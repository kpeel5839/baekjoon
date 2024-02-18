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

ll A,B,C;
string s1,s2;
vll dp;

ll calculate(ll ai,ll bi){
	if(ai==-1||bi==-1){
		return B;
	}
	if(s1.at(ai)==s2.at(bi)){
		return A;
	}
	return C;
}

ll dfs(ll ai, ll bi){
	if(ai==s1.length()&&bi==s2.length()){
		return 0;
	}
	if(dp[ai][bi]!=-inf){
		return dp[ai][bi];
	}
	if(ai!=s1.length()){//s1 선택
		dp[ai][bi]=max(dp[ai][bi],dfs(ai+1,bi)+calculate(ai,-1));
	}
	if(bi!=s2.length()){//s2 선택
		dp[ai][bi]=max(dp[ai][bi],dfs(ai,bi+1)+calculate(-1,bi));
	}
	if(ai!=s1.length()&&bi!=s2.length()){//둘다 선택
		dp[ai][bi]=max(dp[ai][bi],dfs(ai+1,bi+1)+calculate(ai,bi));
	}

	return dp[ai][bi];
}

void solve() {
	cin>>A>>B>>C>>s1>>s2;
	dp=vll(s1.length()+1,vl(s2.length()+1,-inf));
	cout<<dfs(0,0);
}

int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	//freopen("input.txt", "r", stdin);
  solve();
	return 0;
}