#include <iostream>
#include <fstream>
using namespace std;
/*
a is tong
b is the ints
*/
int tongqs(int a[], int b[], int n) {
	int i, j;
	for (i = 1;i <= 1000;i++) {   //Í°µÄ³õÊ¼»¯
		a[i] = 0;
	}
	for (i = 1;i <= n;i++) {
		j = b[i];
		if (a[j] == 0) {
			a[j] = 1;
		}
	};
	return 1;
}
int main() {
	int a[1000], b[100];
	int n, i;
	fstream omyfile,imyfile;
	imyfile.open("random.in", ios_base::in);
	omyfile.open("random.out", ios_base::out);
	if (imyfile.is_open()) {
		imyfile >> n;
		for (i = 1;i <= n;i++) {
			imyfile >> b[i];
		}
		tongqs(a, b, n);
		int t = 0;
		for (i = 1;i <= 1000;i++) {
			if (a[i] == 1) {
				t = t + 1;
			}
		}
		omyfile << t<<endl;
		for (i = 1;i <= 1000;i++) {
			if (a[i] == 1) {
				omyfile << i << ' ';
			}
		}
	}
	imyfile.close();
	omyfile.close();
	return 0;
};