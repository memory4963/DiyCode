#include <iostream>
using namespace std;
int main()
{
	int a, b, c;
	a = b = c = 0;
	for (a; a <= 100; a++)
	{
		b = 0;
		for (b; b <= 100; b++)
		{
			c = 0;
			for (c; c <= 34; c++)
			{
				if ((a + b + 3 * c == 100) && (50 * a + 10 * b + c == 500))
					cout << a <<" "<< b <<" "<< 3 * c << endl;
			}
		}
			
	}
	return 0;
}