#include<stdio.h>
int i, n = 1;
long int m, x[100010];
long int k = 0;

void func();
int main()
{

	scanf_s("%d%ld", &n, &m);
	for (i = 0; i <= n - 1; i++)
	{
		scanf_s("%ld", &x[i]);
	}
	int tmpppp = m;
	for (int tmp = 0; tmp <= tmpppp - 1; tmp++) {
		{
			scanf_s("%d", &m);
			func();
		}

	}
	return 0;
}
void func(){
	int i, j = 0, y, t = 0;
	k = k + m / n;
	y = m%n;
	for (i = 0; i <= n - 1; i++)
	{
		x[i] = x[i] - k;
		if (x[i] < 0)
		{
			y = y - x[i];
			t++;
		}
	}
	if (y >= (n - t))
		func();
	
	if (y < (n - t))
	{
		if (y == 0) {
			printf("%d %ld\n",n, k);
		}
		for (i = 0; i <= n - 1; i++)
		{
			if (x[i] >= 1)
			{
				j++;
			}
			if (j == y)
			{
				printf("%d %ld\n", i + 1, k + 1);
				break;
			}
		}
	}
}

