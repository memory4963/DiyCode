#include <iostream>
using namespace std;
int main()
{
	int m, n;
	int s = 1, t = 2;
	cin >> m >> n;
	int m1, n1;
	m1 = m;
	n1 = n;
	for (t; t <= m&&t <= n; t++)
	{
		if (m%t == 0 && n%t == 0)
		{
			m = m / t;
			n = n / t;
			s = s*t;
			t=t-1;
		};
	};
	s = s*m*n;
	cout << s << endl;
	return 0;
}