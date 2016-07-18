#include <iostream>
#include <string>
using namespace std;
int main()
{
	string a;
	char b='0';
	int t;
	int s = 0;
	cin >> a;
	for (t = 0; b != '#'; t++)
	{
		b = a[t];
		if (b == 'a' || b == 'A')
		{
			s++;
		};
	};
	cout << s;
	return 0;
};