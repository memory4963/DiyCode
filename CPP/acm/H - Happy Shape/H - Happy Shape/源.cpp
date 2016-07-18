#include<stdio.h>
#include<stdlib.h>
#include<math.h>
int ya, yb, r;
double total;
double Calculate(double(*FunCallBack)(double x), double a, double b, double dx)
{
	double doui;
	total = 0;
	for (doui = a; doui <= b; doui += dx)
	{
		total = total + FunCallBack(doui)*dx;
	}
	return total;
}
double min(double a, double b)
{
	return a < b ? a : b;
}
double max(double a, double b)
{
	return a > b ? a : b;
}
double function(double x)
{
	return min(yb, sqrt(r*r - x*x)) - max(ya, -sqrt(r*r - x*x));
}
int main()
{
	int n;
	int cx, cy, x1, x2;
	scanf("%d", &n);
	while (n > 0)
	{
		n--;
		scanf("%d %d %d %d %d %d %d", &cx, &cy, &r, &x1, &ya, &x2, &yb);
		x1 = x1 - cx, x2 = x2 - cx, ya = ya - cy, yb = yb - cy;
		if (ya < 0 && yb>0)
		{
			if (min(x2, r) <= max(x1, -r))
			{
				printf("0.0000\n");
				continue;
			}
			else
			{
				total = Calculate(function, max(x1, -r), min(x2, r), 0.000001);
			}
		}
		if (ya >= 0 && yb >= 0)
		{
			if ((min(x2, r) <= max(x1, -r)) | (ya >= r))
			{
				printf("0.0000\n");
				continue;
			}
			else
			{
				total = Calculate(function, max(x1, max(-r, -sqrt(r*r - ya*ya))), min(x2, min(r, sqrt(r*r - ya*ya))), 0.000001);
			}
		}
		if (ya <= 0 && yb <= 0)
		{
			if (min(x2, r) <= max(x1, -r) | yb <= -r)
			{
				printf("0.0000\n");
				continue;
			}
			else
			{
				total = Calculate(function, max(x1, max(-r, -sqrt(r*r - yb*yb))), min(x2, min(r, sqrt(r*r - yb*yb))), 0.000001);
			}
		}
		printf("%.4lf\n", total);
	}
	return 0;
}
