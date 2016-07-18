#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
	double a, b, c;
	char t;
	cin >> a >> b;
	cin >> t;
	if (t == '+')
	{
		c=a + b;
	};
	if (t == '-')
	{
		c=a - b;
	};
	if (t == '*')
	{
		c=a*b;
	};
	if (t == '/' )
	{
		c=a / b;
	};
	cout << setprecision(2) << setiosflags(ios::fixed) << c;
	return 0;	
}
