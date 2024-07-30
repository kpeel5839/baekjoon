#include <stdio.h>

int Lim, Kim, ans, round;

int main() 
{
	// freopen("input.txt", "r", stdin);
	scanf("%d %d %d", &round, &Kim, &Lim);
	
	while (Kim != Lim) 
	{
		Kim = (Kim + 1) / 2;
		Lim = (Lim + 1) / 2;
		ans++;
	}
	
	printf("%d\n", ans);
}