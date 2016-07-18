#include <iostream>
using namespace std;
int main()
{
	int a, b, c, t;
	t = 100;
	for (t; t <= 999; t++)
	{
		a = int(t / 100);
		b = int(t / 10 - 10 * a);
		c = int(t - 100 * a - 10 * b);
			if (t == a*a*a + b*b*b + c*c*c)
				cout << t<<endl;
	};
	return 0;
}