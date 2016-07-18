#include <iostream>
using namespace std;
bool a[100];
int i,t;
int main()
{
	a[1] = false;
	t = 2;
	for (t; t <= 99; t++)
	{
		a[t] = true;
	};
	t = 2;
	for (t; t <= 50;t++)  //2~50 do fast scan to be devided;
	{
		i = t+1;
			for (i; i <= 99; i++)
			{
				if (i%t == 0) 
				{
					a[i] = false;
				}
			};
	};
	t = 2;
	for (t; t <= 99; t++)
	{
		if (a[t] == true)
		{
			cout << t <<endl;
		};
	};
	return 0;
}