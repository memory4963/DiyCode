#include <iostream>
using namespace std;
int main()
{
	int a[23], i, n, t;
	a[1] = a[2] = 1;
	i = 3;
	t = 2;
	cin >> n;
	cout << a[1] <<" "<< a[2]<<" ";
	for (i; i <= n; i++)
	{
		a[i] = a[i - 1] + a[i - 2];
		cout << a[i] << " ";
		t++;
		if (t % 5 == 0) cout << endl;
	}
	return 0;
}