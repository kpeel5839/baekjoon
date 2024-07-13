#include<iostream>
#include<algorithm>
#include<string>
#include<math.h>
#include<cstring>

using namespace std;

string strNum;
int digit[10] = { 6,2,5,5,4,5,6,3,7,5 };
char cache[16][16][16][16][16][16][2];
long long ans;

int cntEdge(long long num, int size) {
	int cnt = 0;

	for (int i = 0; i < size; i++) {
		cnt += digit[num % 10];
		num /= 10;
	}

	return cnt;
}

int time(long long currentNum, int cnt2, int cnt3, int cnt4, int cnt5, int cnt6, int cnt7, int objCnt, int pass, int len, int idx, long long num) {
	if (idx == len) {
		if (2 * cnt2 + 3 * cnt3 + 4 * cnt4 + 5 * cnt5 + 6 * cnt6 + 7 * cnt7 == objCnt) {
			if (pass == 0 && currentNum == num)
				return 0;
			ans = currentNum;
			return 1;
		}
		return 0;
	}
	
	char& ret = cache[cnt2][cnt3][cnt4][cnt5][cnt6][cnt7][pass];

	if (ret != -1)
		return ret;

	ret = 0;
	for (int i = pass == 1 ? 0 : (strNum[idx] - '0'); i < 10; i++) {
		int newPass = pass == 1 || i > strNum[idx] - '0';

		ret = time(10 * currentNum + i, cnt2 + (int)(digit[i] == 2), cnt3 + (int)(digit[i] == 3), cnt4 + (int)(digit[i] == 4), cnt5 + (int)(digit[i] == 5), cnt6 + (int)(digit[i] == 6), cnt7 + (int)(digit[i] == 7), objCnt, newPass, len, idx + 1, num);
		if (ret != 0)
			return ret;
		if (idx == 0 && i == 9) {
			i = -1;
			pass = 1;
		}
	}
	return ret;
}

int main(void) {
	int N, cnt;
	long long limit;
	memset(cache, -1, sizeof(cache));
	cin >> strNum;
	N = strNum.size();
	limit = pow(10, N);
	cnt = cntEdge(stoll(strNum), N);

	time(0, 0, 0, 0, 0, 0, 0, cnt, 0, N, 0, stoll(strNum));

	if (ans - stoll(strNum) == 0)
		cout << (ans - 1 - stoll(strNum) + limit) % limit + 1;
	else
		cout << (ans - stoll(strNum) + limit) % limit;
	return 0;
}