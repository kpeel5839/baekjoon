#include <iostream>
#include <cstring>
using namespace std;

long long N, K, dp[55][55][2];

long long subSolve(int length, int cnt)
{
	if (N < length || N < cnt) return 0;
	if (dp[length][cnt][1] != -1) return dp[length][cnt][1];
	if (length == N) return dp[length][cnt][1] = 1;

	return (dp[length][cnt][1] = subSolve(length + 1, cnt) + subSolve(length + 1, cnt + 1));
}

long long solve(int length, int cnt, int check, bool nono)
{
	if (N < length || N < cnt) return 0;
	if (dp[length][cnt][0] != -1) return dp[length][cnt][0];

	if (length == N)
	{
		if (check == 0) return 0;
		else return dp[length][cnt][0] = 1;
	}

	if (check < 0) nono = true;

	if (nono) return (dp[length][cnt][0] = subSolve(length + 1, cnt) + subSolve(length + 1, cnt + 1));  // 괄호 조건이 아니라면 이 뒤로는 어떤 조합이 와도 됨

	return (dp[length][cnt][0] = solve(length + 1, cnt, check + 1, nono) + solve(length + 1, cnt + 1, check - 1, nono));  // 아직까지 괄호 조건일 때
}

void trackAnswer(int length, int cnt, int check, bool nono, long long nth)
{
	if (length == N) return;

	if (check < 0) nono = true;

	if (dp[length + 1][cnt][nono] < nth)
	{
		cout << ')';
		trackAnswer(length + 1, cnt + 1, check - 1, nono, nth - dp[length + 1][cnt][nono]);
	}
	else {
		cout << '(';
		trackAnswer(length + 1, cnt, check + 1, nono, nth);
	}
}


int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> N >> K;

	memset(dp, -1, sizeof(dp));

	if (solve(0, 0, 0, false) < K + 1) cout << -1;
	else trackAnswer(0, 0, 0, 0, K + 1);

	return 0;
}
