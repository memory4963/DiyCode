#include <iostream>
using namespace std;

int BitFuck(int n);
int AllFuck(int n);
int IntEnd;
int main() {
	int n;
	cin >> IntEnd;
	cout << AllFuck(1);
	system("pause");
	return 0;
}
int AllFuck(int n) {
	if (n == IntEnd-1) {
		return IntEnd;
	}
	else {
		return (1+(n+1)*AllFuck(n+1));
	}
}