#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
	float a, b, c;
	cin >> a >> b >> c;
	float s;
	s = ((a + b)*c) *0.5;
	cout << setprecision(2) << setiosflags(ios::fixed) << s;
	return 0;
}