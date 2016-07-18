#include <fstream>
using namespace std;
int main() {
	fstream imyfile, omyfile;
	imyfile.open("apple.in");
	omyfile.open("apple.out");
	if (imyfile.is_open) {
		int sum, temp,hight[10],highttt;
		for (temp = 1; temp <= 10; temp++) {
			imyfile >> hight[temp];
			hight[temp] = hight[temp] - 30;
		}
		imyfile >> highttt;
		sum = 0;
		for (temp = 1; temp <= 10; temp++) {
			if (hight[temp] <= highttt) sum++;
		}
		omyfile << sum;
		imyfile.close;
		omyfile.close;
		system("pause");
		return 0;
	}
}