#include "Clock.h"
#include<iostream>
using namespace std;
int main()
{
	int hour, minute, second;
	int Ahour, Aminute, Asecond;

	cin >> hour >> minute >> second;
	cin >> Ahour >> Aminute >> Asecond;
	Clock c(hour, minute, second);
	c.showtime();
	c.SetAlarm(Ahour, Aminute, Asecond);
	c.run();
	c.showtime();
	system("pause");
	return 0;
}
