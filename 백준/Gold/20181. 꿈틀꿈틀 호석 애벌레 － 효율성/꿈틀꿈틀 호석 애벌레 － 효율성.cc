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
const int inf = 2e9;
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

int n,k;
vl dp;
vll jump(n+1,vl(2,0ll));
ll dfs(int idx){
    if(idx==n+1){
        return 0;
    }
    if(dp[idx]!=-1){
        return dp[idx];
    }
    if(jump[idx][0]==idx+1){
        dp[idx]=dfs(jump[idx][0])+max(0ll,jump[idx][1]-k);
    }else{
        dp[idx]=max(dfs(idx+1),dfs(jump[idx][0])+max(0ll,jump[idx][1]-k));
    }
    return dp[idx];
}

void solve() {
    cin>>n>>k;
    vl arr(n+1,0ll);
    for(int i=1;i<=arr.size();i++){
        cin>>arr[i];
    }
    jump.resize(n+1,vl(2,0ll));
    int l=1;
    ll sum=0;
    for(int r=1;r<=n;r++){
        sum+=arr[r];
        while(l<=r&&k<=sum){
            jump[l]={r+1,sum};
            sum-=arr[l++];
        }
    }
    while(l<=n){
        jump[l]={n+1,sum};
        sum-=arr[l++];
    }
    dp.resize(n+1,-1ll);
    cout<<dfs(1)<<"\n";
    // for(int i=1;i<=n;i++){
    //     cout<<dp[i]<<" ";
    // }
}

int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    //freopen("input.txt", "r", stdin);
    solve();
    return 0;
}
