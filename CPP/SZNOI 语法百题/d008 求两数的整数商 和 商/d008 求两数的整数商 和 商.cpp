#include <iostream>
#include <iomanip>
#include <math.h>
using namespace std;
int main()
{
	int a, b;
	cin >> a >> b;
	double c;
	c =(float) a / b;
	cout << floor(c)<<" " ;
	cout << setprecision(2) <<setiosflags(ios::fixed) << c;
	return 0;
}