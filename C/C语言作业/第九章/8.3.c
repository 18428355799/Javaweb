/* Note:Your choice is C IDE */
#include<stdio.h>
#include<math.h>
void main()
{
 int m,i,k;
 printf("������һ��������");
 scanf("%d",&m);
 k=(int)sqrt(m);
	 for(i=2;i<=k;i++)
	 if(m%i==0)
	 break;
	 if(i>k)
	 printf("%d ��������\n",m);
	 else
	 printf("%d ����������\n",m);
}