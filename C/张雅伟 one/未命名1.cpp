#include  <stdio.h>
main(){
	int a=1,b=3;
	if ((++a<0)&&!(b--<=0))
		printf(("%d,%d\n"),a,b);
		else printf("%d,%d\n",b,a);
	
}
