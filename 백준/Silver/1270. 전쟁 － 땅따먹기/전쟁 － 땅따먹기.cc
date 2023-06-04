#include <cstdio>
#include <algorithm>
#include <map>

using namespace std;
using  ll = long long;

int main() {
    int t; scanf("%d", &t);
    while (t--) {
        map<ll, int> cnt;
        ll ret = 0, idx = -1;
        int n; scanf("%d", &n);
        for (int i = 0; i < n; i++) {
            ll num; scanf("%lld", &num);
            ll tmp = ++cnt[num];
            if (tmp > ret) {
                idx = num;
                ret = tmp;
            }
        }
        if (ret > n / 2) printf("%lld\n", idx);
        else printf("SYJKGW\n");
    }
}