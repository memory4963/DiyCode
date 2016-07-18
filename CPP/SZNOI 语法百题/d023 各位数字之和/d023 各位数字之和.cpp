#include <iostream>
#include <string>
using namespace std;
int main()
{
	char a[100];
	int t=0, i=0;
	for (i = 0;i<=100; i++)
	{
		cin.get(a[i]);
		if (a[i] != '\n')
		{
			t = t + (int)(a[i] - '0');
		}
		else
		{
			break;
		}
	};
	cout << t;
	return 0;
}