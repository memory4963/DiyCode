#include <iostream>
#include <iomanip>
#include <math.h>
using namespace std;
int main()
{
	float a, b, s;
	cin >> a >> b;
	cout<<endl;
	s = a / b;
	cout << floor(s)<<" ";
	cout << a-b*floor(s);
	return 0;
}