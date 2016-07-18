#include <iostream>
using namespace std;
void main() {
	int a=0;
	int* pint = &a;
	cout << hex << a << endl << pint << endl << *pint;
	system("pause");
	return;
}