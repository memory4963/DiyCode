#include <iostream>
using namespace std;

long know(long L, long R);
void kill(long locate, long hurtPoint);
void linkBuild(long n);
void runIt(long doNum);

struct node {
	long locate;
	int hurtNum;
	node* next;
};

node *head = NULL, *p = NULL, *t = NULL, *q = NULL;

int main() {
	long n, doNum;
	cin >> n >> doNum;
	linkBuild(n);
	runIt(doNum);
	system("pause");
	return 0;
}

void runIt(long doNum) {
	long i, j, k;
	for (long tmpOut = 0; tmpOut <= doNum - 1; tmpOut++) {
		cin >> i >> j >> k;
		if (i == 1) {
			kill(j, k);
		}
		else if (i == 2) {
			cout << know(j, k) << endl;
		}
	}
}

long know(long l, long r) {
	node *t = head;
	long max = 0;           //return sum in the end;
	while (t->locate != l - 1) {
		t = t->next;
	}
	while (t->locate <= r - 1) {
		if (t->hurtNum > max) {
			max = t->hurtNum;
		}
		if (t->next != NULL) {
			t = t->next;
		}
		else {
			break;
		}
	}
	return max;
}

void kill(long locate, long hurtPoint) {
	node *t = head;
	while (t != NULL) {
		if (t->locate == locate - 1) {
			t->hurtNum += hurtPoint;
			break;
		}
		if (t->next != NULL) {
			t = t->next;
		}
		else {
			break;
		}
	}
}

void linkBuild(long n) {
	for (int otmp = 0; otmp <= n - 1; otmp++) {
		p = new node;
		p->hurtNum = 0;
		p->next = NULL;
		p->locate = otmp;
		if (head == NULL) {
			head = p;
		}
		else {
			q->next = p;
		}
		q = p;
	}
}