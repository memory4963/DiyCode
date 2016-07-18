#include <iostream>
using namespace std;
char tem='0';
int temi, num, i, ma;
int main()
{
	num = 0;
	ma = 0;
	for (tem; tem != '\n';)
	{
		cin >> tem;
		if (tem != ' ')
		{
			temi = (int)(tem - '0');
			num++;
			if (temi > ma)
			{
				ma = temi;
			};
		};
	};
	cout << num << ma;
	system("pause");
	return 0;
}

