#include <iostream>
using namespace std;
int main()
{
	int t1, t2,a,b,c,d;
	for (int a = 1; a <= 9; a++)
	{
		for (int b = 0; b <= 9; b++)
		{
			for (int c = 0; c <= 9; c++)
			{
				for (int d = 0; d <= 9; d++)
				{
					t1 = 10 * a + b;
					t2 = 10 * c + d;
					if ((t1+t2)*(t1+t2)==(1000*a+100*b+10*c+d))
					{
						cout<< a << b << c << d <<endl;
					};
				};
			};
		};
	};
	system("pause");
	return 0;
}