#pragma once
#include<iostream>
using namespace std;
class Clock {
public:
	Clock(int h, int m, int s);
	void SetAlarm(int h, int m, int s);
	void run();
	void showtime() {
		cout << "now: " << hour << ":" << minute << ":" << second << endl;
	}
public:
	int hour;
	int minute;
	int second;
	int Ahour;
	int Aminute;
	int Asecond;
};

Clock::Clock(int h, int m, int s)
{
	if ((h >= 0) && (h < 24)) {
		hour = h;
	}
	else {
		hour = 0;
	}
	if ((m >= 0) && (m < 60)) {
		minute = m;
	}
	else {
		minute = 0;
	}
	if ((s >= 0) && (s < 60)) {
		second = s;
	}
	else {
		second = 0;
	}
}
void Clock::SetAlarm(int h, int m, int s)
{
	if (h >= 0 && h < 24)  Ahour = h;
	else   Ahour = -1;
	if (m >= 0 && m < 60)  Aminute = m;
	else     Aminute = -1;
	if (s >= 0 && s < 60)   Asecond = s;
	else      Asecond = -1;
}
void Clock::run()
{
	hour = (hour + (minute + (second + 1) / 60) / 60) % 24;
	minute = (minute + (second + 1) / 60) % 60;
	second = (second + 1) % 60;
	if (hour == Ahour&&minute == Aminute&&second == Asecond)
		cout << "Plink!plink!plink!..." << endl;
}
