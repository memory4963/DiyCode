#include <iostream>
using namespace std;

string change();
void stringMaker();
string fin;
int main() {
	stringMaker();
	cout << 'a';
	return 0;
}

string change() {
	int length = fin.length();
	string tmpstr;
	for (int tmp = 0; tmp <= length - 1; tmp++) {
		if (fin[tmp] == 'a') tmpstr[tmp] == 'b';
		if (fin[tmp] == 'b') tmpstr[tmp] == 'a';
	}
	return tmpstr;
}

void stringMaker() {
	while (1) {
		fin += change();
		int length = fin.length();
		if (length >= 1000000) break;
	}

}