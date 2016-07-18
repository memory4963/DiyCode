#include <fstream>
#include <math.h>


using namespace std;

int n, FinalNum = 0;
bool Prime[29], Vis[15];
int a[15];

void PrimeSelect(bool Prime[], int n) {
	int TmpO, TmpI;
	//set all of the elements in matrix Prime become true
	for (TmpO = 0; TmpO <= 29; TmpO++) {
		Prime[TmpO] = true;
		a[TmpO] = false;
	}

	Prime[0] = Prime[1] = false;
	for (TmpO = 2; TmpO <= 2 * n + 1; TmpO++) {
		for (TmpI = 2; TmpI <= floor(sqrt(TmpO)); TmpI++) {
			if (TmpO%TmpI == 0) Prime[TmpO] = false;
		}
	}
}


void dfs(int Cursor, int Last) {
	if (Last == n) {
		FinalNum++;

		int tmp;
		fstream omyfile;
		omyfile.open("dfs3.out", ios_base::out);

		for (tmp = 1; tmp <= n; tmp++) omyfile << a[tmp];

		omyfile.close();
		return;
	}
	
	for (tmp = 1; tmp <= n; tmp++) {
		if (Vis[])

	}
};


int main() {
	fstream imyfile, omyfile;
	imyfile.open("dfs3.in", ios_base::in);
	omyfile.open("dfs3.out", ios_base::out);


	if (imyfile.is_open()) {

		imyfile >> n;
		PrimeSelect(Prime, n);

		//test cout mod 
		/*
		int Tmp;
		for (Tmp = 0; Tmp <= n; Tmp++) {
			if (Prime[Tmp]) {
				omyfile << Tmp << ' ';
			}
		}
		*/

		omyfile.close();
		imyfile.close();
	}


}