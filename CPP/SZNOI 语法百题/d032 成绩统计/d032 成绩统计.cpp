#include <iostream>
using namespace std;
int main()
{
	int t, n, a, b, c, d, e, f, i;
	cin >> n;
	t = 1;
	a = b = c = d = e = f = 0;
	for (t; t <= n; t++)
	{
		cin >> i;
		if (i == 100) a++;
		else if (i >= 90 && i <= 99) b++;
		else if (i >= 80 && i <= 89) c++;
		else if (i >= 70 && i <= 79) d++;
		else if (i >= 60 && i <= 69) e++;
		else f++;
	}
	cout << a << endl << b << endl << c << endl << d << endl << e << endl << f << endl;
	return 0;
}