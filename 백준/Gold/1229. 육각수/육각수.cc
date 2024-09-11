#include <iostream>
#define MAX_N 1000001
#define MAX_M 710
using namespace std;
 
int list[MAX_M];
int dp[MAX_N];
int N;
 
void init() {
    for (int i = 1; i < MAX_M; i++) {
        list[i] = i * ((i << 1) - 1);
    }
}
 
void func() {
    init();
 
    dp[1] = 1;
    for (int i = 2; i <= N; i++) {
        dp[i] = 1e9;
        for (int j = 1; j < MAX_M; j++) {
            if (i < list[j]) break;
            dp[i] = min(dp[i], dp[i - list[j]] + 1);
        }
    }
 
    cout << dp[N] << '\n';
}
 
void input() {
    cin >> N;
}
 
int main() {
    cin.tie(NULL); cout.tie(NULL);
    ios::sync_with_stdio(false);
 
    input();
    func();
 
    return 0;
}
