#include <iostream>

using namespace std;

int fin[400][12];

long long  bigBase(long long year);
int smallBase(long long year, int month, int day);
void matrixBuild();
long long finCount(long long year, int month, int day);
void output(long long yearone, long long yeartwo, int monthone, int monthtwo, int dayone, int daytwo);
const int countInFourHundredYears = 684;
int main() {
	long long yearone, yeartwo;
	int monthone, monthtwo, dayone, daytwo, times;
	matrixBuild();
	cin >> times;
	for (int tmp = 0; tmp <= times - 1; tmp++) {
		cin >> yearone >> monthone >> dayone >> yeartwo >> monthtwo >> daytwo;
		output(yearone, yeartwo, monthone, monthtwo, dayone, daytwo);
	}
	system("pause");
	return 0;
}

void output(long long yearone, long long yeartwo, int monthone, int monthtwo, int dayone, int daytwo) {
	bool yeah = true;
	yeah = ((fin[(yearone % 400) - 1][monthone - 2] == 2) || (((yearone % 400 == 1) && (monthone == 1)))) && (dayone <= 7);
	if (yeah)
		cout << finCount(yeartwo, monthtwo, daytwo) - finCount(yearone, monthone, dayone) + 1 << endl;
	else cout << finCount(yeartwo, monthtwo, daytwo) - finCount(yearone, monthone, dayone) << endl;
}
long long finCount(long long year, int month, int day) {
	return bigBase(year) + smallBase(year, month, day);
}
void matrixBuild() {
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
				fin[tmpout - 1][tmpIn - 1] = Mood;
				break;
			}
			case 2: {
				if (run) {
					Mood = (Mood + 1) % 7;
				}
				fin[tmpout - 1][tmpIn - 1] = Mood;
				break;
			}
			case 3: {
				Mood = (Mood + 3) % 7;
				fin[tmpout - 1][tmpIn - 1] = Mood;
				break;
			}
			case 4: {
				Mood = (Mood + 2) % 7;
				fin[tmpout - 1][tmpIn - 1] = Mood;
				break;
			}

			case 5: {
				Mood = (Mood + 3) % 7;
				fin[tmpout - 1][tmpIn - 1] = Mood;
				break;
			}
			case 6: {
				Mood = (Mood + 2) % 7;
				fin[tmpout - 1][tmpIn - 1] = Mood;
				break;
			}
			case 7: {
				Mood = (Mood + 3) % 7;
				fin[tmpout - 1][tmpIn - 1] = Mood;
				break;
			}
			case 8: {
				Mood = (Mood + 3) % 7;
				fin[tmpout - 1][tmpIn - 1] = Mood;
				break;
			}
			case 9: {
				Mood = (Mood + 2) % 7;
				fin[tmpout - 1][tmpIn - 1] = Mood;
				break;
			}
			case 10: {
				Mood = (Mood + 3) % 7;
				fin[tmpout - 1][tmpIn - 1] = Mood;
				break;
			}
			case 11: {
				Mood = (Mood + 2) % 7;
				fin[tmpout - 1][tmpIn - 1] = Mood;
				break;
			}
			case 12: {
				Mood = (Mood + 3) % 7;
				fin[tmpout - 1][tmpIn - 1] = Mood;
				break;
			}
			}
		}
		run = false;
	}

}
long long  bigBase(long long year) {
	long long countYear;
	countYear = ((year) / 400);
	return countInFourHundredYears * countYear * 7;
}

int smallBase(long long year, int month, int day) {
	int count = 0;
	int bitEnd = year % 400 - 2;
	int outtmp, intmp;
	for (outtmp = 0; outtmp <= bitEnd; outtmp++) {
		for (intmp = 0; intmp <= 11; intmp++) {
			if (fin[outtmp][intmp] == 2) {
				count++;
			}
		}
	}

	for (intmp = 0; intmp <= month - 2; intmp++) {
		if ((fin[bitEnd + 1][intmp] == 2) || (((bitEnd == -1) && (intmp == 0)))) {
			count++;
		}
	}
	count = count * 7;
	if (fin[bitEnd + 1][month - 2] == 2) count = count + day;
	if ((bitEnd == -1) && (month == 1)) count = count + day;
	return count;
}