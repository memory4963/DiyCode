# include <stdio.h>
void main(){
	char TmpChar;
	int TmpInt;	
	int sum=0;
	printf("numbers is: ");
	int otmp;
	for (otmp=0;otmp<=2;otmp++){
	 	scanf("%c",&TmpChar);
		TmpInt=(int)TmpChar-(int)'0';
	    sum=sum+TmpInt;
	    if (otmp!=2) scanf("%c",&TmpChar);
	}
	float ava=(float)sum/3;
	printf("the avarage is: %f",ava);
}

