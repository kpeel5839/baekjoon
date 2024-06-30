#include <algorithm>
#include <cmath>
#include <cstdio>
#include <deque>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <sstream>
#include <stack>
#include <string.h>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <utility>
#include <vector>

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
const int inf = 1e9;
const int size = 1 << 18;
const int mod = 1e9 + 7;

namespace std {
    template <> struct hash<std::vector<int>> {
        size_t operator()(const std::vector<int> &v) const {
            size_t hash_value = 0;
            for (int i : v) {
                hash_value ^= std::hash<int>()(i);
            }
            return hash_value;
        }
    };
}

const ll MOD=1e7;
vl fact = {1};
ll pow_mod(ll x, ll p) {
    if (p == 0) {
        return 1;
    }
    if (p % 2 == 0) {
        ll y = pow_mod(x, p / 2);
        return (y * y) % MOD;
    }
    return (x * pow_mod(x, p - 1)) % MOD;
}
ll inv(ll x) {
    return pow_mod(x, MOD - 2);
}
ll cnk(ll n, ll k) {
    ll res = fact[n];
    res = (res * inv(fact[k])) % MOD;
    res = (res * inv(fact[n - k])) % MOD;
    return res;
}

int h,w;
vcc arr;
vi dx={0,1,0,-1};
vi dy={-1,0,1,0};
vi andd={3,2,1,0};
vi bndd={1,0,3,2};
bool isOutOfRange(int y,int x){
    return y<0||y>=h||x<0||x>=w;
}
int dfs(int y,int x,int preDir,vbbb&visited){
    if(isOutOfRange(y,x)){
        return 0;
    }
    if(visited[preDir][y][x]){
        return inf;
    }
    visited[preDir][y][x]=true;
    if(arr[y][x]=='\\'){
        visited[preDir][y][x]=false;
        return dfs(y+dy[andd[preDir]],x+dx[andd[preDir]],andd[preDir],visited)+1;
    }
    visited[preDir][y][x]=false;
    return dfs(y+dy[bndd[preDir]],x+dx[bndd[preDir]],bndd[preDir],visited)+1;
}
void solve() {
    cin>>h>>w;
    arr.resize(h,vc(w,' '));
    for(int i=0;i<h;i++){
        for(int j=0;j<w;j++){
            cin>>arr[i][j];
        }
    }
    vbbb visited(4,vbb(h,vb(w,false)));
    int answer=-1;
    for(int i=0;i<w;i++){
        int result=dfs(0,i,2,visited);
        if(inf>result){
            answer=max(answer,result);
        }
        result=dfs(h-1,i,0,visited);
        if(inf>result){
            answer=max(answer,result);
        }
    }
    for(int i=0;i<h;i++){
        int result=dfs(i,0,1,visited);
        if(inf>result){
            answer=max(answer,result);
        }
        result=dfs(i,w-1,3,visited);
        if(inf>result){
            answer=max(answer,result);
        }
    }
    cout<<answer<<"\n";
}

int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    //freopen("input.txt", "r", stdin);
    solve();
    // int T;
    // cin >> T;
    // while (T-- > 0) {
    //     solve();
    // }
    return 0;
}
