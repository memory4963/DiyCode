#include <iostream>
#include <fstream>
#include <math.h>
#include <iomanip>
using namespace std;
int solve(float a, float b, float c, float d) {
	float i, n, m, y1, y2;
	fstream omyfile;
	omyfile.open("3cfc.out", ios_base::out);
	if (omyfile.is_open()) {
		for (i = -10000; i <= 10000; i++) {
			n = (float)0.01*i;
			m = (float)0.01*(i + 1);
			y1 = a*(pow(n, 3) + b*pow(n, 2) + c*n + d);
			y2 = a*(pow(m, 3) + b*pow(m, 2) + c*m + d);
			if ((y1>=-0.01&&y2<=0.01)||(y2>=-0.01&&y1<=0.01)) {
				omyfile << setprecision(2) << setiosflags(ios::fixed | ios::showpoint) << m << ' ';
				cout << setprecision(2) << setiosflags(ios::fixed | ios::showpoint) << m << ' ';
				i++;
			}
		}
	}
	omyfile.close();
	return 1;
}
int main() {
	fstream imyfile;
	imyfile.open("3cfc.in", ios_base::in);
	if (imyfile.is_open()) {
		float a, b, c, d;
		imyfile >> a >> b >> c >> d;
		solve(a, b, c, d);
	};
	imyfile.close();
	return 0;
}
