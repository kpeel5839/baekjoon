#include <stdio.h>
#include <algorithm>
#include <vector>
using namespace std;
int main(void) {
	vector<long long> dec_num;
	for (int i = 1; i <= 1023; i++) {
		long long num = 0;
		int tmp_i = i;
		for (int idx = 9; idx >= 0; idx--) {
			if (tmp_i % 2 == 1)
				num = 10 * num + idx;
			tmp_i /= 2;
		}
		dec_num.push_back(num);
	}
	sort(dec_num.begin(), dec_num.end());
	int N;
	scanf("%d", &N);
	if (N > 1022)
		printf("-1");
	else
		printf("%lld", dec_num[N]);
	return 0;
}