/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
 int a,b,t,p,i;
 	printf("������������");
	scanf("%d,%d",&a,&b); 
	if(a<b)//ȷ��a>b
	{
		
		t=b;
		b=a;
		a=t;	
		
	}
	for(i=1;i<a;i++)
	{
		if(a%i==0 && b%i==0)
		{
			p=i;	
			
		}	
		
	}
	printf("%d��%d�����������%d\n",a,b,p);
	printf("%d��%d����С��������%d",a,b,a*b/p);   
}