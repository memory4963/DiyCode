#include"stdio.h"
#include"stdlib.h"
#include"string.h"
#include"conio.h"
void print_menu();
void	  input();
void 	   show();
void     search();
void    delete1();
void     insert();
struct student
{
	char identity[30];
	char name[15];
	char date_of_birth[8];
	char sex[10];
	char grade_point[2];
};
struct staff
{
	char identity[30];
	char name[15];
	char date_of_birth[8];
	char sex[10];
	char dept[15];
};
struct teacher
{
	char identity[30];
	char name[15];
	char date_of_birth[8];
	char sex[10];
	int  fund;
};
union character
{
	struct student stu;
	struct staff sta;
	struct teacher tea;
};
typedef struct Node
{
	int i;
	union character cha;
	struct Node *next;
}node;
node *head = NULL, *last = NULL, *curreut = NULL, *curreut_last = NULL;

void print_menu()
{
	char a[1];
	int k = 0;
	while (1)
	{
		system("cls");
		if (curreut != NULL)
		{
			if (curreut->i == 1)
			{
				printf_s("\t      +------------+------------+------------+--------------------+--------------+------------+\n\t      |    职业\t   |    姓名\t|    性别    |       证件号       |   出身年月   |    学分    |\n\t      +------------+------------+------------+--------------------+--------------+------------+\n");
				printf_s("\t      |    学生    |%-12s|%-12s|%-20s|%-14s|%-12s|\n", curreut->cha.stu.name, curreut->cha.stu.sex, curreut->cha.stu.identity, curreut->cha.stu.date_of_birth, curreut->cha.stu.grade_point);
				printf_s("\t      +------------+------------+------------+--------------------+--------------+------------+\n\n\n");
			}
			else if (curreut->i == 2)
			{
				printf_s("\t      +------------+------------+------------+--------------------+--------------+------------+\n\t      |    职业\t   |    姓名\t|    性别    |       证件号       |   出身年月   |    部门    |\n\t      +------------+------------+------------+--------------------+--------------+------------+\n");
				printf_s("\t      |    员工    |%-12s|%-12s|%-20s|%-14s|%-12s|\n", curreut->cha.sta.name, curreut->cha.sta.sex, curreut->cha.sta.identity, curreut->cha.sta.date_of_birth, curreut->cha.sta.dept);
				printf_s("\t      +------------+------------+------------+--------------------+--------------+------------+\n\n\n");
			}
			else if (curreut->i == 3)
			{
				printf_s("\t      +------------+------------+------------+--------------------+--------------+------------+\n\t      |    职业\t   |    姓名\t|    性别    |       证件号       |   出身年月   |  科研经费  |\n\t      +------------+------------+------------+--------------------+--------------+------------+\n");
				printf_s("\t      |    老师    |%-12s|%-12s|%-20s|%-14s|%-12d|\n", curreut->cha.tea.name, curreut->cha.tea.sex, curreut->cha.tea.identity, curreut->cha.tea.date_of_birth, curreut->cha.tea.fund);
				printf_s("\t      +------------+------------+------------+--------------------+--------------+------------+\n\n\n");
			}
		}
		if (k == 1)
			printf_s("1   信息录入；\n2   显示所有信息；\n3   证件号查询；\n4   清空当前节点信息；\n5   当前节点后插入一个信息；\n\n》输入错误，请重新选择：");
		else
			printf_s("1   信息录入；\n2   显示所有信息；\n3   证件号查询；\n4   清空当前节点信息；\n5   当前节点后插入一个信息；\n\n》请选择：");
		scanf_s("%s", a);
		if (strcmp(a, "1") == 0)
		{
			k = 0; input();
		}
		else if (strcmp(a, "2") == 0)
		{
			k = 0; show();
		}
		else if (strcmp(a, "3") == 0)
		{
			k = 0; search();
		}
		else if (strcmp(a, "4") == 0)
		{
			k = 0; delete1();
		}
		else if (strcmp(a, "5") == 0)
		{
			k = 0; insert();
		}
		else
			k = 1;
	}
}

