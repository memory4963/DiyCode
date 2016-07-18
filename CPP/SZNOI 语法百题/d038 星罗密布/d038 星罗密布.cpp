#include <iostream>
using namespace std;
int main()
{
	int n, h, x, m;
	cin >> n;
	h = 1;
	for (h; h <= n; h++)
	{
		x = m = 1;
		for (x; x <= 2 * n - 2 * h + 1;x++) cout <<'*';
		for (m; m <= 2 * h - 1; m++) cout <<'$';
		cout << endl;
	}
	return 0;
}