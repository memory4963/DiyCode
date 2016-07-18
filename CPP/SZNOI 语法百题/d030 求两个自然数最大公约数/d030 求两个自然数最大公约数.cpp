#include <iostream>
using namespace std;
int max(int a , int b)
{
	if (a > b) return a;
	if (a < b) return b;
	return 1;
}
int main()
{
	int a, b, c, t, s;
	cin >> a >> b;
	c = max(a, b);
	t = 1;
	for (t; t <= c; t++)
	{
		if ((a%t == 0) && (b%t == 0))
			s = t;
	}
	cout << s;
	return 0;
}