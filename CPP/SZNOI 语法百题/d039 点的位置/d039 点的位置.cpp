#include <iostream>
#include <cmath>
using namespace std;
int main()
{
	double x, y;
	cin >> x >> y;
	if (abs( x) <= 2 && abs(y) <= 2)
		cout << "True";
	else cout << "False";
	return 0;
}