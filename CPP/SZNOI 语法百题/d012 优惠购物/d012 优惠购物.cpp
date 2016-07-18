#include <iostream>
#include <iomanip>
using namespace std;
double a, b;
int main()
{
	cin >> a;
	if (a <= 1000)
	{
		b = 0.95*a;
	}
	else
	{
		b = 950 + 0.9*(a - 1000);
	};
	cout << setprecision(2) << setiosflags(ios::fixed) << b;
	return 0;
}