void 	   show()
{
	node *p;
	int t = 0;
	system("cls");
	p = head;
	while (p != NULL)
	{
		while (p != NULL)
		{
			if (p->i == 1)
			{
				t++;
				if (t == 1)
					printf_s("\t      +------------+------------+------------+--------------------+--------------+------------+\n\t      |    职业\t   |    姓名\t|    性别    |       证件号       |   出身年月   |    学分    |\n\t      +------------+------------+------------+--------------------+--------------+------------+\n");
				printf_s("\t      |    学生    |%-12s|%-12s|%-20s|%-14s|%-12s|\n", p->cha.stu.name, p->cha.stu.sex, p->cha.stu.identity, p->cha.stu.date_of_birth, p->cha.stu.grade_point);
			}
			p = p->next;
		}
		if (t != 0)
			printf_s("\t      +------------+------------+------------+--------------------+--------------+------------+\n\n\n");

		p = head; t = 0;
		while (p != NULL)
		{
			if (p->i == 2)
			{
				t++;
				if (t == 1)
					printf_s("\t      +------------+------------+------------+--------------------+--------------+------------+\n\t      |    职业\t   |    姓名\t|    性别    |       证件号       |   出身年月   |    部门    |\n\t      +------------+------------+------------+--------------------+--------------+------------+\n");
				printf_s("\t      |    员工    |%-12s|%-12s|%-20s|%-14s|%-12s|\n", p->cha.sta.name, p->cha.sta.sex, p->cha.sta.identity, p->cha.sta.date_of_birth, p->cha.sta.dept);
			}
			p = p->next;
		}
		if (t != 0)
			printf_s("\t      +------------+------------+------------+--------------------+--------------+------------+\n\n\n");

		p = head; t = 0;
		while (p != NULL)
		{
			if (p->i == 3)
			{
				t++;
				if (t == 1)
					printf_s("\t      +------------+------------+------------+--------------------+--------------+------------+\n\t      |    职业\t   |    姓名\t|    性别    |       证件号       |   出身年月   |  科研经费  |\n\t      +------------+------------+------------+--------------------+--------------+------------+\n");
				printf_s("\t      |    老师    |%-12s|%-12s|%-20s|%-14s|%-12d|\n", p->cha.tea.name, p->cha.tea.sex, p->cha.tea.identity, p->cha.tea.date_of_birth, p->cha.tea.fund);
			}
			p = p->next;
		}
		if (t != 0)
			printf_s("\t      +------------+------------+------------+--------------------+--------------+------------+\n\n\n请按任意键继续。。。。。。。");
		_getch();
		print_menu();
	}
	printf_s("\n无任何信息，按任意键退出。。。。。。。");
	_getch();
	print_menu();
}

void     search()
{
	char identity_date[30];
	node *p;
	int t = 0;
	system("cls");
	while (1)
	{
		p = head;
		if (p != NULL)
		{
			printf_s("\n》请输入要查询的证件号：");
			scanf_s("%s", identity_date);
		}
		while (p != NULL)
		{
			if (p->i == 1)
			{
				if (strcmp(p->cha.stu.identity, identity_date) == 0)
				{
					curreut = p; t++;
					printf_s("\t      +------------+------------+------------+--------------------+--------------+------------+\n\t      |    职业\t   |    姓名\t|    性别    |       证件号       |   出身年月   |    学分    |\n\t      +------------+------------+------------+--------------------+--------------+------------+\n");
					printf_s("\t      |    学生    |%-12s|%-12s|%-20s|%-14s|%-12s|\n", curreut->cha.stu.name, curreut->cha.stu.sex, curreut->cha.stu.identity, curreut->cha.stu.date_of_birth, curreut->cha.stu.grade_point);
				}
			}
			else if (p->i == 2)
			{
				if (strcmp(p->cha.sta.identity, identity_date) == 0)
				{
					curreut = p; t++;
					printf_s("\t      +------------+------------+------------+--------------------+--------------+------------+\n\t      |    职业\t   |    姓名\t|    性别    |       证件号       |   出身年月   |    部门    |\n\t      +------------+------------+------------+--------------------+--------------+------------+\n");
					printf_s("\t      |    员工    |%-12s|%-12s|%-20s|%-14s|%-12s|\n", curreut->cha.sta.name, curreut->cha.sta.sex, curreut->cha.sta.identity, curreut->cha.sta.date_of_birth, curreut->cha.sta.dept);
				}
			}
			else if (p->i == 3)
			{
				if (strcmp(p->cha.tea.identity, identity_date) == 0)
				{
					curreut = p; t++;
					printf_s("\t      +------------+------------+------------+--------------------+--------------+------------+\n\t      |    职业\t   |    姓名\t|    性别    |       证件号       |   出身年月   |  科研经费  |\n\t      +------------+------------+------------+--------------------+--------------+------------+\n");
					printf_s("\t      |    老师    |%-12s|%-12s|%-20s|%-14s|%-12d|\n", curreut->cha.tea.name, curreut->cha.tea.sex, curreut->cha.tea.identity, curreut->cha.tea.date_of_birth, curreut->cha.tea.fund);
				}
			}
			p = p->next;
		}
		if (t != 0)
		{
			t = 0;
			printf_s("\t      +------------+------------+------------+--------------------+--------------+------------+\n\n\n请按任意键继续。。。。。。。");
			_getch();
			print_menu();
		}
		else
		{
			printf_s("\n\n\n无任何信息，按任意键退出。。。。。。。");
			_getch();
			print_menu();
		}
	}
}

