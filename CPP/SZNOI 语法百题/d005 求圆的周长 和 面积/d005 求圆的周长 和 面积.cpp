#include <iostream>
#include <iomanip>
const float pi = 3.1415;
using namespace std;
int main()
{
	float r;
	cin >> r;
	cout << setprecision(2) << setiosflags(ios::fixed | ios::showpoint) << 2 * pi*r << endl;
	cout << setprecision(2) << setiosflags(ios::fixed | ios::showpoint) << pi*r*r;
	return 0;
}