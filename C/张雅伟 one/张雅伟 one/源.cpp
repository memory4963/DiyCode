#include<stdio.h>
#include <stdlib.h>
int main()
{
	float b, c, sum, aver;
	int i;
	sum = 0;
	for (i = 2000;i <= 2015;i++)
	{
		printf("请输入%d年获奖者的出生年份：", i);
		scanf_s("%f", &b);
		c = i - b;
		while (c <= 0)
		{
			printf("输入无效，请重输：");
			printf("请输入%d年获奖者的出生年份：", i);
			scanf_s("%f", &b);
			c = i - b;
		}
		sum = sum + c;
	}
	aver = sum / 16;
	printf("16位诺贝尔文学奖获得者获奖时的平均年龄是%6.1f\n", aver);
	system("pause");
	return 0;
}
