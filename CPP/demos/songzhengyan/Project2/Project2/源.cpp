#include<iostream>
#include<Cstring>
#include<conio.h>
#include<fstream>
using namespace std;
class Book {
private:
	char bookname[21];
	char writer[21];
	long ID;
	long publicationdate;
public:
	void SetInfo()
	{
		cin >> bookname >> writer >> ID >> publicationdate;
	}
	char *getName()
	{
		return bookname;
	}
	void PutInfo()
	{
		cout << "书名：" << bookname;
		cout << "\n" << "作者：" << writer << endl;
		cout << "ID：" << ID << endl;
		cout << "出版日期：" << publicationdate << endl;
	}
	void outputToFile() {
		fstream myfile;
		myfile.open("D:/book.txt", ios::app | ios::out);
		if (!myfile) {
			cerr << "文件没有被打开或者没有被创建!" << endl;
			exit(1);
		}
		myfile << bookname << " " << writer << " " << ID << " " << publicationdate;
		myfile.close();
	}
	void inputFromFile(fstream &myfile)
	{
		myfile << bookname << writer << ID << publicationdate;

	}
};
class Library {
private:
	Book bk[100];
	char d;
	int i = 0;
public:
	void AddBook();
	void QueryByName(char *namebook1, int n);
	void ListBook();
};
void Library::AddBook()
{
	fstream myfile;
	myfile.open("D:/book.txt", ios::app);
	if (!myfile) {
		cerr << "文件没有被打开或者没有被创建!" << endl;
		exit(1);
	}
	do {
		bk[i].SetInfo();
		bk[i].outputToFile();
		while (1)
		{
			cout << "是否继续添加图书？" << endl;
			cout << "1.继续添加" << "\n" << "2.结束添加" << endl;
			cin >> d;
			if (d == '1' || d == '2')  break;
			else   cout << "输入错误，请重新输入!" << endl;
		}
		if (d == '2')  break;
		i++;
	} while (i < 100);
	myfile.close();
}
void Library::QueryByName(char *namebook1, int n)
{
	int found = 0;
	fstream myfile;
	myfile.open("D:/book.txt");
	if (!myfile) {
		cerr << "文件没有被打开!" << endl;
		exit(1);
	}
	for (i = 0; bk[i].getName() != 0; i++)
	{
		if (strcmp(bk[i].getName(), namebook1) == 0)
		{
			cout << "已查询到您要查找的图书，信息如下：" << endl;
			bk[i].inputFromFile(myfile);
			bk[i].PutInfo();
			cout << "请按任意键继续!" << endl;
			_getch();
			found = 1;
		}
	}
	if (found == 0) {
		cout << "书库中没有您要查找的书!" << endl;
		cout << "请按任意键继续!" << endl;
		_getch();
	}
}
void Library::ListBook()
{
	fstream myfile;
	myfile.open("D:/book.txt");
	if (!myfile) {
		cerr << "文件不能被打开!" << endl;
		exit(1);
	}
	int k = 0;
	for (i = 0; !myfile.eof(); i++)
	{
		bk[i].inputFromFile(myfile);
		bk[i].PutInfo();
		k = 1;
	}
	if (k == 0) {
		cout << "当前书库没有图书!" << endl;
		cout << "请按任意键返回!" << endl;
		_getch();
	}
	myfile.close();
}
int main()
{
	Library Li;//定义一个对象！！！ 
	char d;
	char bookname[21];
	cout << "~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
	cout << "欢迎进入图书馆管理系统";
	cout << "~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
	while (1)
	{
		cout << "请您选择操作的类型!" << endl;
		cout << "1.添加图书" << endl;
		cout << "2.查询图书" << endl;
		cout << "3.图书列表功能" << endl;
		cout << "4.退出系统" << endl;
		d = _getch();
		if (d == '1') {
			Li.AddBook();
		}
		else if (d == '2') {
			cin >> bookname;
			Li.QueryByName(bookname, strlen(bookname));
		}
		else if (d == '3') {
			Li.ListBook();
		}
		else if (d == '4') {
			cout << "欢迎使用图书馆管理系统，再见!" << endl;
			break;
		}
		else  cout << "输入错误，请重新输入!" << endl;
	}
	return 0;

}