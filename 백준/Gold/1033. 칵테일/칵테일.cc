#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

#define ll long long int
#define MAX_N 11
#define pp pair<int,int>

using namespace std;

int N;
ll dp[MAX_N];
vector<pair<int, pp>> graph[MAX_N];

ll GCD(ll a, ll b);
void dfs(int x, int);

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> N;
	ll lcm = 1;

	for (int i = 0; i < N - 1; i++) {
		ll a, b, c, d;
		cin >> a >> b >> c >> d;
		graph[a].push_back({ b, {c,d} });
		graph[b].push_back({ a, {d,c} });

		lcm *= (c * d / GCD(c, d));
	}

	dp[0] = lcm;
	dfs(0, -1);
    
	ll global = dp[0];
    
	for (int i = 1; i < N; i++) {
		if (dp[i] == 0) continue;
		global = GCD(global, dp[i]);
	}


	for (int i = 0; i < N; i++) 
		cout << dp[i] / global << " ";
	
	return 0;
}

ll GCD(ll a, ll b) {
	while (b != 0) {
		ll t = a % b;
		a = b;
		b = t;
	}

	return a;
}


void dfs(int x, int parent) {
	for (auto n : graph[x]) {
		if (n.first == parent) {
			continue;
		}
		dp[n.first] = (dp[x] * (ll)n.second.second) / (ll)n.second.first;	
		dfs(n.first, x);
	}
}