#include <iostream>
#include <iomanip>
#include <math.h>
using namespace std;
int main()
{
	float a, b, c, t, s;
	cin >> a >> b >> c;
	if (a + b <= c || a + c <= b || b + c <= a) cout << "Data Error£¡";
	else
	{
		t = (a + b + c) / 2;
		s = sqrtf(t*(t - a)*(t - b)*(t - c));
		cout << setprecision(2) << setiosflags(ios::fixed | ios::showpoint) << s;
	}
	return 0;
}