#include <iostream>
using namespace std;
int main()
{
	int a, b, c, t;
	cin >> a >> b >> c;
	if (b>a)
	{
		t = a;
		a = b;
		b = t;
	};
	if (c>b)
	{
		t = a;
		a = b;
		b = t;
	};
	if (c>a)
	{
		t = a;
		a = c;
		c = t;
	};
	cout << a <<" "<< b<<" " << c;
	return 0;
}