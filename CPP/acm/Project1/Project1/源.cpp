#include <iostream>
#include <fstream>
using namespace std;
int fin[400][12];
int main() {
	int Mood = 2;
	bool run = false;
	for (int tmpout = 1; tmpout <= 400; tmpout++) {
		if (((tmpout % 4 == 0) && (tmpout % 100 != 0)) || (tmpout % 400 == 0)) {
			run = true;
		}

		for (int tmpIn = 1; tmpIn <= 12; tmpIn++) {

			switch (tmpIn) {
			case 1: {
				Mood = (Mood + 3) % 7;
				fin[tmpout-1][tmpIn - 1] = Mood;
				break;
			}
			case 2: {
				if (run) {
					Mood = (Mood + 1) % 7;
				}
				fin[tmpout-1][tmpIn - 1] = Mood;
				break;
			}
			case 3: {
				Mood = (Mood + 3) % 7;
				fin[tmpout-1][tmpIn - 1] = Mood;
				break;
			}
			case 4: {
				Mood = (Mood + 2) % 7;
				fin[tmpout-1][tmpIn - 1] = Mood;
				break;
			}

			case 5: {
				Mood = (Mood + 3) % 7;
				fin[tmpout-1][tmpIn - 1] = Mood;
				break;
			}
			case 6: {
				Mood = (Mood + 2) % 7;
				fin[tmpout-1][tmpIn - 1] = Mood;
				break;
			}
			case 7: {
				Mood = (Mood + 3) % 7;
				fin[tmpout-1][tmpIn - 1] = Mood;
				break;
			}
			case 8: {
				Mood = (Mood + 3) % 7;
				fin[tmpout-1][tmpIn - 1] = Mood;
				break;
			}
			case 9: {
				Mood = (Mood + 2) % 7;
				fin[tmpout-1][tmpIn - 1] = Mood;
				break;
			}
			case 10: {
				Mood = (Mood + 3) % 7;
				fin[tmpout-1][tmpIn - 1] = Mood;
				break;
			}
			case 11: {
				Mood = (Mood + 2) % 7;
				fin[tmpout-1][tmpIn - 1] = Mood;
				break;
			}
			case 12: {
				Mood = (Mood + 3) % 7;
				fin[tmpout-1][tmpIn - 1] = Mood;
				break;
			}
			}
		}
		run = false;
	}

	for (int outtmp = 0; outtmp <= 399; outtmp++) {
		for (int intmp = 0; intmp <= 11; intmp++) {
			cout << fin[outtmp][intmp];

		}
		cout << endl;
	}
	system("pause");
	return 0;
}