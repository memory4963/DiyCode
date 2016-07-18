#include <iostream>
using namespace std;
int ma, n, tem, i;
int main()
{
	cin >> n;
	for (int i = 1; i <= n; i++)
	{
		cin >> tem;
		if (tem >= ma)
		{
			ma = tem;
		};
	};
	cout<<ma;
	return 0;
}