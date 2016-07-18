#include <iostream>
#include <math.h>
#include <iomanip>
using namespace std;
int main()
{
	float a, b, c;
	float m1, m2;
	cin >> a >> b >> c;
	if ((b*b - 4 * a*c)<0)
	{
		cout << "No answer£¡";
	}
	else
	{
		m1 = (-b + sqrt(b*b - 4 * a*c)) / (2 * a);
		m2 = (-b - sqrt(b*b - 4 * a*c)) / (2 * a);
		if (m1 == m2)
		{
			cout << setprecision(2) << setiosflags(ios::fixed) << m1;
		}
		else
		{
			cout << setprecision(2) << setiosflags(ios::fixed) << m1;
			cout << setprecision(2) << setiosflags(ios::fixed) << m2;
		}
	}
	return 0;
}