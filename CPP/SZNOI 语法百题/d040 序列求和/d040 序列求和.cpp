#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
	float n, m, t;
	cin >> n;
	m = 1;
	t = 0;
	for (m; m <= n; m++) t = t + (1 / m);
	cout << setprecision(6)<< setprecision(ios::fixed|ios::showpoint) << t;
	system("pause");
	return 0;
}