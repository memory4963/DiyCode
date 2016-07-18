#include <iostream>
#include <fstream>

using namespace std;
int main() {
	int sun[7], InSchool, OutSchool, Tmp, Solve, Max;
	fstream imyfile, omyfile;
	imyfile.open("unhappy.in", ios_base::in);
	omyfile.open("unhappy.out", ios_base::out);
	if (imyfile.is_open()) {
		for (Tmp = 0; Tmp <= 6; Tmp++) {
			imyfile >> InSchool >> OutSchool;
			sun[Tmp] = InSchool + OutSchool;
		}
		Solve = 0;
		Max = 0;
		for (Tmp = 0; Tmp <= 6; Tmp++) {
			if (sun[Tmp] > Max) {
				Solve = Tmp + 1;
				Max = sun[Tmp];
			}
		}
		omyfile << Solve;
	}
	return 0;
}