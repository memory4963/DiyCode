#include <iostream>;
using namespace std;	
int main()
{
	int s, a, b;
	cin >> s;
	a = b = 1;
	for (a; a <= 120; a++)
	{
		b = 1;
		for (b; b <= 12; b++)
		{
			if (((2 * b + 5) * 50 + a - 365) == s)
			{
				cout << a << " " << b << endl;
				break;
			}
		}
		if (((2 * b + 5) * 50 + a - 365) == s) break;
	}
	return 0;
}