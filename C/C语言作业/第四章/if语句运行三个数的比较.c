/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{	int a,b,c,max;
	printf("������������");
	scanf("%d,%d,%d,%d",&a,&b,&c,&max);
   if(a>b) 	{ max=a; }
	else	{ max=b;}
	if(c>max) { max=c; }
	printf("a=%d,b=%d,c=%d,���ֵmax:%d",a,b,c,max);
 
}