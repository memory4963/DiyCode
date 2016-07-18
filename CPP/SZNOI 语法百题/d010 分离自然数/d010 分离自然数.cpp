#include <iostream>
#include <math.h>
using namespace std;
int main()
{
	int x, y, z, n;
	cin >> n;
	x = floor(n / 100);
	y = floor(n / 10) - 10 * x;
	z = n - 10 * floor(n/10);
	cout << x << " " << y << " " << z;
	return 0;
}