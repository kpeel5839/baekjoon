#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef vector<int> vi;

// 함수들 정의
int bcnt(ll x) { return __builtin_popcountll(x); }
int rz(ll x) { return __builtin_ctzll(x); }
int lz(ll x) { return __builtin_clzll(x); }
int msb(ll x) { return 63 - lz(x); }
double area(int a, int b, int c) {
    double p = (a + b + c) / 2.0;
    return sqrt(p * (p - a) * (p - b) * (p - c));
}

// 메인 함수
void solve() {
    int n;
    cin >> n;
    vi a(n);
    
    // vector 입력
    for (int &x : a) cin >> x;
    
    sort(a.begin(), a.end());
    vector<double> dp(1 << n, -1);

    // 재귀 함수 정의
    function<double(int)> fn = [&](int bit) -> double {
        if (n - bcnt(bit) < 3) return 0;
        double &ret = dp[bit];
        if (ret > -0.5) return ret;
        ret = 0;

        vi cand;
        for (int i = 0; i < n; i++) {
            if (!(bit & (1 << i))) cand.push_back(i);
        }
        int c = cand.size();
        for (int i = 0; i < c; i++) {
            for (int j = i + 1; j < c; j++) {
                for (int k = j + 1; k < c; k++) {
                    if (a[cand[i]] + a[cand[j]] > a[cand[k]]) {
                        int mask = (1 << cand[i]) | (1 << cand[j]) | (1 << cand[k]);
                        ret = max(ret, fn(bit | mask) + area(a[cand[i]], a[cand[j]], a[cand[k]]));
                    }
                }
            }
        }

        return ret;
    };
    
    cout << setprecision(15) << fixed << fn(0) << endl;
}

// 메인 함수 시작
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    solve();
    return 0;
}
