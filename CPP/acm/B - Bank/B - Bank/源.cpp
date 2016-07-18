#include <iostream>
#include <string>
using namespace std;
int main() {
	int n;
	string have, want;
	cin >> n;
	for (int tmp = 0; tmp <= n - 1; tmp++)
		cin >> have >> want;
	if (want == "0.01")
	{
		if (have == "0.02")
			cout << "0.01";
		if (have == "0.05")
			cout << "0.02";
		if (have >= "0.1")
			cout << "0.07";
	}
	if ((want == "0.02") | (want == "0.05"))
	{
		cout << want;
	}
	if ((want == "0.2") | (want == "0.5"))
	{
		cout << want;
	}
	if ((want == "2") | (want == "5") | (want == "20") | (want == "50"))
	{
		cout << want;
	}
	if (want == "0.1")
	{
		if (have == "0.2")
			cout << "0.1";
		if (have == "0.5")
			cout << "0.2";
		if (have >= "1")
			cout << "0.7";
	}
	if (want == "1")
	{
		if (have == "2")
			cout << "1";
		if (have == "5")
			cout << "2";
		if (have >= "10")
			cout << "7";
	}
	if (want == " 10")
	{
		if (have == "20")
			cout << "1";
		if (have == "50")
			cout << "2";
		if (have >= "100")
			cout << "7";
	}
	return 0;
}
