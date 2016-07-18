#include <iostream>
using namespace std;
int main()
{
	int a, b, c;
	cin >> a >> b >> c;
	if (a*a + b*b == c*c || a*a + c*c == b*b || b*b + c*c == a*a)
	{
		cout << "Yes!";
	}
	else
		if (a + b <= c || a + c <= b || b + c <= a)
			cout << "Error!";
		else cout << "No!";
	return 0;
}