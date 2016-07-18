#include <iostream>
#include <string>

using namespace std;

char mostpresnet(string fin);
long tot(char chartmp, string a);
void input();
void Tinput();
long solve();
struct node
{
	int strNum[27];
	int Num;
	node *next;
};
int lineNum;
node *head = NULL, *p, *q = NULL, *t = NULL;
int main() {

	long sum = 0;
	cin >> lineNum;

	input();
	Tinput();
	cout << solve();
	return 0;
}
long solve() {
	long max = 0;
	for (int tmp = 0; tmp <= 25; tmp++) {
		node *t = head;
		long count = 0;
		while (t != NULL) {
			int intmp = (t->Num)*(t->strNum[(int)(tmp)]);
			count += intmp;
			t = t->next;
		}
		if (count > max) max = count;
	}
	return max;
}

void Tinput() {
	int tmpNum;
	node *t = head;
	while (t != NULL) {
		cin >> tmpNum;
		t->Num = tmpNum;
		t = t->next;
	}
}

void input() {
	int  otmp;
	string  fin, strtmp;

	for (otmp = 0; otmp <= lineNum - 1; otmp++) {
		cin >> strtmp;
		p = (node *)malloc(sizeof(node));
		for (int intmp = 0; intmp <= 25; intmp++) {
			int strNum = tot((char)(intmp + 'a'), strtmp);
			p->strNum[intmp] = strNum;
		}
		p->next = NULL;
		if (head == NULL) {
			head = p;
		}
		else {
			q->next = p;
		}
		q = p;
	}
}

long tot(char chartmp, string a) {
	long length = a.length();
	long count = 0;
	for (int tmp = 0; tmp <= length - 1; tmp++) {
		if (chartmp == a[tmp]) count++;
	}
	return count;
}













/*char  mostpresnet(string fin)
{
	long app[257];
	int length = fin.length();
	for (int tmp = 0; tmp <= 256; tmp++) {
		app[tmp] = 0;
	}

	for (int tmp = 0; tmp <= length - 1; tmp++) {
		app[(long)fin[tmp]]++;
	}
	int countNum = 0;
	int cNum;
	for (int tmp = 0; tmp <= 255; tmp++) {
		if (app[tmp] > countNum) {
			countNum = app[tmp];
			cNum = tmp;
		}
	}
	return (char)cNum;
}*/