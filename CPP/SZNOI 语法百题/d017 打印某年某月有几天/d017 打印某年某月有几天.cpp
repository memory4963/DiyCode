#include <iostream>
using namespace std;
int main()
{
	int a, b,t;
	t = 0;
	cin >> a >> b;
	if (b == 1||b==3||b==5 || b == 7 || b == 8 || b == 10 || b == 12)
	{
		t=31;
	}
	else
	{
		if (b == 4 || b == 6 || b == 9 || b == 11)
		{
			t=30;
		}
		else 
		{
			if (b == 2)
			{
				if (a % 4 == 0)
				{
					t = 29;
				}
				else
				{
					t = 28;
				}
			}
		}
	}
	cout << t;
	return 0;
}