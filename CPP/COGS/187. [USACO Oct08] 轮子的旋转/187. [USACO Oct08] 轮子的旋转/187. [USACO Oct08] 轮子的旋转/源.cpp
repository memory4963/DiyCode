#include <iostream>
#include <fstream>
using namespace std;
int main() {
	fstream imyfile,omyfile;
	imyfile.open("rotation.in", ios_base::in);
	omyfile.open("rotation.out", ios_base::out);
	short result=1;
	if (imyfile.is_open()) {
		int n,tmp;
		
		int Tmp[3];
		imyfile >> n;
		int cycle;
		for (cycle = 1; cycle <= n-1; cycle++){
			tmp=0;
			for (tmp = 0; tmp <= 2; tmp++) {
				imyfile >> Tmp[tmp];
			}
			if (Tmp[2] == 1){
				result = -result;
			}
		}
	}
	if (result == 1) {
		omyfile << '0';
	}
	else {
		omyfile << '1';
	}
	return 0;
}