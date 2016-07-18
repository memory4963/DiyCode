#include <iostream>
#include <stdio.h>
using namespace std;

long know(long L, long R);
void kill(long locate, long hurtPoint);
void runIt(long doNum);

long fin[100000];

int main() {
	long n, doNum;
	cin >> n >> doNum;
	runIt(doNum);
	system("pause");
	return 0;
}

inline void runIt(long doNum) {
	int i;
	long  j, k;
	doNum--;
	for (long tmpOut = 0; tmpOut <= doNum; tmpOut++) {
		scanf_s("%d%ld%ld", &i, &j, &k);
		if (i == 1) {
			kill(j, k);
		}
		else {
			cout << know(j, k) << endl;
		}
	}
}

inline long know(long l, long r) {
	long max = 0;           //return sum in the end;
	r--;
	for (int tmpOut = l - 1; tmpOut <= r; tmpOut++) {
		if (fin[tmpOut] > max) {
			max = fin[tmpOut];
		}
	}
	return max;
}

inline void kill(long locate, long hurtPoint) {
	fin[locate - 1] += hurtPoint;
}
