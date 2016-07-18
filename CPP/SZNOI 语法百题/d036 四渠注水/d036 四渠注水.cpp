#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
	float a, b, c, d;
	float d1, d2;
	cin >> a >> b >> c >> d;
	d1 =  (1 / (1 / a + 1 / b));
	d2 =  (1 / (1 / a + 1 / b + 1 / c + 1 / d));
	cout << setprecision(2) << setiosflags(ios::fixed | ios::showpoint)<<d1<<endl;
	cout << setprecision(2) << setiosflags(ios::fixed | ios::showpoint) << d2;
	return 0;
}