void    delete1()
{
	system("cls");
	if (curreut != NULL)
	{
		if (curreut == head)
			head = head->next;
		else
		{
			curreut_last = head;
			while (curreut_last->next != curreut)
			{
				curreut_last = curreut_last->next;
			}
			curreut_last->next = curreut->next;
		}
		free(curreut);
		curreut = NULL;
		printf_s("\n\n\n当前节点信息删除成功，按任意键退出。。。。。。。");
	}
	else
	{
		printf_s("\n\n\n当前节点不存在，按任意键退出。。。。。。。");
	}
	_getch();
	print_menu();
}
void     insert()
{
	int k = 0;
	char key_b_in[1], a[1];
	while (1)
	{
		system("cls");
		if (curreut == NULL)
		{
			printf_s("\n\n\n当前节点不存在，按任意键返回。。。。。。。");
			_getch();
			print_menu();
		}
		else
			if (k == 1)
				printf_s("1 插入学生信息\n2 插入员工信息\n3 插入老师信息\n\n》输入有误，请重新选择：");
			else
				printf_s("1 插入学生信息\n2 插入员工信息\n3 插入老师信息\n\n》请选择：");
		scanf_s("%s", a);
		if (strcmp(a, "1") == 0)
		{
			system("cls");
			printf_s("\n请输入以下学生信息：\n\n");
			node   *pnew = (node*)malloc(sizeof(node));
			pnew->next = curreut->next;
			curreut->next = pnew;
			pnew->i = 1;
			printf_s("证件号：");
			scanf_s("%s", pnew->cha.stu.identity);
			printf_s("姓名：");
			scanf_s("%s", pnew->cha.stu.name);
			printf_s("出身年月：");
			scanf_s("%s", pnew->cha.stu.date_of_birth);
			printf_s("性别：");
			scanf_s("%s", pnew->cha.stu.sex);
			printf_s("学分：");
			scanf_s("%s", pnew->cha.stu.grade_point);
			printf_s("\n\n学生%s信息插入成功，按任意键退出。。。。。。。", pnew->cha.stu.name);
			_getch();
			print_menu();
		}
		else if (strcmp(a, "2") == 0)
		{
			system("cls");
			printf_s("\n请录入以下员工信息：\n\n");
			node   *pnew = (node*)malloc(sizeof(node));
			pnew->next = curreut->next;
			curreut->next = pnew;
			pnew->i = 2;
			printf_s("证件号：");
			scanf_s("%s", pnew->cha.sta.identity);
			printf_s("姓名：");
			scanf_s("%s", pnew->cha.sta.name);
			printf_s("出身年月：");
			scanf_s("%s", pnew->cha.sta.date_of_birth);
			printf_s("性别：");
			scanf_s("%s", pnew->cha.sta.sex);
			printf_s("部门：");
			scanf_s("%s", pnew->cha.sta.dept);
			printf_s("\n\n员工%s信息插入成功，按任意键退出。。。。。。。", last->cha.sta.name);
			_getch();
			print_menu();
		}
		else if (strcmp(a, "3") == 0)
		{
			system("cls");
			printf_s("\n请录入以下老师信息：\n\n");
			node   *pnew = (node*)malloc(sizeof(node));
			pnew->next = curreut->next;
			curreut->next = pnew;
			pnew->i = 3;
			printf_s("证件号：");
			scanf_s("%s", pnew->cha.tea.identity);
			printf_s("姓名：");
			scanf_s("%s", pnew->cha.tea.name);
			printf_s("出身年月：");
			scanf_s("%s", pnew->cha.tea.date_of_birth);
			printf_s("性别：");
			scanf_s("%s", pnew->cha.tea.sex);
			printf_s("科研经费：");
			scanf_s("%d", &pnew->cha.tea.fund);
			printf_s("\n\n老师%s信息插入成功，按任意键退出。。。。。。。", pnew->cha.tea.name);
			_getch();
			print_menu();
		}
		else k = 1;
	}
}
void input()
{
	int k = 0;
	char key_b_in[1], a[1];
	while (1)
	{
		system("cls");
		if (k == 1)
			printf_s("1 学生信息录入\n2 员工信息录入\n3 老师信息录入\n\n》输入有误，请重新选择：");
		else
			printf_s("1 学生信息录入\n2 员工信息录入\n3 老师信息录入\n\n》请选择：");
		scanf_s("%s", a);
		if (strcmp(a, "1") == 0)
		{
			while (1)
			{
				system("cls");
				printf_s("\n请输入以下学生信息：\n\n");
				node   *pnew = (node*)malloc(sizeof(node));
				if (head == NULL)
					head = pnew;
				else
					last->next = pnew;
				last = pnew;
				last->next = NULL;
				last->i = 1;
				printf_s("证件号：");
				scanf_s("%s", last->cha.stu.identity);
				printf_s("姓名：");
				scanf_s("%s", last->cha.stu.name);
				printf_s("出身年月：");
				scanf_s("%s", last->cha.stu.date_of_birth);
				printf_s("性别：");
				scanf_s("%s", last->cha.stu.sex);
				printf_s("学分：");
				scanf_s("%s", last->cha.stu.grade_point);
				printf_s("\n\n学生%s信息录入成功，是否继续录入学生信息？（Y 继续,N 返回主菜单）\n》请选择:", last->cha.stu.name);
				scanf_s("%s", key_b_in);
				while ((strcmp(key_b_in, "Y") != 0) && (strcmp(key_b_in, "y") != 0))
				{

					if ((strcmp(key_b_in, "N") == 0) || (strcmp(key_b_in, "n") == 0))
						print_menu();
					else
					{
						system("cls");
						printf_s("\n是否继续录入学生信息？（Y 继续,N 返回主菜单）\n\n\n》输入错误，请重新输入：");
						scanf_s("%s", key_b_in);
					}
				}
			}
		}
		else if (strcmp(a, "2") == 0)
		{
			while (1)
			{
				system("cls");
				printf_s("\n请录入以下员工信息：\n\n");
				node   *pnew = (node*)malloc(sizeof(node));
				if (head == NULL)
					head = pnew;
				else
					last->next = pnew;
				last = pnew;
				last->next = NULL;
				last->i = 2;
				printf_s("证件号：");
				scanf_s("%s", last->cha.sta.identity);
				printf_s("姓名：");
				scanf_s("%s", last->cha.sta.name);
				printf_s("出身年月：");
				scanf_s("%s", last->cha.sta.date_of_birth);
				printf_s("性别：");
				scanf_s("%s", last->cha.sta.sex);
				printf_s("部门：");
				scanf_s("%s", last->cha.sta.dept);
				printf_s("\n\n员工%s信息录入成功，是否继续录入员工信息？（Y 继续,N 返回主菜单）\n》请选择:", last->cha.sta.name);
				scanf_s("%s", key_b_in);
				while ((strcmp(key_b_in, "Y") != 0) && (strcmp(key_b_in, "y") != 0))
				{

					if ((strcmp(key_b_in, "N") == 0) || (strcmp(key_b_in, "n") == 0))
						print_menu();
					else
					{
						system("cls");
						printf_s("\n是否继续录入员工信息？（Y 继续,N 返回主菜单）\n\n\n》输入错误，请重新输入：");
						scanf_s("%s", key_b_in);
					}
				}
			}
		}
		else if (strcmp(a, "3") == 0)
		{
			while (1)
			{
				system("cls");
				printf_s("\n请录入以下老师信息：\n\n");
				node   *pnew = (node*)malloc(sizeof(node));
				if (head == NULL)
					head = pnew;
				else
					last->next = pnew;
				last = pnew;
				last->next = NULL;
				last->i = 3;
				printf_s("证件号：");
				scanf_s("%s", last->cha.tea.identity);
				printf_s("姓名：");
				scanf_s("%s", last->cha.tea.name);
				printf_s("出身年月：");
				scanf_s("%s", last->cha.tea.date_of_birth);
				printf_s("性别：");
				scanf_s("%s", last->cha.tea.sex);
				printf_s("科研经费：");
				scanf_s("%d", &last->cha.tea.fund);
				printf_s("\n\n老师%s信息录入成功，是否继续录入老师信息？（Y 继续,N 返回主菜单）\n》请选择:", last->cha.tea.name);
				scanf_s("%s", key_b_in);
				while ((strcmp(key_b_in, "Y") != 0) && (strcmp(key_b_in, "y") != 0))
				{

					if ((strcmp(key_b_in, "N") == 0) || (strcmp(key_b_in, "n") == 0))
						print_menu();
					else
					{
						system("cls");
						printf_s("\n是否继续录入老师信息？（Y 继续,N 返回主菜单）\n\n\n》输入错误，请重新输入：");
						scanf_s("%s", key_b_in);
					}
				}
			}
		}
		else k = 1;
	}
}

void main()
{
	print_menu();

}

