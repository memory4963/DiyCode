#include <iostream>
using namespace std;
int main()
{
	int n, t1,t2, i1,i2;
	t1 = 0;
	cin >> n;
	for (t1; t1 <= n; t1++)
	{
		i1 = t1 - 2;
		t2 = 0;
		for (t2; t2 <= i1; t2++)
		{
			cout << ' ';
		}
		i2 = 2 * n - 2*i1-1;
			t2 = 1;
		for (t2; t2 <= i2; t2++)
		{
			cout << '#';
		}
		cout << endl;
	}
	return 0;
}