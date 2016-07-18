#include <iostream>
using namespace std;
int main()
{
	int a, n, t;;
	cin >> n;
	a = 0;
	for (int t = 1; t <= (n / 2); t++)
	{
		if (n%t==0) 
		{
			a = a + t;
		}
	};
	cout << a+n;
	return 0;
}