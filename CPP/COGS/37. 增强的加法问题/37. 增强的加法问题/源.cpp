#include <iostream>
#include <fstream>
#include <string>
#include <algorithm>
using namespace std;
/*void fsin(string a, string b) { //string input Ô­Àí
	ifstream imyfile;
	imyfile.open("add.in", ios_base::in);
	char t;
	int n;

	if (imyfile.is_open) {
		t = '0';
		n = 0;
		imyfile >> t;
		while (t != ' ') {
			n++;
			a[n] = t;
			imyfile >> t;
		}
		t = '0';
		n = -1;
		while (!EOF) {
			n++;
			b[n] = t;
			imyfile >> t;
			cout << a << b;
		}
	}
}*/
void add(string a, string b, string c) {
	int lena, lenb, lenc, t, n, sum;
	lena = a.size();
	lenb = b.size();
	t = 0;
	while (lena >= 0 & lenb >= 0) {
		lena--;
		lenb--;
		lenc = max(lena, lenb);
		sum = a[lena] + b[lenb] + t;
		t = sum / 10;
		c[lenc] = sum % 10;
	}
	if (c[0] = 0) {
		for (n = 0; n <= max(lena, lenb); n++) {
			c[n] = c[n + 1];
		}
	}
}
int main() {
	//ofstream omyfile;
	//omyfile.open("add.out", ios_base::out);
	string a, b, c;
	cin >> a >> b;
	add(a, b, c);
	cout << c;
	//omyfile << c;
	//omyfile.close();
	system("pause");
	return 0;
}